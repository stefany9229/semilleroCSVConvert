import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                System.out.println(productInfo[0]);
                System.out.println(line);
                //TODO implement the logic to transform this code so it can convert the information in each line into a Product objet
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}