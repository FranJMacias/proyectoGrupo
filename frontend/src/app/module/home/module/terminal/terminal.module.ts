import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TerminalRoutingModule } from './terminal-routing.module';
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
    TerminalRoutingModule,
    MatTableModule,
    FormsModule,
    ReactiveFormsModule,
    MatSelectModule
  ]
})
export class TerminalModule { }
