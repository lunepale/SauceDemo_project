package Pages;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PageLocators {
    private final Map<String, By> locators;

    public PageLocators(String filePath) {
        this.locators = loadLocatorsFromFile(filePath);
    }

    private Map<String, By> loadLocatorsFromFile(String filePath) {
        Map<String, By> locatorsMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String elementName = parts[0];
                    String locatorValue = parts[1];


                    By locator = getByFromLocatorString(locatorValue);


                    locatorsMap.put(elementName, locator);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locatorsMap;
    }

    public By getLocator(String elementName) {
        return locators.get(elementName);
    }

    private By getByFromLocatorString(String locatorString) {
        String[] parts = locatorString.split(":", 2);
        if (parts.length == 2) {
            String locatorType = parts[0].trim();
            String locatorValue = parts[1].trim();

            switch (locatorType.toLowerCase()) {
                case "id":
                    return By.id(locatorValue);
                case "classname":
                    return By.className(locatorValue);

                default:
                    throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
            }
        } else {
            throw new IllegalArgumentException("Invalid locator string: " + locatorString);
        }
    }
}
