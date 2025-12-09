using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.GameCharacterGenerator
{
    /// <summary>
    /// Query options for the Game Character Generator API
    /// </summary>
    public class GameCharacterGeneratorQueryOptions
    {
        /// <summary>
        /// Character race: Human, Elf, Dwarf, Halfling, Orc, Gnome, Tiefling, Dragonborn, Half-Elf, Goblin
        /// Example: elf
        /// </summary>
        [JsonProperty("race")]
        public string Race { get; set; }

        /// <summary>
        /// Character class: Warrior, Mage, Rogue, Cleric, Ranger, Paladin, Barbarian, Bard, Druid, Monk, Warlock, Necromancer
        /// Example: mage
        /// </summary>
        [JsonProperty("class")]
        public string Class { get; set; }
    }
}
