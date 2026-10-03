import { CommonModule } from '@angular/common';
import { Component, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../../services/character-service';
import { Character } from '../../models/character';

@Component({
  selector: 'app-character-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './character-detail.html',
  styleUrl: './character-detail.css',
})
export class CharacterDetail implements OnInit{

  constructor(private route: ActivatedRoute, private router: Router, private characterService: CharacterService){}

  character = signal<Character | null>(null);

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    console.log('Character ID:', id);

    this.characterService.getCharacterById(id).subscribe({
      next: (character) => {
        this.character.set(character);
        console.log('Character received:', character);
      },
      error: (error) =>{
        console.error('Error cargando el character', error);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/inicio']);
  }
  

}
