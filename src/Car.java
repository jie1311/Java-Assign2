import java.util.ArrayList;
import java.util.Calendar;
public class Car {
    private String reg;
    private String year;
    private ArrayList<String> colors;
    private String make;
    private String model;
    private String price;

    public Car() {
        this.reg = "unkown";
        this.year = "0000";
        this.colors = new ArrayList<>();
        this.make = "unkown";
        this.model = "unkown";
        this.price = "0";
    }

    public Car(String reg, String year, ArrayList<String> colors, String make, String model, String price) {
        this.reg = reg;
        this.year = year;
        this.colors = colors;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void display() {
        System.out.println("===================================================");
        System.out.println("The registration number is: " + reg);
        System.out.println("The year this car built is: " + year);
        System.out.print("The color(s) is(are): ");
        for (String color : colors) {
            System.out.print(color + ", ");
        }
        System.out.println("");
        System.out.println("The make is: " + make );
        System.out.println("The model is: " + model);
        System.out.println("The price is: " + price);
    }

    public String getInfo() {
        String info = reg + "," + year + ",";
        for(int i = 0; i < 3; i++) {
            try {
                info += colors.get(i) + ",";
            } catch(Exception e) {
                info += ",";
            }
        }
        info += make + "," + model + "," + price;
        return info;
    }

    public int getAge() {
        Calendar now = Calendar.getInstance();
        int currentYearInt = now.get(Calendar.YEAR);
        int yearInt = Integer.parseInt(year);
        return currentYearInt - yearInt;
    }
}
