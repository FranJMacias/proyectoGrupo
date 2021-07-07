import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Vuelo } from '../model/vuelo';

@Injectable({
  providedIn: 'root'
})
export class VueloService {

  url = environment.API + 'vuelo';

  constructor(private http: HttpClient) { }

  public add(vuelo: Vuelo): Observable<Vuelo> {
    return this.http.post<Vuelo>(this.url, vuelo);
  }
  public update(vuelo: Vuelo) {
    this.http.put<Vuelo>(this.url, vuelo);
  }
  public delete(id: number) {
    this.http.delete<Vuelo>(this.url + '/' + id);
  }
  public getAll(): Observable<Vuelo[]> {
    return this.http.get<Vuelo[]>(this.url + 's');
  }
  public getById(id: number): Observable<Vuelo> {
    return this.http.get<Vuelo>(this.url + '/' + id);
  }
}
