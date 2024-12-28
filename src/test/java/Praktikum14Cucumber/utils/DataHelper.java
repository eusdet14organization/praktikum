package Praktikum14Cucumber.utils;


import Praktikum14Cucumber.dto.User;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    static Faker faker = new Faker();

    public static User createTestUser() {
        User user = new User();
        user.setFirstName(ConfigurationReader.get("testUserFirstName"));
        user.setLastName(ConfigurationReader.get("testUserLastName"));
        user.setEmail(ConfigurationReader.get("eMail"));
        user.setCompany(ConfigurationReader.get("companyName"));
        user.setPassword(ConfigurationReader.get("password"));
        return user;
    }

    public static User createNewTestUser() {
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().firstName()+"TestUser");
        user.setEmail(faker.internet().emailAddress());
        user.setCompany(faker.company().name());
        user.setPassword(faker.internet().password());
        return user;
    }

    public static List<String> getListStringByListWebElement(List<WebElement> namesOfWebElements) {
        List<String> actualList = new ArrayList<>();
        for (WebElement nameOfList : namesOfWebElements) {
            actualList.add(nameOfList.getText());
        }
        return actualList;
    }
}
