package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.Objects;

import static hooks.Hooks.*;
import static locators.Locators.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class ApplyForVisa {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public static String selectedDestination;
    public static String selectedPurpose;

    @Given("User select passport holder country")
    public void user_select_passport_holder_country() throws IOException {
        test = extent.createTest("Select UK Nationality", "User select passport holder country");
        passportHolderUK(driver).selectByValue("230");
        boolean validateNationalitySelection = validatePassportSelection(driver).getText().contains("United Kingdom");
        if (validateNationalitySelection) {
            test.log(Status.PASS, "Test Passed, Nationality is selected");
        } else {
            test.log(Status.FAIL, "Test Failed, Nationality is not selected");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @And("User select the destination")
    public void user_select_the_destination() throws IOException, InterruptedException {
        test = extent.createTest("Select destination", "User select the destination");
        Thread.sleep(2000);
        destinationCountrySelection(driver).selectByValue("13");
        selectedDestination = validateDestinationSelection(driver).getText();
        boolean validateDestinationSelection = validateDestinationSelection(driver).getText().isEmpty();
        Thread.sleep(2000);
        if (!validateDestinationSelection) {
            test.log(Status.PASS, "Test Passed, Destination selected is " + validateDestinationSelection(driver).getText());
        } else {
            test.log(Status.FAIL, "Test Failed, Destination is not selected");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @Then("User select the purpose of travel")
    public void user_select_the_purpose_of_travel() throws IOException, InterruptedException {
        test = extent.createTest("Select purpose of travel", "User select the purpose of travel");
        Thread.sleep(2000);
        purposeTraveling(driver).click();
        String purposeSize = visaNotExists(driver).getSize().toString();
        if (Objects.equals(purposeSize, "(214, 40)")) {
            test.log(Status.WARNING, "Warning, Visa is not exist");
            screenshotEvidence();
            System.exit(1);
        } else {
            selectThirdPurposeTraveling(driver).click();
            selectedPurpose = validatePurposeSelection(driver).getText();
            System.out.println(selectedPurpose);
            Thread.sleep(3000);
            boolean validatePurposeSelection = validatePurposeSelection(driver).getAttribute("title").contains(selectedPurpose);
            boolean validatePurposeSelectionFilled = !validatePurposeSelection(driver).getAttribute("title").isEmpty();
            System.out.println(validatePurposeSelection(driver).getAttribute("title"));
            if (validatePurposeSelection || validatePurposeSelectionFilled) {
                test.log(Status.PASS, "Test Passed, Purpose selected is " + validatePurposeSelection(driver).getText());
            } else {
                test.log(Status.FAIL, "Test Failed, Purpose is not selected");
                methodName = new Object() {
                }.getClass().getEnclosingMethod().getName();
                screenshotEvidence();
                System.exit(1);
            }
        }
    }

    @And("Click on set to go")
    public void click_on_set_to_go() {
        clickSetToGo(driver).click();
    }

    @When("Page displayed")
    public void page_displayed() throws IOException, InterruptedException {
        test = extent.createTest("Page displayed", "User validate that page displayed");
        Thread.sleep(2000);
        boolean visaOrderDisplayed = pageDisplay(driver).getText().contains("no visa requried");
        if (visaOrderDisplayed) {
            test.log(Status.WARNING, "Warning, No visa required");
        } else if (orderNow(driver).isDisplayed()) {
            test.log(Status.PASS, "Test Passed, Page is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Page is not displayed");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @And("Click on order now")
    public void Click_on_order_now() throws IOException, InterruptedException {
        test = extent.createTest("Information page displayed", "User validate Information page is displayed");
        boolean visaOrderDisplayed = pageDisplay(driver).getText().contains("no visa requried");
        if (!visaOrderDisplayed) {
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
            closeWhatsAppChat(driver).click();
            orderNow(driver).click();
            test.log(Status.PASS, "Test Passed, Information page is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Information page is not displayed");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
            System.exit(1);
        }
    }

    @Then("Insert personal info")
    public void insert_personal_info() throws IOException {
        test = extent.createTest("Insert personal info", "User insert that personal info");
        boolean orderSelected = orderSelected(driver).isDisplayed();
        if (orderSelected) {
            test.log(Status.PASS, "Test Passed, Information page is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Information page is not displayed");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
        firstNamePI(driver).sendKeys("Abdulrahman");
        lastNamePI(driver).sendKeys("Test");
        phoneNumberPI(driver).sendKeys("01277205598");
        mobNumberPI(driver).sendKeys("01277260100");
        travelDatePI(driver).sendKeys("22-05-2024");
        emailPI(driver).sendKeys("abdulrahmanmuh10@gmail.com");
        appFirstMiddleNamePI(driver).sendKeys("Abdulrahman Muhammed");
        appLastNamePI(driver).sendKeys("Test");
        billingAddressPI(driver).sendKeys("FORTENAY HOUSE");
        billingCityPI(driver).sendKeys("BRENTWOOD");
        billingCountryPI(driver).selectByValue("GB");
        postalCodePI(driver).sendKeys("CM15 9GB");

        test.log(Status.PASS, "Test Passed, Information is inserted successfully");
    }

    @And("Select payment option")
    public void select_payment_option() throws IOException {
        test = extent.createTest("Select payment option", "User select payment option");
        paymentOptionPI(driver).click();
        if (paymentOptionPI(driver).isSelected()) {
            test.log(Status.PASS, "Test Passed, Payment option is selected successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Payment option is not selected");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @When("Click on revision and payment")
    public void click_on_revision_and_payment() throws InterruptedException, IOException {
        test = extent.createTest("Click on revision and payment", "User click on revision and payment");
        String rowSize = deliveryAddressSize(driver).getSize().toString();
        if (Objects.equals(rowSize, "(710, 240)")) {
            if (selectDeliveryAddressPI(driver).isSelected()) {
                clickRevisionPayment(driver).click();
            } else {
                selectDeliveryAddressPI(driver).click();
                Thread.sleep(2000);
                js.executeScript("window.scrollBy(0,-1000)");
                clickRevisionPayment(driver).click();
            }
        } else {
            js.executeScript("window.scrollBy(0,-1000)");
            clickRevisionPayment(driver).click();
            Thread.sleep(4000);
            boolean paymentVisaTypes = paymentVisaTypes(driver).isDisplayed();
            if (paymentVisaTypes) {
                test.log(Status.PASS, "Test Passed, Revision payment is clicked");
            } else {
                test.log(Status.FAIL, "Test Failed, Revision payment is not clicked");
                methodName = new Object() {
                }.getClass().getEnclosingMethod().getName();
                screenshotEvidence();
            }
        }
    }

    @And("Select visa type")
    public void select_visa_type() throws InterruptedException, IOException {
        test = extent.createTest("Select payment way", "User select payment way");
        Thread.sleep(3000);
        selectVisaType(driver).click();
        boolean formDisplayed = formDisplayed(driver).isDisplayed();
        if (formDisplayed) {
            test.log(Status.PASS, "Test Passed, Visa type is selected successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Visa type is not selected");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @Then("Insert visa details")
    public void insert_visa_details() throws InterruptedException {
        test = extent.createTest("Insert visa details", "User insert visa details");
        cardNumber(driver).sendKeys("5226925750920378");
        cardExpiryDateMonth(driver).sendKeys("12");
        cardExpiryDateYear(driver).sendKeys("26");
        cardCvv(driver).sendKeys("411");
        Thread.sleep(2000);

        test.log(Status.PASS, "Test Passed, Visa details is inserted successfully");
    }

    @And("Click submit request")
    public void click_submit_request() throws IOException {
        test = extent.createTest("Confirm card", "User click confirm card details");
        confirmCard(driver).click();
        boolean reviewPageOrder = reviewOrderPage(driver).isDisplayed();
        if (reviewPageOrder) {
            test.log(Status.PASS, "Test Passed, Confirm card is clicked");
        } else {
            test.log(Status.FAIL, "Test Failed, Confirm card is not clicked");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    @And("Click pay now")
    public void click_pay_now() throws IOException {
        test = extent.createTest("Order reviewed", "User review order and pay");
        clickPayNow(driver).click();
        boolean verifyByText = verificationPage(driver).isDisplayed();
        if (verifyByText) {
            test.log(Status.PASS, "Test Passed, Verification is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Verification is not displayed");
            methodName = new Object() {
            }.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }

    /*@When("Click continue, insert code and passcode")
    public void click_continue_insert_code_and_passcode() throws InterruptedException {
        test = extent.createTest("Continue", "User click continue");
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Thread.sleep(2000);
        clickContinue(driver).click();

        Thread.sleep(15000);
        clickSubmitButton(driver).click();
        Thread.sleep(15000);
        clickSubmitButton(driver).click();

        test.log(Status.PASS, "Test Passed, Continue is clicked");
    }

    @Then("User validate the visa paid and application created")
    public void user_validate_the_visa_paid_and_application_created() throws IOException {
        test = extent.createTest("Validate payment", "User select payment option");
        boolean validatePaymentDone = driver.findElement(By.cssSelector("div[class='are-404']")).getText().contains("You have successfully created visa application");
        boolean visaPaidAndCreated = visaPaidAndCreated(driver).isDisplayed();
        if (validatePaymentDone || visaPaidAndCreated) {
            test.log(Status.PASS, "Test Passed, Payment is successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Payment is not successfully");
            methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            screenshotEvidence();
        }
    }*/
}
