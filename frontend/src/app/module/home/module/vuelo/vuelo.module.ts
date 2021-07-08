import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VueloRoutingModule } from './vuelo-routing.module';
import { ListComponent } from './component/list/list.component';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormComponent } from './component/form/form.component';


@NgModule({
  declarations: [
    ListComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    VueloRoutingModule,
    MatTableModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class VueloModule { }
