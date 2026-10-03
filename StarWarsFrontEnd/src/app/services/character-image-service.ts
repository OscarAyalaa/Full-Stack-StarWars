import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CharacterImageService {
  
  private images: { [id: number]: string } = {

    1: '/characters/luke.jpg',
    2: '/characters/c3po.jpg',
    3: '/characters/r2d2.jpg',
    4: '/characters/darth-vader.jpg',
    5: '/characters/leia.jpg',
    6: '/characters/owen.jpg',
    7: '/characters/beru.jpg',
    8: '/characters/r5d4.jpg',
    9: '/characters/biggs.jpg',
    10: '/characters/obi-wan.jpg'

  };

  getImage(id: number): string | null {
    return this.images[id] ?? null;
  }

}
