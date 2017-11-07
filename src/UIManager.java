import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class  UIManager {
    public static void menu() {
        System.out.println("===================================================");
        System.out.println("Used Cars Database System");
        System.out.println("Options:");
        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Delete Car");
        System.out.println("(4) Exit System");
    }

    public static void searchMenu() {
        System.out.println("===================================================");
        System.out.println("Searching Options:");
        System.out.println("(1) By Registration Number");
        System.out.println("(2) By Car Make and Car Model");
        System.out.println("(3) By Age");
        System.out.println("(4) By Price (range)");
        System.out.println("(5) Back to Main Menu");
    }

    public static void confirmMenu() {
        System.out.println("===================================================");
        System.out.println("Options:");
        System.out.println("(1) Confirm");
        System.out.println("(2) Cancel");
    }

    public static String getOption(String min, String max) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[" + min + "-" + max + "]")) {
                break;
            }
            System.out.println("Error, please input an option between" + min + " and " + max + ":");
            input = scanner.next();
        }
        return input;
    }

    public static String getReg() {
        System.out.println("Please enter a car registration number:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[A-Za-z0-9]{1,6}")) {
                break;
            }
            System.out.println("Error, please input a correct car registration number:");
            input = scanner.next();
        }
        return input;
    }

    public static String getColor() {
        System.out.println("Please enter a color:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[A-Za-z/s]*")) {
                break;
            }
            System.out.println("Error, please input a correct color:");
            input = scanner.next().trim();
        }
        return input;
    }

    public static String getMakeModel(String type) {
        System.out.println("Please enter a " + type + ":");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[A-Za-z0-9]*")) {
                break;
            }
            System.out.println("Error, please input a correct " + type + ":");
            input = scanner.next();
        }
        return input;
    }

    public static String getPrice(String type) {
        System.out.println("Please enter a " + type + " price:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[0-9]{1,8}")) {
                break;
            }
            System.out.println("Error, please input a correct price:");
            input = scanner.next();
        }
        return input;
    }

    public static String getAge() {
        System.out.println("Please enter a age:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            if (input.matches("[0-9]{1,3}")) {
                break;
            }
            System.out.println("Error, please input a correct age:");
            input = scanner.next();
        }
        return input;
    }

    public static String getYear() {
        System.out.println("Please enter a year:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Calendar now = Calendar.getInstance();
        int currentYearInt = now.get(Calendar.YEAR);
        while (true) {
            if (input.matches("[0-9]{1,4}")) {
                if (currentYearInt >= Integer.parseInt(input)) {
                    break;
                }
            }
            System.out.println("Error, please input a correct year:");
            input = scanner.next();
        }
        return input;
    }

    public static ArrayList<String> getColors(int max) {
        ArrayList<String> colors = new ArrayList<>();
        String color = getColor();
        colors.add(color);
        for (int i = 0; i < max - 1; i++) {
            System.out.println("You can add " + (max - 1 - i) + " more colors:");
            confirmMenu();
            String option = getOption("1", "2");
            if (option.equals("2")) {
                break;
            }
            String extraColor = getColor();
            if (!colors.contains(extraColor)) {
                colors.add(extraColor);
            }
        }
        return colors;
    }

    public static void displayCars(ArrayList<Car> cars, String errorInfo) {
        if (cars.size() > 0) {
            for (Car car : cars) {
                car.display();
            }
        } else {
            System.out.println(errorInfo);
        }
    }

    public static void displayCarsSimple(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.display();
        }
    }

    public static void displayInfo(String info) {
        System.out.println(info);
    }
}

