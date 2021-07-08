import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Proyecto Aeropuerto';
  list = [
    "Vuelo",
    "Terminal",
    "Pasajero"
  ]
  showFiller = false;

  constructor() { }
}
