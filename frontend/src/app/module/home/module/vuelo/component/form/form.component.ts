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
    update: boolean = false;

  constructor(private vueloService: VueloService,
    private terminalService: TerminalService,
    private router: Router,
    private route: ActivatedRoute) {
    if (history.state.id_vuelo == null) {
      this.vueloFinal = new Vuelo();
    } else {

      this.update = true;
      this.vueloFinal = history.state;
      this.form.setValue(this.vueloFinal.id_terminal);
      console.log(this.vueloFinal)
    }
  }

  ngOnInit(): void {
    this.getTerminales();
  }

  submit() {
    console.log(this.vueloFinal)
    this.vueloFinal.id_terminal = this.form.value;
    if(!this.update){
      console.log("no update")
    this.vueloService.add(this.vueloFinal).subscribe(res => {
      console.log(res);
      this.router.navigate(['/home/vuelo/lista']);
    });
  } else {
    this.vueloService.update(this.vueloFinal).subscribe(res => {
      console.log(res);
      this.router.navigate(['/home/vuelo/lista']);
    });
  }
  }

  getTerminales() {
    this.terminalService.getAll().subscribe(res => {
      this.terminales = res;
    })
  }

}
