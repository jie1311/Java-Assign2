import java.util.ArrayList;

public class MainManager {
    private CarDatabase database;

    public MainManager() {
        database = new CarDatabase(FileManager.readFile("usedcars.txt"));
        start();
    }

    public void start() {
        boolean run = true;
        while (run) {
            UIManager.menu();
            String option = UIManager.getOption("1", "4");
            switch (option) {
                case "1":
                    searchCar();
                    break;
                case "2":
                    addCar();
                    break;
                case "3":
                    deleteCar();
                    break;
                case "4":
                    FileManager.writeFile("usedcars.txt", database.getCars());
                    System.out.println("Exiting...");
                    run = false;
                    break;
            }
        }
    }

    private void searchCar() {
        boolean run = true;
        while (run) {
            UIManager.searchMenu();
            String option = UIManager.getOption("1", "5");
            switch (option) {
                case "1":
                    searchByReg();
                    break;
                case "2":
                    searchByMakeModel();
                    break;
                case "3":
                    searchByAge();
                    break;
                case "4":
                    searchByPrice();
                    break;
                case "5":
                    run = false;
                    break;
            }
        }
    }

    private void searchByReg() {
        String reg = UIManager.getReg();
        ArrayList<Car> result = database.searchByReg(reg);
        UIManager.displayCars(result, "No car found.");
    }

    private void searchByMakeModel() {
        String make = UIManager.getMakeModel("make");
        String model = UIManager.getMakeModel("model");
        ArrayList<Car> result = database.searchByMakeModel(make, model);
        UIManager.displayCars(result, "No car found.");
    }

    private void searchByAge() {
        String age = UIManager.getAge();
        ArrayList<Car> result = database.searchByAge(age);
        UIManager.displayCars(result, "No car found.");
    }

    private void searchByPrice() {
        String price1 = UIManager.getPrice("first");
        String price2 = UIManager.getPrice("second");
        ArrayList<Car> result = database.searchByPrice(price1, price2);
        UIManager.displayCars(result, "No car found.");
    }

    private void addCar() {
        String reg = UIManager.getReg();
        ArrayList<Car> result = database.searchByReg(reg);
        if (result.size() > 0) {
            UIManager.displayInfo("A car with this registration number already exists:");
            UIManager.displayCarsSimple(result);
        } else {
            String year = UIManager.getYear();
            ArrayList<String> colors = UIManager.getColors(3);
            String make = UIManager.getMakeModel("make");
            String model = UIManager.getMakeModel("model");
            String price = UIManager.getPrice("a");
            Car car = new Car(reg, year, colors, make, model, price);
            database.addCar(car);
        }
    }

    private void deleteCar() {
        String reg = UIManager.getReg();
        ArrayList<Car> result = database.searchByReg(reg);
        if (result.size() > 0) {
            UIManager.displayInfo("A car with this registration has been found:");
            UIManager.displayInfo("Delete?");
            UIManager.displayCarsSimple(result);
            UIManager.confirmMenu();
            String option = UIManager.getOption("1", "2");
            if (option.equals("1")) {
                database.deleteCar(reg);
            }
        } else {
            UIManager.displayInfo("No car found.");
        }

    }
}
