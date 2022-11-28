package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.Array;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Разработайте автотест на проверку формы https://demoqa.com/automation-practice-form
 * (всего лишь один тест, чтобы открылся браузер, заполнились успешно все поля,
 * засабмитились и проверить что все данные появились в открытом поп-ап окне )
 */

public class DemoQATest {

    @BeforeAll
    static void beforeAll(){

        Configuration.browser = "CHROME";
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @DisplayName("Data in pop-up window matches with data from Student Registration Form in FIREFOX")
    void checkFillingFieldsInPopupFirefox() {

        open( "/automation-practice-form");

        String firstName = "Artem";
        String lastName = "Andreev";
        String gender = "Male";
        String userEmail = "artem@mail.com";
        String userPhoneNumber = "8919000000";
        String currentAddress = "Kazan, Republic of Tatarstan, Russia";
        File photo = new File("src/test/resources/panda.jpg");
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

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " +  lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(String.valueOf(919000000)));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 May,1994"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("panda.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }
}
