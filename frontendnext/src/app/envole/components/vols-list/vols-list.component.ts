import { ChangeDetectionStrategy, Component, ViewChild, OnDestroy, OnInit } from '@angular/core';
import {
  combineLatest,
  debounceTime,
  distinctUntilChanged,
  map,
  Observable,
  startWith,
  Subject,
  tap,
  switchMap,
  takeUntil
} from 'rxjs';
import { Vols } from '../../models/vols.model';
import { EnvoleService } from '../../services/envole.service';
import { AbstractControl, FormGroup,  UntypedFormBuilder, Validators } from '@angular/forms';
import { VolFormService } from '../../services/vol-form.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort, MatSortModule} from '@angular/material/sort';
import {LiveAnnouncer} from '@angular/cdk/a11y';
import { Pilote } from '../../models/pilote.model';
import { Avion } from '../../models/avion.model';

@Component({
  selector: 'app-vols-list',
  templateUrl: './vols-list.component.html',
  styleUrls: ['./vols-list.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})


export class VolsListComponent implements OnInit, OnDestroy {

 
  private destroy$!: Subject<boolean>;
  loading$!: Observable<boolean>;
  vols$!: Observable<Vols[]>;
  pilote$!: Observable<Pilote[]>;
  avion$!: Observable<Avion[]>;

  displayedColumns: string[] = ['numvol', 'numpilote', 'numavion', 'villedep',"villearr","heuredep","heurearr"];
  displayHour:string[]=['06:34','23:30','14:30','12:33','17:22','10:00','07:09','04:25','22:10','16:30','20:30','13:14','00:30','04:30','10:20','12:15','17:45','06:30','13:21'];
  loading = false;
  mainForm!: FormGroup;
  volInfoForm!: FormGroup;
  dataSource: MatTableDataSource<Vols> =new MatTableDataSource;
  dataSource$!: Observable<MatTableDataSource<Vols>>
  constructor(
    private  envoleService: EnvoleService,
    private _snackBar: MatSnackBar,
    private _liveAnnouncer: LiveAnnouncer,
             private formBuilder: UntypedFormBuilder,
             private volFormService: VolFormService
    ) {
     
  }

  ngOnInit(): void {
    this.pilote$ = this.envoleService.pilote$.pipe();
    this.avion$ = this.envoleService.avion$.pipe();
    this.initFormControls();
    this.initMainForm();
    this.destroy$ = new Subject<boolean>();
    this.envoleService.getEnvole();
    this.envoleService.getAvion();
    this.envoleService.getPilote();
 
    this.dataSource$=this.envoleService.vols$.pipe(
      map(data =>{
        const dataSource = this.dataSource;
        dataSource.data = data;
        return dataSource;
      })
         
    )
   
  }

  @ViewChild(MatSort) sort!: MatSort;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }


  ngOnDestroy() {
    this.destroy$.next(true);
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  initFormControls() {
    this.volInfoForm = this.formBuilder.group({
      numvol: ['', Validators.required],
      numpilote: ['', Validators.required],
      numavion: ['', Validators.required],
      villedep: ['', Validators.required],
      villearr: ['', Validators.required],
      heuredep: ['', Validators.required],
      heurearr: ['', Validators.required]
    });
   
  }
  
  get f(){
    return this.mainForm.controls;
  }
  
  
     
  
  initMainForm() {
    this.mainForm = this.formBuilder.group({
      volInfo: this.volInfoForm
    });
  }
  
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }
  
  onSubmitForm() {
    this.loading = true;
    this.volFormService.saveVol(this.mainForm.value).pipe(
      tap(response => {
        this.loading = false;
        if (response){
          this.mainForm.reset();
         this.openSnackBar("Ajout avec success","OK");
        }else{
          this.loading = false;
          this.openSnackBar("Erreur lors de l'ajout du vol merci de reesayer","OK");
        }
       
      })
    ).subscribe();
  }
  
  getErrorMessage(ctrl: AbstractControl): string {
    if (ctrl.hasError('required')) {
      return 'le champ est oglicatoire';
    }  else {
      return 'Champ  invalide';
    }
  }

  /** Announce the change in sort state for assistive technology. */
  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}

