package com.andreev.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

        @BeforeAll
        public static void beforeAllForFirefox(){
            Configuration.browser = "FIREFOX";
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
    }
}
