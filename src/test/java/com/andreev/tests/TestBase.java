package com.andreev.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

        @BeforeAll
        public static void beforeAllTests(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.browser = "CHROME";
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
