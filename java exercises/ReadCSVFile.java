

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {

    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\DELL\\Desktop\\cycling_dataset.csv"; // Replace with the actual file path

        try {
            readCSV(csvFilePath);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    private static void readCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line on commas to get values
                String[] values = line.split(",");

                try {
                    // Process and store values into appropriate data types
                    String name = values[0].trim();
                    double value1 = Double.parseDouble(values[1].trim());
                    int value2 = Integer.parseInt(values[2].trim());
                    double value3 = Double.parseDouble(values[3].trim());
                    // Add more variables as needed

                    // Do something with the values (e.g., print or store them)
                    System.out.println("Name: " + name + ", Value1: " + value1 + ", Value2: " + value2 + ", Value3: " + value3);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    // Handle exceptions for invalid data
                    System.err.println("Error processing line: " + line + ". " + e.getMessage());
                }
            }
        }
    }
}
