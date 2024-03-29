package com.andreev.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.andreev.pages.StudentRegistrationPage.*;
import static com.andreev.pages.StudentRegistrationPage.checkValue;
import static com.andreev.tests.TestData.*;
import static com.codeborne.selenide.Selenide.$;

@Nested
@DisplayName("Tests for Student Registration Form")
public class StudentRegistrationFormTest extends TestBase {

    @Test
    @DisplayName("Data in pop-up window matches with data from Student Registration Form in CHROME")
    void checkFillingFieldsInPopupChrome() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        openPage();
        setFirstName(randFirstName);
        setLastName(randLastName);
        setGender(randGender);
        setDateOfBirth(randDay, randMonth, randYear);
        setEmail(randUserEmail);
        setMobile(randUserPhoneNumber);
        setSubjects("Maths");
        setHobbies(randHobbies);
        setPhoto(photo);
//        setCurrentAddress(randCurrentAddress);
//        setStateAndCity(randState, randCity);
        submitStudentRegistrationForm();
        checkValue("Student Name", randFirstName + " " +  randLastName);
        checkValue("Student Email", randUserEmail);
        checkValue("Gender", randGender);
        checkValue("Mobile", randUserPhoneNumber);
        checkValue("Date of Birth", randDay + " " + randMonth + "," + randYear);
        checkValue("Subjects", "Maths");
        checkValue("Hobbies", randHobbies);
        checkValue("Picture", "panda.jpg");
//        checkValue("Address", randCurrentAddress);
//        checkValue("State and City", randState + " " + randCity);
    }
}