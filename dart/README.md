# Game Character Generator API - Dart/Flutter Client

Generate complete RPG-style characters with race, class, background, stats, and personality.

[![pub package](https://img.shields.io/pub/v/apiverve_gamecharacter.svg)](https://pub.dev/packages/apiverve_gamecharacter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Game Character Generator API](https://apiverve.com/marketplace/gamecharacter?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_gamecharacter: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_gamecharacter/apiverve_gamecharacter.dart';

void main() async {
  final client = GamecharacterClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'race': 'elf',
      'class': 'mage'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "name": "Nimara Shadowleaf",
    "race": {
      "name": "Elf",
      "traits": [
        "Graceful",
        "Keen Senses",
        "Long-lived"
      ]
    },
    "class": {
      "name": "Mage",
      "description": "Wielder of arcane magic",
      "primaryStat": "intelligence",
      "hitDie": "d6"
    },
    "background": "Acolyte",
    "personality": "Reckless and impulsive",
    "motivation": "Escape their past",
    "stats": {
      "strength": {
        "value": 11,
        "modifier": 0
      },
      "dexterity": {
        "value": 11,
        "modifier": 0
      },
      "constitution": {
        "value": 7,
        "modifier": -2
      },
      "intelligence": {
        "value": 11,
        "modifier": 0
      },
      "wisdom": {
        "value": 11,
        "modifier": 0
      },
      "charisma": {
        "value": 11,
        "modifier": 0
      }
    },
    "hp": 4
  }
}
```

## API Reference

- **API Home:** [Game Character Generator API](https://apiverve.com/marketplace/gamecharacter?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/gamecharacter](https://docs.apiverve.com/ref/gamecharacter?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
