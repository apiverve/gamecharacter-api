# Game Character Generator API - Ruby Gem

Generate complete RPG-style characters with race, class, background, stats, and personality.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_gamecharacter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_gamecharacter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_gamecharacter'

# Initialize the client
client = APIVerve::Gamecharacter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  race: "elf",
  class: "mage"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ race: "elf", class: "mage" })
  puts response["data"]
rescue APIVerve::Gamecharacter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Gamecharacter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Gamecharacter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/gamecharacter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/gamecharacter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/gamecharacter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
