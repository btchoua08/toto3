import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { EnvoleService } from './services/envole.service';
import { VolsListComponent } from './components/vols-list/vols-list.component';
import { SharedModule } from '../shared/shared.module';
import { VolFormService } from './services/vol-form.service';


@NgModule({
  declarations: [
    VolsListComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers:[
    EnvoleService,
    VolFormService
  ],
  exports:[
    VolsListComponent
  ]
})
export class EnvoleModule { }
