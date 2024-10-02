import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Birlik } from '../beans/Birlik';

@Injectable({
  providedIn: 'root'
})
export class BirlikService {

  constructor(
    private http: HttpClient,
  ) { }

  getBirlikler(): Observable<Birlik[]> {
    return this.http.post<Birlik[]>('http://localhost:8080/api/v1/birlik/hepsi', {});
  }

  birlikEkleGuncelle(birlik: { id:number | null, adi: string, il: string }): Observable<Birlik> {
    return this.http.post<Birlik>('http://localhost:8080/api/v1/birlik/ekleguncelle', birlik);
  }

  birlikSil(id:number): Observable<any> {
    return this.http.delete<any>('http://localhost:8080/api/v1/birlik/sil?id='+id, {});
  }
}
