import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pasajero } from 'src/app/model/pasajero';
import { PasajeroService } from 'src/app/service/pasajero.service';
import { PasajeroModule } from '../../pasajero.module';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'idVuelo', 'nombre', 'nif', 'telefono', 'email', 'add', 'delete'];
  pasajeros: Pasajero[] = [];

  constructor(private pasajeroService: PasajeroService,
    private router: Router,
    private route: ActivatedRoute) {
   }

  ngOnInit(): void {
    this.getPasajeros();
  }

  getPasajeros(){
    this.pasajeroService.getAll().subscribe(result =>{
      this.pasajeros = result;
    })
  }
}
