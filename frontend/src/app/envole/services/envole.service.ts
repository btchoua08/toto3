import { Injectable } from "@angular/core";
 import {HttpClient} from '@angular/common/http';
import { Vols } from "../models/vols.model";
import { Avion } from "../models/avion.model";
import {Pilote} from "../models/pilote.model";
import { BehaviorSubject, delay, map, Observable, switchMap, take, tap } from 'rxjs';
import { environement } from "src/app/environments/environment";

@Injectable()
export class EnvoleService{
  private _loading$ = new BehaviorSubject<boolean>(false);
  get loading$(): Observable<boolean> {
    return this._loading$.asObservable().pipe(
      delay(0)
    );
  }
  private _vols$ = new BehaviorSubject<Vols[]>([]);
  get vols$(): Observable<Vols[]> { return this._vols$.asObservable(); }

  private _avions$ = new BehaviorSubject<Avion[]>([]);
  get avion$(): Observable<Avion[]> { return this._avions$.asObservable(); }

  private _pilote$ = new BehaviorSubject<Pilote[]>([]);
  get pilote$(): Observable<Pilote[]> { return this._pilote$.asObservable(); }


  private allVolsLastLoad!: number;
  private allAvionsLastLoad!: number;
  private allPiloteLastLoad!: number;
  constructor(private http: HttpClient) {}
    

    getEnvole() {
      if (Date.now() - this.allVolsLastLoad <= 10000) {
        return;
      }
      
      this.setLoadingStatus(true);
      this.http.get<Vols[]>(`${environement.apiUrl}/listvol`).pipe(
        delay(1000),
        tap(vols => {
          this.allVolsLastLoad = Date.now();
          this._vols$.next(vols);
          this.setLoadingStatus(false);
        })
      ).subscribe();
    }

    getAvion(){
      if (Date.now() - this.  allAvionsLastLoad <= 10000) {
        return;
      }
      
      this.setLoadingStatus(true);
      this.http.get<Avion[]>(`${environement.apiUrl}/listavion`).pipe(
        delay(1000),
        tap(vols => {
          this.allAvionsLastLoad = Date.now();
          this._avions$.next(vols);
          this.setLoadingStatus(false);
        })
      ).subscribe();
    }

    getPilote(){
      if (Date.now() - this.  allPiloteLastLoad <= 10000) {
        return;
      }
      
      this.setLoadingStatus(true);
      this.http.get<Pilote[]>(`${environement.apiUrl}/listpilote`).pipe(
        delay(1000),
        tap(pilotes => {
          this.allPiloteLastLoad = Date.now();
          this._pilote$.next(pilotes);
          this.setLoadingStatus(false);
        })
      ).subscribe();
    }

    private setLoadingStatus(status: boolean) {
      this._loading$.next(status);
    }

   



}