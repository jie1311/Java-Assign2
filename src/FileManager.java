import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public static ArrayList<Car> readFile(String fileName) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String carInfo = parser.nextLine();
                String[] infos = carInfo.split(",");
                ArrayList<String> colors = new ArrayList<>();
                for (int i = 2; i <= 4; i++) {
                    if (!infos[i].equals("")) {
                        colors.add(infos[i]);
                    }
                }
                Car car = new Car(infos[0], infos[1], colors, infos[5], infos[6], infos[7]);
                cars.add(car);
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file " + "\"fileName\"");
        } catch (Exception e) {
            System.out.println("Please try again.");
        }
        return cars;
    }

    public static void writeFile(String fileName, ArrayList<Car> cars) {
        try {
            PrintWriter outputFile = new PrintWriter(fileName);
            for (Car car : cars) {
                String carInfo = car.getInfo();
                outputFile.println(carInfo);
            }
            outputFile.close();
        } catch (Exception e) {
            System.out.println("Please try again.");
        }
    }
}
