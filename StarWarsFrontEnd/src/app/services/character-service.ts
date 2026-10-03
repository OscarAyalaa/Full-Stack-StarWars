import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SwapiResponse } from '../models/swapi-response';
import { Character } from '../models/character';

@Injectable({
  providedIn: 'root',
})
export class CharacterService {
  
  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/api/characters';

  getCharacters(page: number = 1, search: string = ''): Observable<SwapiResponse>{
    let params = new HttpParams().set('page', page);

    if(search.trim()){
      params = params.set('search', search.trim());
    }

    return this.http.get<SwapiResponse>(this.apiUrl,{ params });
  }

  getCharacterById(id: number): Observable<Character> {
    return this.http.get<Character>(`${this.apiUrl}/${id}`);
  }
  
}
