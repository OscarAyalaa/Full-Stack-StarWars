import { CommonModule } from '@angular/common';
import { Component, inject, OnInit, signal } from '@angular/core';
import { CharacterService } from '../../services/character-service';
import { Character } from '../../models/character';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CharacterImageService } from '../../services/character-image-service';

@Component({
  selector: 'app-character-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './character-list.html',
  styleUrl: './character-list.css',
})
export class CharacterList implements OnInit {

  private characterService = inject(CharacterService);
  private router = inject(Router);
  private imageService = inject(CharacterImageService);

  isLoading = signal(false);
  errorMessage = signal('');

  characters: Character[] = [];

  currentPage = 1;
  search = signal('');

  totalCharacters = 0;

  ngOnInit(): void {
    this.loadCharacters();
  }

  loadCharacters(): void {
    this.isLoading.set(true);
    this.errorMessage.set('');

    this.characterService.getCharacters(this.currentPage, this.search()).subscribe({
      next: (response) => {
        console.log('Characters received:', response);
        this.characters = response.results;
        this.totalCharacters = response.count;
        this.isLoading.set(false);
      },
      error: (error) => {
        console.error('Error al cargar los personajes', error);
        this.isLoading.set(false);
        this.errorMessage.set(
          'Unable to load characters. Please try again.'
        );
      }
    });
  }

  get totalPages(): number {
    return Math.ceil(this.totalCharacters / 10);
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.loadCharacters();
    }
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.loadCharacters();
    }
  }

  searchCharacters(): void {
    this.currentPage = 1;
    this.loadCharacters();
  }

  viewCharacter(id: number): void {
    this.router.navigate(['/characters', id]);
  }

  getCharacterImage(id: number): string | null {
    return this.imageService.getImage(id);
  }

}
