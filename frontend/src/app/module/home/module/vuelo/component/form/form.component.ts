import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Pasajero } from 'src/app/model/pasajero';
import { Terminal } from 'src/app/model/terminal';
import { Vuelo } from 'src/app/model/vuelo';
import { TerminalService } from 'src/app/service/terminal.service';
import { VueloService } from 'src/app/service/vuelo.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  form: FormControl = new FormControl();
  terminales: Terminal[] = [];
  vueloFinal: Vuelo;

  constructor(private vueloService: VueloService,
    private terminalService: TerminalService,
    private router: Router,
    private route: ActivatedRoute) {
    this.vueloFinal = new Vuelo();
   }

  ngOnInit(): void {
    this.getTerminales();
  }

  submit(){
    this.vueloFinal.idTerminal = this.form.value.idTerminal;
    this.vueloService.add(this.vueloFinal).subscribe(res =>{
      console.log(res);
      this.router.navigate(['/home/vuelo/lista']);
    });
  }

  getTerminales(){
    this.terminalService.getAll().subscribe(res => {
      this.terminales = res;
    })
  }

}
