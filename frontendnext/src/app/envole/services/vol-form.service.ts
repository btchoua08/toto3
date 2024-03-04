import { Injectable } from '@angular/core';
import { VolFormValue } from '../../envole/models/vol-form-value.model';
import { catchError, delay, mapTo, Observable, of } from 'rxjs';
import {HttpClient ,HttpHeaders,HttpResponse, HttpEventType, HttpRequest, HttpEvent} from '@angular/common/http';
import { environement } from '../../environments/environment';
@Injectable()
export class VolFormService {

    env = environement ;
 
  constructor(private http: HttpClient) {}

  saveVol(formValue: VolFormValue): Observable<boolean> {
    console.log('vols data:',formValue);
    let headers = new HttpHeaders({
      'Content-Type' : 'application/json; charset=UTF-8'
    });
    let url ='/'+formValue.volInfo.numpilote+'/'+formValue.volInfo.numavion+'/createVol';
    let postVars =null; 
    const pass ="";
       postVars = JSON.stringify({
        numvol: formValue.volInfo.numvol,
        numpilote: formValue.volInfo.numpilote,
        numavion: formValue.volInfo.numavion,
        villedep: formValue.volInfo.villedep,
        villearr: formValue.volInfo.villearr,
        heuredep: formValue.volInfo.heuredep,
        heurearr: formValue.volInfo.heurearr
      });
      console.log('postVars:',postVars);
    return this.http.post(`${this.env.apiUrl}${url}`, postVars,{headers: headers}).pipe(
      mapTo(true),
      catchError(() => of(false).pipe(
        delay(1000)
      ))
    );
  }

}