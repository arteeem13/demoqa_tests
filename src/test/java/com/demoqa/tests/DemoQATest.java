package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

/**
 * Разработайте автотест на проверку формы https://demoqa.com/automation-practice-form
 * (всего лишь один тест, чтобы открылся браузер, заполнились успешно все поля,
 * засабмитились и проверить что все данные появились в открытом поп-ап окне )
 */

public class DemoQATest {

    String baseURL = "https://demoqa.com";

    @BeforeAll
    public static void init(){
        Configuration.browser = "FIREFOX";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Data in pop-up window matches with data from Student Registration Form in FIREFOX")
    void checkFillingFieldsInPopupFirefox() {

        open( baseURL + "/automation-practice-form");

        String firstName = "Artem";
        String lastName = "Andreev";
        String gender = "Male";
        String userEmail = "artem@mail.com";
        String userPhoneNumber = "89190000000";
        String currentAddress = "Kazan, Republic of Tatarstan, Russia";
        File photo = new File("photos/panda.jpg");
        String state = "NCR";
        String city = "Delhi";

        FillingStudentRegistrationForm.setName(firstName, lastName);
        FillingStudentRegistrationForm.setGender(gender);
        FillingStudentRegistrationForm.setDateOfBirth("13", "May", "1994");
        FillingStudentRegistrationForm.setEmail(userEmail);
        FillingStudentRegistrationForm.setMobile(userPhoneNumber);
        FillingStudentRegistrationForm.setSubjects("Math");
        FillingStudentRegistrationForm.setHobbies("Sports");
        FillingStudentRegistrationForm.setPhoto(photo);
        FillingStudentRegistrationForm.setCurrentAddress(currentAddress);
        FillingStudentRegistrationForm.setStateAndCity(state, city);

        SubmittingForms.submitStudentRegistrationForm();

        $("tr:nth-child(1) > td:nth-child(2)").equals(firstName + " " +  lastName);
        $("tr:nth-child(2) > td:nth-child(2)").equals(userEmail);
        $("tr:nth-child(3) > td:nth-child(2)").equals(gender);
        $("tr:nth-child(4) > td:nth-child(2)").toString().equals(userPhoneNumber);
        $("tr:nth-child(5) > td:nth-child(2)").equals("13 May 1994");
        $("tr:nth-child(6) > td:nth-child(2)").equals("Maths");
        $("tr:nth-child(7) > td:nth-child(2)").equals("Sports");
        $("tr:nth-child(8) > td:nth-child(2)").equals(photo);
        $("tr:nth-child(9) > td:nth-child(2)").equals(currentAddress);
        $("tr:nth-child(10) > td:nth-child(2)").equals(state + " " + city);
    }
}
