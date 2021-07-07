import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ObjetoPerdido } from 'src/app/model/objeto-perdido';
import { Pasajero } from 'src/app/model/pasajero';
import { Terminal } from 'src/app/model/terminal';
import { Vuelo } from 'src/app/model/vuelo';
import { TerminalService } from 'src/app/service/terminal.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  form: FormControl = new FormControl();
  terminalFinal: Terminal;

  constructor(private terminalService: TerminalService,
    private router: Router,
    private route: ActivatedRoute) {
    this.terminalFinal = new Terminal();
    this.terminalFinal.objetosPerdidos = [];
  }

  ngOnInit(): void {
  }

  submit(){
    console.log(this.terminalFinal)
    this.terminalService.add(this.terminalFinal).subscribe(res =>{
      console.log(res);
      this.router.navigate(['home/terminal/lista']);
    });
  }

  addObjetoPerdido(){
    this.terminalFinal.objetosPerdidos.push(new ObjetoPerdido());
  }
}
