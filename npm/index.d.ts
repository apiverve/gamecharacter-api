declare module '@apiverve/gamecharacter' {
  export interface gamecharacterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface gamecharacterResponse {
    status: string;
    error: string | null;
    data: GameCharacterGeneratorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface GameCharacterGeneratorData {
      name:            null | string;
      race:            Race;
      class:           Class;
      background:      null | string;
      personality:     null | string;
      motivation:      null | string;
      stats:           Stats;
      hp:              number | null;
      totalStatPoints: number | null;
      highestStat:     null | string;
      lowestStat:      null | string;
  }
  
  interface Class {
      name:        null | string;
      description: null | string;
      primaryStat: null | string;
      hitDie:      null | string;
  }
  
  interface Race {
      name:   null | string;
      traits: (null | string)[];
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
      value:    number | null;
      modifier: number | null;
  }

  export default class gamecharacterWrapper {
    constructor(options: gamecharacterOptions);

    execute(callback: (error: any, data: gamecharacterResponse | null) => void): Promise<gamecharacterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: gamecharacterResponse | null) => void): Promise<gamecharacterResponse>;
    execute(query?: Record<string, any>): Promise<gamecharacterResponse>;
  }
}
