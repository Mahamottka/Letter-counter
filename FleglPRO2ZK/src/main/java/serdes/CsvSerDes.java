package serdes;

import model.Znak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvSerDes {
    public List<String> nacti(String soubor) throws IOException {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Iterate over each character in the line and add it to the list
                for (char c : line.toCharArray()) {
                    result.add(Character.toString(c));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void uloz(String soubor, List<Znak> seznam) throws IOException {
        try (FileWriter csvWriter = new FileWriter(soubor)) {

            for (Znak znak : seznam) {
                csvWriter.append(znak.getNazev());
                csvWriter.append(";");
                csvWriter.append(String.valueOf(znak.getAbsCetnost()));
                csvWriter.append(";");
                csvWriter.append(String.valueOf(znak.getRelCetnost()));
                csvWriter.append("\n");
            }

            csvWriter.flush(); //ujistíme se, že jsou data zapsána
        }
    }
}
