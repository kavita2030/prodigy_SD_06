import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the original unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        // Convert based on the input unit
        switch (unit) {
            case 'C':
                convertFromCelsius(temperature);
                break;
            case 'F':
                convertFromFahrenheit(temperature);
                break;
            case 'K':
                convertFromKelvin(temperature);
                break;
            default:
                System.out.println("Invalid unit. Please enter C, F, or K.");
        }

        scanner.close();
    }

    // Conversion methods
    public static void convertFromCelsius(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;
        System.out.printf("%.2f°C is %.2f°F and %.2fK%n", celsius, fahrenheit, kelvin);
    }

    public static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = (fahrenheit - 32) * 5/9 + 273.15;
        System.out.printf("%.2f°F is %.2f°C and %.2fK%n", fahrenheit, celsius, kelvin);
    }

    public static void convertFromKelvin(double kelvin) {
        double celsius = kelvin - 273.15;
        double fahrenheit = (kelvin - 273.15) * 9/5 + 32;
        System.out.printf("%.2fK is %.2f°C and %.2f°F%n", kelvin, celsius, fahrenheit);
    }
}
