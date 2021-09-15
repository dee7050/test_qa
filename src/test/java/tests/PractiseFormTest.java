package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class PractiseFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){
        registrationPage.openPages();

        //registrationPage.typeFirstName(firstName);
       // registrationPage.typeLastName(lastName);
        //registrationPage.typeEmail(userEmail);
       // registrationPage.setGender();
       // registrationPage.typeNumber(userNumber);

        registrationPage.calendar.setDay("28", "March", "2000");


        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/p002.jpg");
        $("#currentAddress").setValue("Street34");

        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldHave(text(firstName + " " + lastName),
             //   text("dow@wu.rt"),text("28 March,2000"),text("Arts"),
             //   text("Music"),text("p002.jpg"),text("Street34"),
             //   text("NCR Delhi"));
    }

}
