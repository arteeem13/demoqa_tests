package com.demoqa.tests;

import static com.codeborne.selenide.Selenide.$;

public class SubmittingForm {

    static void submitStudentRegistrationForm(){
        $("#submit").click();
    }
}
