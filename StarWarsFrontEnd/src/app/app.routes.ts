import { Routes } from '@angular/router';
import { CharacterList } from './components/character-list/character-list';
import { CharacterDetail } from './components/character-detail/character-detail';

export const routes: Routes = [
    {path: '', redirectTo: '/inicio', pathMatch:'full'},
    {path: 'inicio', component: CharacterList},
    {path:'characters/:id', component: CharacterDetail}
];
