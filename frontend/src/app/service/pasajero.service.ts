import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pasajero } from '../model/pasajero';

@Injectable({
  providedIn: 'root'
})
export class PasajeroService {

  url = environment.API + 'pasajero';

  constructor(private http: HttpClient) { }

  public add(pasajero: Pasajero): Observable<Pasajero>{
    return this.http.post<Pasajero>(this.url, pasajero);
  }
  public update(pasajero: Pasajero){
    return this.http.put<Pasajero>(this.url, pasajero);
  }
  public delete(id: number){
     return this.http.delete<Pasajero>(this.url + '/' + id);
  }
  public getAll(): Observable<Pasajero[]>{
    return this.http.get<Pasajero[]>(this.url);
  }
  public getById(id: number): Observable<Pasajero>{
    return this.http.get<Pasajero>(this.url + '/' + id);
  }
  public filterNif(nif: string): Observable<Pasajero[]>{
    return this.http.get<Pasajero[]>(this.url + '/nif/' + nif);
  }
}
