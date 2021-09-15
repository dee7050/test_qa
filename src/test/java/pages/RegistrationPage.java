package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    protected final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChose = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            uploadButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateSelect =  $("#state"),
            cityDropdown = $("#city"),
            citySelect = $("#city"),
            finalClick = $("#submit"),
            finalTableHead = $(".modal-title"),
            finalTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPages() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {firstNameInput.setValue(value);}

    public void typeLastName(String value) {lastNameInput.setValue(value);}

    public void typeEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void setGender(String gender) {genderChose.$(byText(gender)).click();}

    //public void setGender(String value) {genderChose.setValue(value).click();}

    public void typeNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void enterSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void enterHobbie(String hobbie) {hobbieInput.$(byText(hobbie)).click();}

    public void picUpload(String file) {uploadButton.uploadFromClasspath(file);}

    public void curAddressInput(String value) {currentAddressInput.setValue(value);}

    public void dropdownState() {stateDropdown.click();}

    public void selectState(String stat) {stateSelect.$(byText(stat)).click();}

    public void dropdownCity() {cityDropdown.click();}

    public void selectCity(String city) {citySelect.$(byText(city)).click();}

    public void clickFinal() {finalClick.click();}



    public void resultChek() {finalTableHead.shouldHave(text("Thanks for submitting the form"));}

    public void chekResult(String firstName, String lastName, String userEmail, String phoneNumber, String gender,
    String subject, String hobbies, String currentAddress, String state, String city )
    {
             finalTable.shouldHave(text(firstName + " " + lastName),
                                  text(userEmail),
                                  text(phoneNumber),
                                  text("28 March,2000"),
                                  text(gender),
                                  text(subject),
                                  text(hobbies),
                                  text("p002.jpg"),
                                  text(currentAddress),
                                  text(state),
                                  text(city)
             );
    }
}


