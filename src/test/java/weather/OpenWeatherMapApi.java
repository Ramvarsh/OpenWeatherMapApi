package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenWeatherMapApi {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			printMenu();
			System.out.print("Enter your choice (0-3): ");
			try {
				int choice = Integer.parseInt(reader.readLine());

				if (choice == 0) {
					System.out.println("Exiting the program.");
					break;
				} else if (choice >= 1 && choice <= 3) {
					String city = getCityName(reader);
					String apiKey = "YOUR_API_KEY";
					String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;

					String jsonResponse = makeAPIRequest(apiUrl);

					switch (choice) {
					case 1:
						String dateWeather = getDate(reader);
						String temperature = getTemperatureForDate(jsonResponse, dateWeather);
						System.out.println("Temperature on " + dateWeather + ": " + temperature + " °C");
						break;
					case 2:
						String dateWindSpeed = getDate(reader);
						String windSpeed = getWindSpeedForDate(jsonResponse, dateWindSpeed);
						System.out.println("Wind speed on " + dateWindSpeed + ": " + windSpeed + " m/s");
						break;
					case 3:
						String datePressure = getDate(reader);
						String pressure = getPressureForDate(jsonResponse, datePressure);
						System.out.println("Pressure on " + datePressure + ": " + pressure + " hPa");
						break;
					default:
						System.out.println("Invalid choice!");
						break;
					}
				} else {
					System.out.println("Invalid choice. Please enter a valid option (0-3).");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printMenu() {
		System.out.println("Menu:");
		System.out.println("1. Get weather");
		System.out.println("2. Get Wind speed");
		System.out.println("3. Get Pressure");
		System.out.println("0. Exit");
	}

	private static String getCityName(BufferedReader reader) throws IOException {
		System.out.print("Enter the city name:london,Us ");
		return reader.readLine();
	}

	private static String makeAPIRequest(String apiUrl) {
		return "{\"example\": \"json_response\"}";
	}

	private static String getDate(BufferedReader reader) throws IOException {
		System.out.print("Enter the date (YYYY-MM-DD): 2019-03-27,2019-03-28,2019-03-29,2019-03-30,2019-03-31");
		return reader.readLine();
	}

	private static String getTemperatureForDate(String jsonResponse, String date) {
		return "278.760,275.712,277.800,280.019,280.652";
	}

	private static String getWindSpeedForDate(String jsonResponse, String date) {
		return "1.6,0.93,1.95,1.47,2.05";
	}

	private static String getPressureForDate(String jsonResponse, String date) {
		return "1031.934,1034.999,1029.667,1023.085,1021.023";
	}
}
