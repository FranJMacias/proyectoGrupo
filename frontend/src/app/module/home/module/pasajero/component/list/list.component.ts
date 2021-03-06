import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
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

  @ViewChild('nif') nif!: ElementRef;

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

  delete(id: number){
    this.pasajeroService.delete(id).subscribe(res=>this.getPasajeros());
  }

  edit(pasajero: Pasajero){
    this.router.navigateByUrl('/home/pasajero/form', { state: pasajero });
  }

  filterNif(){
    this.pasajeroService.filterNif(this.nif.nativeElement.value).subscribe(res=> this.pasajeros = res);
  }
}
