import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Vuelo } from 'src/app/model/vuelo';
import { FormComponent } from './component/form/form.component';
import { ListComponent } from './component/list/list.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'lista'
  },
  {
    path: 'lista',
    component: ListComponent
  },
  {
    path: 'form',
    component: FormComponent  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VueloRoutingModule { }
