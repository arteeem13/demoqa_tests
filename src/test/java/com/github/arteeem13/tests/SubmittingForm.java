package com.github.arteeem13.tests;

import static com.codeborne.selenide.Selenide.$;

public class SubmittingForm {

    public static void submitStudentRegistrationForm(){
        $("#submit").click();
    }
}
