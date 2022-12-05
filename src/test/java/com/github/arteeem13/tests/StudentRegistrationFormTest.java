package com.github.arteeem13.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    public static void beforeAllForFirefox(){

        Configuration.browser = "FIREFOX";
        Configuration.browserSize = "1920x1080";
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

        StudentRegistrationFormFillingFields.setName(firstName, lastName);
        StudentRegistrationFormFillingFields.setGender(gender);
        StudentRegistrationFormFillingFields.setDateOfBirth("13", "May", "1994");
        StudentRegistrationFormFillingFields.setEmail(userEmail);
        StudentRegistrationFormFillingFields.setMobile(userPhoneNumber);
        StudentRegistrationFormFillingFields.setSubjects("Math");
        StudentRegistrationFormFillingFields.setHobbies("Sports");
        StudentRegistrationFormFillingFields.setPhoto(photo);
        StudentRegistrationFormFillingFields.setCurrentAddress(currentAddress);
        StudentRegistrationFormFillingFields.setStateAndCity(state, city);

        SubmittingForm.submitStudentRegistrationForm();

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
