package com.andreev.tests;

import org.junit.jupiter.api.*;

import static com.andreev.pages.StudentRegistrationPage.*;
import static com.andreev.pages.StudentRegistrationPage.checkValue;
import static com.andreev.tests.TestData.*;

@Nested
@DisplayName("Tests for Student Registration Form")
public class StudentRegistrationFormTest extends TestBase {

    @Test
    @DisplayName("Data in pop-up window matches with data from Student Registration Form in FIREFOX")
    void checkFillingFieldsInPopupFirefox() {

        openPage();

        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setDateOfBirth("13", "May", "1994");
        setEmail(userEmail);
        setMobile(userPhoneNumber);
        setSubjects("Math");
        setHobbies("Sports");
        setPhoto(photo);
        setCurrentAddress(currentAddress);
        setStateAndCity(state, city);

        submitStudentRegistrationForm();

        checkValue("Student Name", firstName + " " +  lastName);
        checkValue("Student Email", userEmail);
        checkValue("Gender", gender);
        checkValue("Mobile", String.valueOf(919000000));
        checkValue("Date of Birth", "13 May,1994");
        checkValue("Subjects", "Maths");
        checkValue("Hobbies", "Sports");
        checkValue("Picture", "panda.jpg");
        checkValue("Address", currentAddress);
        checkValue("State and City", state + " " + city);
    }
}