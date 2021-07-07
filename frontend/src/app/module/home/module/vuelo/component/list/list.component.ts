import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pasajero } from 'src/app/model/pasajero';
import { Vuelo } from 'src/app/model/vuelo';
import { PasajeroService } from 'src/app/service/pasajero.service';
import { VueloService } from 'src/app/service/vuelo.service';
import { VueloModule } from '../../vuelo.module';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'idTerminal', 'compania', 'fecha', 'destino', 'origen', 'duracion','add', 'delete'];
  vuelos: Vuelo[] = [];

  constructor(private vueloService: VueloService,
    private router: Router,
    private route: ActivatedRoute) {
   }

  ngOnInit(): void {
    this.getVuelos();
  }

  getVuelos(){
    this.vueloService.getAll().subscribe(result =>{
      this.vuelos = result;
    })
  }
}
