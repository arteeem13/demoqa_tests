package com.demoqa.tests;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormFillingFields {

    static void setName(String firstName, String lastName){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
    }

    static void setEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
    }

    static void setGender(String gender){
        $(byText(gender)).click();
    }

    static void setMobile(String userPhoneNumber){
        $("#userNumber").setValue(userPhoneNumber);
    }

    static void setSubjects(String subjects){
        $("#subjectsInput").setValue(subjects).pressTab();
    }

    static void setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
    }

    static void setHobbies(String hobbies){
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    static void setPhoto(File photo){
        $("#uploadPicture").uploadFile(photo);
    }

    static void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }

    static void setStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
    }
}
