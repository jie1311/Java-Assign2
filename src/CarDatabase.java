import java.util.ArrayList;

public class CarDatabase {
    private ArrayList<Car> cars;

    public CarDatabase() {
        cars = new ArrayList<>();
    }

    public CarDatabase(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(String reg) {
        for (Car car : cars) {
            if (car.getReg().equalsIgnoreCase(reg)) {
                cars.remove(car);
                break;
            }
        }
    }

    public ArrayList<Car> searchByReg(String reg) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getReg().equalsIgnoreCase(reg)) {
                result.add(car);
                break;
            }
        }
        return result;
    }

    public ArrayList<Car> searchByAge(String age) {
        int ageInt = Integer.parseInt(age);
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getAge() <= ageInt) {
                result.add(car);
            }
        }
        return result;
    }

    public ArrayList<Car> searchByPrice(String price1, String price2) {
        int max = Integer.parseInt(price1);
        int min = Integer.parseInt(price2);
        if (max < min) {
            int buffer = max;
            max = min;
            min = buffer;
        }
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : cars) {
            int price = Integer.parseInt(car.getPrice());
            if (price <= max && price >= min) {
                result.add(car);
            }
        }
        return result;
    }

    public ArrayList<Car> searchByMakeModel(String make, String model) {
        ArrayList<Car> resultByMake = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                resultByMake.add(car);
            }
        }
        if (model.equalsIgnoreCase("ANY")) {
            return resultByMake;
        } else {
            ArrayList<Car> resultByModel = new ArrayList<>();
            for (Car car : resultByMake) {
                if (car.getModel().equalsIgnoreCase(model)) {
                    resultByModel.add(car);
                }
            }
            return resultByModel;
        }
    }
}
