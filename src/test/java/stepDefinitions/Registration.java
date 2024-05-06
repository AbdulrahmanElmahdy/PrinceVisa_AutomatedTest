package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static hooks.Hooks.*;
import static locators.Locators.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class Registration {

    @Given("User click on my account")
    public void user_click_on_my_account() throws IOException {
        test = extent.createTest("My Account Mini Page is displayed", "User click on my account and validate page opened with signup button");
        clickMyAccount(driver).click();
        boolean signUpSmallButtonIsDisplayed = validateMyAccountPageSignUp(driver).isDisplayed();
        if (signUpSmallButtonIsDisplayed) {
            test.log(Status.PASS, "Test Passed, My account mini page is displayed with signup button");
        } else {
            test.log(Status.FAIL, "Test Failed, My account mini page is not displayed");
            methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @And("User click on sign up")
    public void user_click_on_sign_up() throws IOException {
        clickSignUp(driver).click();
        boolean signUpButtonDisplayed = clickSignUpButton(driver).isDisplayed();
        if (signUpButtonDisplayed) {
            test.log(Status.PASS, "Test Passed, Sign up button is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Sign up button is not displayed");
            methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @Then("Insert First Name")
    public void insert_first_name() {
        insertFirstName(driver).sendKeys("Abdulrahman");
    }

    @And("Insert Last Name")
    public void insert_last_name() {
        insertLastName(driver).sendKeys("Amer");
    }

    @Then("Insert Email")
    public void insert_email() {
        insertEmail(driver).sendKeys("abdelrahman94_testgmail.com");
    }

    @And("Insert Password and Confirm password")
    public void insert_password_and_confirm_password() {
        insertPassword(driver).sendKeys("A@94#13$26");
        insertPasswordCnfrm(driver).sendKeys("A@94#13$26");
    }

    @When("User clicked on sign up button")
    public void user_clicked_on_sign_up_button() {
        clickSignUpButton(driver).click();
    }

    @Then("Success message will displayed")
    public void success_message_will_displayed() throws IOException, InterruptedException {
        test = extent.createTest("Success message will displayed", "User success message will displayed");
        Thread.sleep(2000);
        boolean successfulMessageDisplayed = successfulMessage(driver).getText().contains("You have been successfully registered with Prince Visa.");
        boolean emailExistMessageDisplayed = emailExistMessage(driver).getText().contains("Email already exists");
        System.out.println(successfulMessage(driver).getText());
        System.out.println(emailExistMessage(driver).getText());
        if (successfulMessageDisplayed) {
            test.log(Status.PASS, "Sign up successfully done");
        } else if (emailExistMessageDisplayed) {
            test.log(Status.WARNING, "Email already exist");
        } else {
            test.log(Status.FAIL, "Sign up failed");
            methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }
}
