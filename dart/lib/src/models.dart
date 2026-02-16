/// Response models for the Game Character Generator API.

/// API Response wrapper.
class GamecharacterResponse {
  final String status;
  final dynamic error;
  final GamecharacterData? data;

  GamecharacterResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory GamecharacterResponse.fromJson(Map<String, dynamic> json) => GamecharacterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? GamecharacterData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Game Character Generator API.

class GamecharacterData {
  String? name;
  GamecharacterDataRace? race;
  GamecharacterDataClass? class;
  String? background;
  String? personality;
  String? motivation;
  GamecharacterDataStats? stats;
  int? hp;

  GamecharacterData({
    this.name,
    this.race,
    this.class,
    this.background,
    this.personality,
    this.motivation,
    this.stats,
    this.hp,
  });

  factory GamecharacterData.fromJson(Map<String, dynamic> json) => GamecharacterData(
      name: json['name'],
      race: json['race'] != null ? GamecharacterDataRace.fromJson(json['race']) : null,
      class: json['class'] != null ? GamecharacterDataClass.fromJson(json['class']) : null,
      background: json['background'],
      personality: json['personality'],
      motivation: json['motivation'],
      stats: json['stats'] != null ? GamecharacterDataStats.fromJson(json['stats']) : null,
      hp: json['hp'],
    );
}

class GamecharacterDataRace {
  String? name;
  List<String>? traits;

  GamecharacterDataRace({
    this.name,
    this.traits,
  });

  factory GamecharacterDataRace.fromJson(Map<String, dynamic> json) => GamecharacterDataRace(
      name: json['name'],
      traits: (json['traits'] as List?)?.cast<String>(),
    );
}

class GamecharacterDataClass {
  String? name;
  String? description;
  String? primaryStat;
  String? hitDie;

  GamecharacterDataClass({
    this.name,
    this.description,
    this.primaryStat,
    this.hitDie,
  });

  factory GamecharacterDataClass.fromJson(Map<String, dynamic> json) => GamecharacterDataClass(
      name: json['name'],
      description: json['description'],
      primaryStat: json['primaryStat'],
      hitDie: json['hitDie'],
    );
}

class GamecharacterDataStats {
  GamecharacterDataStatsStrength? strength;
  GamecharacterDataStatsDexterity? dexterity;
  GamecharacterDataStatsConstitution? constitution;
  GamecharacterDataStatsIntelligence? intelligence;
  GamecharacterDataStatsWisdom? wisdom;
  GamecharacterDataStatsCharisma? charisma;

  GamecharacterDataStats({
    this.strength,
    this.dexterity,
    this.constitution,
    this.intelligence,
    this.wisdom,
    this.charisma,
  });

  factory GamecharacterDataStats.fromJson(Map<String, dynamic> json) => GamecharacterDataStats(
      strength: json['strength'] != null ? GamecharacterDataStatsStrength.fromJson(json['strength']) : null,
      dexterity: json['dexterity'] != null ? GamecharacterDataStatsDexterity.fromJson(json['dexterity']) : null,
      constitution: json['constitution'] != null ? GamecharacterDataStatsConstitution.fromJson(json['constitution']) : null,
      intelligence: json['intelligence'] != null ? GamecharacterDataStatsIntelligence.fromJson(json['intelligence']) : null,
      wisdom: json['wisdom'] != null ? GamecharacterDataStatsWisdom.fromJson(json['wisdom']) : null,
      charisma: json['charisma'] != null ? GamecharacterDataStatsCharisma.fromJson(json['charisma']) : null,
    );
}

class GamecharacterDataStatsStrength {
  int? value;
  int? modifier;

  GamecharacterDataStatsStrength({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsStrength.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsStrength(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterDataStatsDexterity {
  int? value;
  int? modifier;

  GamecharacterDataStatsDexterity({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsDexterity.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsDexterity(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterDataStatsConstitution {
  int? value;
  int? modifier;

  GamecharacterDataStatsConstitution({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsConstitution.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsConstitution(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterDataStatsIntelligence {
  int? value;
  int? modifier;

  GamecharacterDataStatsIntelligence({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsIntelligence.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsIntelligence(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterDataStatsWisdom {
  int? value;
  int? modifier;

  GamecharacterDataStatsWisdom({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsWisdom.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsWisdom(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterDataStatsCharisma {
  int? value;
  int? modifier;

  GamecharacterDataStatsCharisma({
    this.value,
    this.modifier,
  });

  factory GamecharacterDataStatsCharisma.fromJson(Map<String, dynamic> json) => GamecharacterDataStatsCharisma(
      value: json['value'],
      modifier: json['modifier'],
    );
}

class GamecharacterRequest {
  String? race;
  String? class;

  GamecharacterRequest({
    this.race,
    this.class,
  });

  Map<String, dynamic> toJson() => {
      if (race != null) 'race': race,
      if (class != null) 'class': class,
    };
}
