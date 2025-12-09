// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     GameCharacterGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.gamecharacter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static GameCharacterGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(GameCharacterGeneratorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(GameCharacterGeneratorData.class);
        writer = mapper.writerFor(GameCharacterGeneratorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// GameCharacterGeneratorData.java

package com.apiverve.gamecharacter.data;

import com.fasterxml.jackson.annotation.*;

public class GameCharacterGeneratorData {
    private String name;
    private Race race;
    private ClassClass gameCharacterGeneratorDataClass;
    private String background;
    private String personality;
    private String motivation;
    private Stats stats;
    private long hp;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("race")
    public Race getRace() { return race; }
    @JsonProperty("race")
    public void setRace(Race value) { this.race = value; }

    @JsonProperty("class")
    public ClassClass getGameCharacterGeneratorDataClass() { return gameCharacterGeneratorDataClass; }
    @JsonProperty("class")
    public void setGameCharacterGeneratorDataClass(ClassClass value) { this.gameCharacterGeneratorDataClass = value; }

    @JsonProperty("background")
    public String getBackground() { return background; }
    @JsonProperty("background")
    public void setBackground(String value) { this.background = value; }

    @JsonProperty("personality")
    public String getPersonality() { return personality; }
    @JsonProperty("personality")
    public void setPersonality(String value) { this.personality = value; }

    @JsonProperty("motivation")
    public String getMotivation() { return motivation; }
    @JsonProperty("motivation")
    public void setMotivation(String value) { this.motivation = value; }

    @JsonProperty("stats")
    public Stats getStats() { return stats; }
    @JsonProperty("stats")
    public void setStats(Stats value) { this.stats = value; }

    @JsonProperty("hp")
    public long getHP() { return hp; }
    @JsonProperty("hp")
    public void setHP(long value) { this.hp = value; }
}

// ClassClass.java

package com.apiverve.gamecharacter.data;

import com.fasterxml.jackson.annotation.*;

public class ClassClass {
    private String name;
    private String description;
    private String primaryStat;
    private String hitDie;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("primaryStat")
    public String getPrimaryStat() { return primaryStat; }
    @JsonProperty("primaryStat")
    public void setPrimaryStat(String value) { this.primaryStat = value; }

    @JsonProperty("hitDie")
    public String getHitDie() { return hitDie; }
    @JsonProperty("hitDie")
    public void setHitDie(String value) { this.hitDie = value; }
}

// Race.java

package com.apiverve.gamecharacter.data;

import com.fasterxml.jackson.annotation.*;

public class Race {
    private String name;
    private String[] traits;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("traits")
    public String[] getTraits() { return traits; }
    @JsonProperty("traits")
    public void setTraits(String[] value) { this.traits = value; }
}

// Stats.java

package com.apiverve.gamecharacter.data;

import com.fasterxml.jackson.annotation.*;

public class Stats {
    private Charisma strength;
    private Charisma dexterity;
    private Charisma constitution;
    private Charisma intelligence;
    private Charisma wisdom;
    private Charisma charisma;

    @JsonProperty("strength")
    public Charisma getStrength() { return strength; }
    @JsonProperty("strength")
    public void setStrength(Charisma value) { this.strength = value; }

    @JsonProperty("dexterity")
    public Charisma getDexterity() { return dexterity; }
    @JsonProperty("dexterity")
    public void setDexterity(Charisma value) { this.dexterity = value; }

    @JsonProperty("constitution")
    public Charisma getConstitution() { return constitution; }
    @JsonProperty("constitution")
    public void setConstitution(Charisma value) { this.constitution = value; }

    @JsonProperty("intelligence")
    public Charisma getIntelligence() { return intelligence; }
    @JsonProperty("intelligence")
    public void setIntelligence(Charisma value) { this.intelligence = value; }

    @JsonProperty("wisdom")
    public Charisma getWisdom() { return wisdom; }
    @JsonProperty("wisdom")
    public void setWisdom(Charisma value) { this.wisdom = value; }

    @JsonProperty("charisma")
    public Charisma getCharisma() { return charisma; }
    @JsonProperty("charisma")
    public void setCharisma(Charisma value) { this.charisma = value; }
}

// Charisma.java

package com.apiverve.gamecharacter.data;

import com.fasterxml.jackson.annotation.*;

public class Charisma {
    private long value;
    private long modifier;

    @JsonProperty("value")
    public long getValue() { return value; }
    @JsonProperty("value")
    public void setValue(long value) { this.value = value; }

    @JsonProperty("modifier")
    public long getModifier() { return modifier; }
    @JsonProperty("modifier")
    public void setModifier(long value) { this.modifier = value; }
}