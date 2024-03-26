package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppManager {
//    ChromeOptions options = new ChromeOptions().addArguments("Load-extension=________________");
//
//    WebDriver driverAdd = new ChromeDriver(options);
    WebDriver driver = new ChromeDriver();

    default void init(){
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    default void initAddOptions(){
//        driverAdd.navigate().to("https://demoqa.com/");
//        driverAdd.manage().window().maximize();
//        driverAdd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driverAdd.switchTo().window(tabs.get(1)).close();
//        driverAdd.switchTo().window(tabs.get(0));
//
//    }


    default void stop(){
        driver.quit();
    }

}
