import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ObjetoPerdido } from 'src/app/model/objeto-perdido';
import { Terminal } from 'src/app/model/terminal';
import { TerminalService } from 'src/app/service/terminal.service';
import { TerminalModule } from '../../terminal.module';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nombre', 'nPuertas', 'add', 'delete'];
  terminales: Terminal[] = [];

  constructor(private terminalService: TerminalService,
    private router: Router,
    private route: ActivatedRoute) {
   }

  ngOnInit(): void {
    this.getTerminales();
  }

  getTerminales(){
    this.terminalService.getAll().subscribe(result =>{
      console.log(result)
      this.terminales = result;
    })
  }

  delete(id: number){
    this.terminalService.delete(id).subscribe();
    this.getTerminales();
  }

  edit(terminal: Terminal){
    this.router.navigateByUrl('/home/terminal/form', { state: terminal });
  }
}
