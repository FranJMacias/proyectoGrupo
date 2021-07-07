import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'vuelo'
  },
  {
    path: 'vuelo',
    loadChildren: () => import('./module/vuelo/vuelo.module').then(m => m.VueloModule)
  },
  {
    path: 'terminal',
    loadChildren: () => import('./module/terminal/terminal.module').then(m => m.TerminalModule)
  },
  {
    path: 'pasajero',
    loadChildren: () => import('./module/pasajero/pasajero.module').then(m => m.PasajeroModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
