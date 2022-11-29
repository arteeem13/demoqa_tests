package com.demoqa.tests;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormFillingFields {

    public static void setName(String firstName, String lastName){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
    }

    public static void setEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
    }

    public static void setGender(String gender){
        $(byText(gender)).click();
    }

    public static void setMobile(String userPhoneNumber){
        $("#userNumber").setValue(userPhoneNumber);
    }

    public static void setSubjects(String subjects){
        $("#subjectsInput").setValue(subjects).pressTab();
    }

    public static void setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
    }

    public static void setHobbies(String hobbies){
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public static void setPhoto(File photo){
        $("#uploadPicture").uploadFile(photo);
    }

    public static void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }

    public static void setStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
    }
}
