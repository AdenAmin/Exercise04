import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<City> cities = new ArrayList<City>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a city name (END to stop): ");
            String cityName = sc.nextLine();

            if (cityName.equals("END")) {
                break;
            }

            int[] temperatures = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.printf("Enter the temperature for day %d: ", i + 1);
                temperatures[i] = sc.nextInt();
                sc.nextLine();
            }

            cities.add(new City(cityName, temperatures));
            calculateAverage(cities);
            displayResults(cities);
        }

    }

    private static void calculateAverage(ArrayList<City> cities) {
        for (City city : cities) {
            int sum = 0;
            for (int temperature : city.temperatures) {
                sum += temperature;
            }
            city.average = sum / city.temperatures.length;
        }
    }

    private static void displayResults(ArrayList<City> cities) {
        System.out.println("City  Average");
        for (City city : cities) {
            System.out.println(city.name + "  " + city.average);
        }
    }
}

class City {
    String name;
    int[] temperatures;
    int average;

    City(String name, int[] temperatures) {
        this.name = name;
        this.temperatures = temperatures;
    }
}
