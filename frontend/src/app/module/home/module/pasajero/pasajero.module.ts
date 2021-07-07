import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PasajeroRoutingModule } from './pasajero-routing.module';
import { ListComponent } from './component/list/list.component';


@NgModule({
  declarations: [
    ListComponent
  ],
  imports: [
    CommonModule,
    PasajeroRoutingModule
  ]
})
export class PasajeroModule { }
