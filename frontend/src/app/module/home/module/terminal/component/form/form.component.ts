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
  update: boolean = false;

  constructor(private terminalService: TerminalService,
    private router: Router,
    private route: ActivatedRoute) {
    if (history.state.idTerminal == null) {
      this.terminalFinal = new Terminal();
      this.terminalFinal.objetosPerdidos = [];
    } else {
      console.log(history.state)
      this.update = true;
      this.terminalFinal = history.state;
    }
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.terminalFinal)
    if (!this.update) {
      this.terminalService.add(this.terminalFinal).subscribe(res => {
        console.log(res);
        this.router.navigate(['home/terminal/lista']);
      });
    } else {
      this.terminalService.update(this.terminalFinal).subscribe(res => {
        console.log(res);
        this.router.navigate(['/home/terminal/lista']);
      });
    }
  }

  addObjetoPerdido() {
    this.terminalFinal.objetosPerdidos.push(new ObjetoPerdido());
  }
}
