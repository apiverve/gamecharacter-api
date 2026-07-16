# Game Character Generator API - PHP Package

Generate complete RPG-style characters with race, class, background, stats, and personality.

## Installation

Install via Composer:

```bash
composer require apiverve/gamecharacter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Gamecharacter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'race' => 'elf',
    'class' => 'mage'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Gamecharacter\Client;
use APIVerve\Gamecharacter\Exceptions\APIException;
use APIVerve\Gamecharacter\Exceptions\ValidationException;

try {
    $response = $client->execute(['race' => 'elf', 'class' => 'mage']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/gamecharacter?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/gamecharacter?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/gamecharacter?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
