import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './component/list/list.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'lista'
  },
  {
    path: 'lista',
    component: ListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PasajeroRoutingModule { }
