import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Terminal } from '../model/terminal';

@Injectable({
  providedIn: 'root'
})
export class TerminalService {

  url = environment.API + 'terminal';

  constructor(private http: HttpClient) { }

  public add(terminal: Terminal): Observable<Terminal> {
    return this.http.post<Terminal>(this.url, terminal);
  }
  public update(terminal: Terminal) {
    return this.http.put<Terminal>(this.url, terminal);
  }
  public delete(id: number) {
    return this.http.delete<Terminal>(this.url + '/' + id);
  }
  public getAll(): Observable<Terminal[]> {
    return this.http.get<Terminal[]>(this.url);
  }
  public getById(id: number): Observable<Terminal> {
    return this.http.get<Terminal>(this.url + '/' + id);
  }
}
