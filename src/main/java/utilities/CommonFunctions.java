package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CommonFunctions {

    public static void javaScriptExecutorFunction(WebDriver webDriver, WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public static boolean checkSortingInAscending(ArrayList<String> arraylist) {
        boolean isSorted = true;
        for (int i = 1; i < arraylist.size(); i++) {
            if (arraylist.get(i - 1).compareTo(arraylist.get(i)) > 0) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    public static boolean checkSortingInDescending(ArrayList<String> arraylist) {
        boolean isSorted = true;
        for (int i = 1; i < arraylist.size()-1; i++) {
            if (arraylist.get(i-1).compareTo(arraylist.get(i)) < 0) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}

