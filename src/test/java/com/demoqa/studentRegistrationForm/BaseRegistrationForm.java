package com.demoqa.studentRegistrationForm;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BaseRegistrationForm {

    public void setGender(String gender) {
        $(byText(gender)).click();
    }

    public void uploadFile(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + fileName));
    }

    public void setCurrentAddress(String address) {
        $("#currentAddress").val(address);
    }

    public void setDefaultStateAndCity() {
        $(byText("Select State")).scrollTo().click();
        $(byText("Haryana")).click();
        $(byText("Select City")).scrollTo().click();
        $(byText("Panipat")).click();
    }
}
