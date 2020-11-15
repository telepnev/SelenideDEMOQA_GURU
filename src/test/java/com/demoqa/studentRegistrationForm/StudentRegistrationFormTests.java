package com.demoqa.studentRegistrationForm;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends BaseRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Registration student Form")
    public void studentRegistrationTest() {
        Faker faker = new Faker();
        String url = "https://demoqa.com/automation-practice-form",
                firstName = faker.name().nameWithMiddle(),
                lastName = faker.name().lastName(),
                email = "email@email.com",
                gender = "Male",
                mobile = "0123456789",
                subjects = "Art",
                picture = "test.jpg",
                currentAddress = faker.address().fullAddress();


        open(url);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        setGender(gender);
        $("#userNumber").val(mobile);
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        uploadFile(picture);
        setCurrentAddress(currentAddress);
        setDefaultStateAndCity();
        $(byText("Submit")).click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following::td[1]").shouldHave(text(firstName));
        $x("//td[text()='Student Email']/following::td[1]").shouldHave(text(email));
        $x("//td[text()='Gender']/following::td[1]").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following::td[1]").shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']/following::td[1]").shouldNot(empty);
        $x("//td[text()='Subjects']/following::td[1]").shouldHave(text(subjects));
        $x("//td[text()='Hobbies']/following::td[1]").shouldNot(empty);
        $x("//td[text()='Picture']/following::td[1]").shouldHave(text(picture));
        $x("//td[text()='Address']/following::td[1]").shouldHave(text(currentAddress));
        $x("//td[text()='State and City']/following::td[1]").shouldNot(empty);
        
    }


}
