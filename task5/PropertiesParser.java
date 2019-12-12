package task5;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class PropertiesParser {
    static HashMap<String, String> parse(String path, String delimiter) {
        HashMap<String, String> results = new HashMap<>();

        try (FileReader inputFile = new FileReader(path))
        {
            Scanner in = new Scanner(inputFile);
            while(in.hasNext())
            {
                String key, value;
                key = in.next();
                if (!in.hasNext() || !in.next().equals(delimiter))
                {
                    throw new IllegalArgumentException("Некорректный формат данных.");
                }

                value = in.next();
                results.put(key, value);
            }
            in.close();
            return results;
        } catch (IOException | IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
