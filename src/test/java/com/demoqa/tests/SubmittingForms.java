package com.demoqa.tests;

import static com.codeborne.selenide.Selenide.$;

public class SubmittingForms {

    static void submitStudentRegistrationForm(){
        $("#submit").click();
    }
}
