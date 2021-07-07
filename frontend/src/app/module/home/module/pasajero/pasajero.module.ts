import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PasajeroRoutingModule } from './pasajero-routing.module';
import { ListComponent } from './component/list/list.component';
import {MatTableModule} from '@angular/material/table';
import { FormComponent } from './component/form/form.component';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    PasajeroRoutingModule,
    MatTableModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PasajeroModule { }
