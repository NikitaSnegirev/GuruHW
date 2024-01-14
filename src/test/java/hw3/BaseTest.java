package hw3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000; // default 4000
    }
}
