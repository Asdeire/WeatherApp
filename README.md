# Weather App

## Overview

This application provides weather information for a specified location. Users can enter a city name and select a country to view the weather forecast for today and the upcoming week. Weather icons are displayed to enhance the user experience.

## Features

- Search weather information by selecting a country and city.
- Display current weather conditions.
- Show a 7-day weather forecast.
- Use weather icons for a clear and intuitive display of conditions.

## Technologies Used

- **Java**: Backend programming language.
- **Spring Boot**: Framework for building RESTful services.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **OpenWeatherMap API**: Source of weather data.
- **HTML5 & CSS3**: For responsive and user-friendly UI.
- **Bootstrap**: For styling and layout.

## API Integration

The app fetches weather data using the [OpenWeatherMap API](https://openweathermap.org/). You need to register and obtain an API key to use their services.

## Pages

1. **Home Page**:
   - Contains an input form to select a country and city.
   - Brief description of the app.

2. **Today's Weather**:
   - Displays the current weather conditions for the selected location.
   - Includes temperature, humidity, wind speed, and weather icon.

3. **7-Day Forecast**:
   - Shows daily weather forecasts for the next seven days.
   - Includes high/low temperatures, weather descriptions, and icons.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/weather-app.git
   cd weather-app
   ```

2. Set up the OpenWeatherMap API:
   - Register at [OpenWeatherMap](https://openweathermap.org/) to obtain an API key.
   - Add the API key to the application properties file:
     ```
     weather.api.key=your_api_key
     ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application at `http://localhost:8080`.

## Usage

1. Go to the home page and select a country and city.
2. Click "Search" to view the current weather for the selected location.
3. Navigate to the "7-Day Forecast" page to view weather predictions for the upcoming week.

## Weather Icons

Weather icons are dynamically loaded from the OpenWeatherMap API, ensuring an accurate representation of current conditions.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with any enhancements or fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
