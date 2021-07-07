import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Pasajero } from 'src/app/model/pasajero';
import { Vuelo } from 'src/app/model/vuelo';
import { PasajeroService } from 'src/app/service/pasajero.service';
import { TerminalService } from 'src/app/service/terminal.service';
import { VueloService } from 'src/app/service/vuelo.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  form: FormControl = new FormControl();
  vuelos: Vuelo[] = [];
  pasajeroFinal: Pasajero;



  constructor(private vueloService: VueloService,
    private pasajeroService: PasajeroService,
    private router: Router,
    private route: ActivatedRoute) {
    this.pasajeroFinal = new Pasajero();
  }

  ngOnInit(): void {
    this.getVuelos();
  }

  submit() {
    this.pasajeroFinal.idVuelo = this.form.value;
    this.pasajeroService.add(this.pasajeroFinal).subscribe(res => {
      console.log(res);
      this.router.navigate(['/home/pasajero/lista']);
    });
  }

  getVuelos() {
    this.vueloService.getAll().subscribe(res => {
      this.vuelos = res;
    })
  }

}
