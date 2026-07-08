package testsBase;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    // Data Provider used for unsuccessful login tests: invalid credentials
    @DataProvider(name = "wrongUsers")
    public Object[][] getWrongUsers() {

        return new Object[][] {
                {"standard_user" , "wrong_password"},
                {"locked_out_user" , "secret_sauce"},
        };
    }

    // Data Provider used to read Products names from CSV file
    @DataProvider(name = "itemsToBeAdded")
    public Object[][] getItems() {
        return readCsvFile("src/test/resources/products.csv");
    }

    // Data Provider used to read Checkout info from CSV file
    @DataProvider(name = "checkoutData")
        public Object[][] getCheckoutData() {
        return readCsvFile("src/test/resources/checkoutData.csv");
    }

        // Read data from CSV files
        private Object[][] readCsvFile(String filePath) {

        try {
            CSVReader csvReader = new CSVReader
                    (new FileReader(filePath));

            List<String[]> csvData = csvReader.readAll();

            Object[][] csvDataObject = new Object[csvData.size()][1]; // number of columns in .csv file

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}