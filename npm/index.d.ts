declare module '@apiverve/gamecharacter' {
  export interface gamecharacterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface gamecharacterResponse {
    status: string;
    error: string | null;
    data: GameCharacterGeneratorData;
    code?: number;
  }


  interface GameCharacterGeneratorData {
      name:        string;
      race:        Race;
      class:       Class;
      background:  string;
      personality: string;
      motivation:  string;
      stats:       Stats;
      hp:          number;
  }
  
  interface Class {
      name:        string;
      description: string;
      primaryStat: string;
      hitDie:      string;
  }
  
  interface Race {
      name:   string;
      traits: string[];
  }
  
  interface Stats {
      strength:     Charisma;
      dexterity:    Charisma;
      constitution: Charisma;
      intelligence: Charisma;
      wisdom:       Charisma;
      charisma:     Charisma;
  }
  
  interface Charisma {
      value:    number;
      modifier: number;
  }

  export default class gamecharacterWrapper {
    constructor(options: gamecharacterOptions);

    execute(callback: (error: any, data: gamecharacterResponse | null) => void): Promise<gamecharacterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: gamecharacterResponse | null) => void): Promise<gamecharacterResponse>;
    execute(query?: Record<string, any>): Promise<gamecharacterResponse>;
  }
}
