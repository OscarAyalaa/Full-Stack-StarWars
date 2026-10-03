import { Character } from "./character";

export interface SwapiResponse {
  count: number;
  next: string | null;
  previous: string | null;
  results: Character[];
}
