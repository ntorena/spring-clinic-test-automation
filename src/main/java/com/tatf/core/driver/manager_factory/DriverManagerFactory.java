package com.tatf.core.driver.manager_factory;

import com.tatf.core.driver.manager.ChromeDriver;
import com.tatf.core.driver.manager.DriverManager;
import com.tatf.core.driver.manager_enum.DriverType;
import org.openqa.selenium.WebDriver;

import static com.tatf.core.driver.manager_enum.DriverType.CHROME;

public class DriverManagerFactory {
    private DriverManagerFactory() {
    }

    public static WebDriver getDriver(DriverType type) {
        WebDriver driver = null;

        if (type.equals(CHROME)) {
            DriverManager dm = new ChromeDriver();
            driver = dm.getDriver();
        }

        return driver;
    }

}
