import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
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

  @ViewChild('terminal') terminal!: ElementRef;
  @ViewChild('compania') compania!: ElementRef;
  @ViewChild('origen') origen!: ElementRef;
  @ViewChild('destino') destino!: ElementRef;

  displayedColumns: string[] = ['id', 'idTerminal', 'compania', 'fecha', 'destino', 'origen', 'duracion', 'add', 'delete'];
  vuelos: Vuelo[] = [];

  constructor(private vueloService: VueloService,
    private router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getVuelos();
  }

  getVuelos() {
    this.vueloService.getAll().subscribe(result => {
      console.log(result)
      this.vuelos = result;
    })
  }

  delete(id: number) {
    this.vueloService.delete(id).subscribe(res => this.getVuelos());
  }

  edit(vuelo: Vuelo) {
    this.router.navigateByUrl('/home/vuelo/form', { state: vuelo });
  }

  filterTerminal() {
    this.vueloService.filterTerminal(this.terminal.nativeElement.value).subscribe(res => this.vuelos = res)
  }

  filterCompania() {
    this.vueloService.filterCompañia(this.compania.nativeElement.value).subscribe(res => this.vuelos = res)
  }

  filterOrigen() {
    this.vueloService.filterOrigen(this.origen.nativeElement.value).subscribe(res => this.vuelos = res)
  }

  filterDestino() {
    this.vueloService.filterDestino(this.destino.nativeElement.value).subscribe(res => this.vuelos = res)
  }
}
