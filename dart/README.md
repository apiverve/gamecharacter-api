# Game Character Generator API - Dart/Flutter Client

Generate complete RPG-style characters with race, class, background, stats, and personality.

[![pub package](https://img.shields.io/pub/v/apiverve_gamecharacter.svg)](https://pub.dev/packages/apiverve_gamecharacter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Game Character Generator API](https://apiverve.com/marketplace/gamecharacter?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_gamecharacter: ^1.2.5
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
    "name": "Nimara Goldenbough",
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
    "background": "Criminal",
    "personality": "Ambitious and driven",
    "motivation": "Protect the innocent",
    "stats": {
      "strength": {
        "value": 13,
        "modifier": 1
      },
      "dexterity": {
        "value": 12,
        "modifier": 1
      },
      "constitution": {
        "value": 9,
        "modifier": -1
      },
      "intelligence": {
        "value": 11,
        "modifier": 0
      },
      "wisdom": {
        "value": 4,
        "modifier": -3
      },
      "charisma": {
        "value": 8,
        "modifier": -1
      }
    },
    "hp": 5,
    "totalStatPoints": 57,
    "highestStat": "strength",
    "lowestStat": "wisdom"
  }
}
```

## API Reference

- **API Home:** [Game Character Generator API](https://apiverve.com/marketplace/gamecharacter?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/gamecharacter](https://docs.apiverve.com/ref/gamecharacter?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
