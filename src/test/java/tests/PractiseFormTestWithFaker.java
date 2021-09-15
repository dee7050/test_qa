package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PractiseFormTestWithFaker extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().streetAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "Arts",
            gender = "Male",
            hobbies = "Music",
            state = "NCR",
            city = "Delhi",
            file = "img/p002.jpg";
    @Test
    void fillFormTest(){
        registrationPage.openPages();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.typeNumber(phoneNumber);

        registrationPage.calendar.setDay("28", "March", "2000");

        registrationPage.enterSubject(subject);
        registrationPage.enterHobbie(hobbies);
        registrationPage.picUpload(file);
        registrationPage.curAddressInput(currentAddress);
        registrationPage.dropdownState();
        registrationPage.selectState(state);
        registrationPage.dropdownCity();
        registrationPage.selectCity(city);
        registrationPage.clickFinal();

        registrationPage.resultChek();
        registrationPage.chekResult(firstName,lastName,userEmail,phoneNumber,gender,
                                    subject,hobbies,currentAddress,state,city);
    }

}
