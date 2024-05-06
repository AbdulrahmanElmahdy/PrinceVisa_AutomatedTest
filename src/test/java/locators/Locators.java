package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static hooks.Hooks.driver;

public class Locators {

    // Sign Up
    public static WebElement clickMyAccount(WebDriver driver) {
        return driver.findElement(By.cssSelector("li[id='account-button']"));
    }

    public static WebElement validateMyAccountPageSignUp(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[data-target='#signup']"));
    }

    public static WebElement clickSignUp(WebDriver driver) {
        return driver.findElement(By.linkText("Sign up"));
    }

    public static WebElement insertFirstName(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='firstName']"));
    }

    public static WebElement insertLastName(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='lastName']"));
    }

    public static WebElement insertEmail(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='signupEmail']"));
    }

    public static WebElement insertPassword(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='signupPassword']"));
    }

    public static WebElement insertPasswordCnfrm(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='signupPasswordCnfrm']"));
    }

    public static WebElement clickSignUpButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[onclick='signUp()']"));
    }

    public static WebElement successfulMessage(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[id='signUpSuccess']"));
    }

    public static WebElement emailExistMessage(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[id='emailSignUpError']"));
    }

    // Login

    /*public static WebElement insertLoginEmail(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='loginEmail']"));
    }

    public static WebElement insertLoginPassword(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='loginPassword']"));
    }

    public static WebElement clickLoginButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[onclick='userLogin()']"));
    }

    public static WebElement validateDashboardDisplayed(WebDriver driver) {
        return driver.findElement(By.className("application-detail-section"));
    }

    // Forget Password
    public static WebElement clickForgetPassword(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[data-target='#forget-pass']"));
    }

    public static WebElement insertForgetEmail(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='forgetEmail']"));
    }

    public static WebElement clickSubmit(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[id='forgetPass']"));
    }

    public static WebElement validateEmailSentMessage(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[id='forgetPassError']"));
    }*/
    //div[id='forgetPassError'] Confirmation email sent. Please Check your email

    // Passport Destination Purpose Locators

    public static WebElement validatePassportSelection(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-holder-country-container\"]"));
    }

    public static WebElement validateDestinationSelection(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-destination-country-container\"]"));
    }

    public static WebElement validatePurposeSelection(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-container\"]"));
    }

    public static Select passportHolderUK(WebDriver driver) {
        return new Select(driver.findElement(By.xpath("//*[@id=\"search-holder-country\"]")));
    }

    public static Select destinationCountrySelection(WebDriver driver) {
        return new Select(driver.findElement(By.xpath("//*[@id=\"search-destination-country\"]")));
    }

    public static WebElement purposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-container\"]"));
    }

    public static WebElement selectFirstPurposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]/li[2]"));
    }

    public static WebElement selectSecondPurposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]/li[3]"));
    }

    public static WebElement selectThirdPurposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]/li[4]"));
    }

    public static WebElement selectForthPurposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]/li[5]"));
    }

    public static WebElement selectFifthPurposeTraveling(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]/li[6]"));
    }

    public static WebElement clickSetToGo(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='btn btn-primary mb-2']"));
    }

    public static WebElement pageDisplay(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div/div/div"));
    }

    public static WebElement visaNotExists(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"select2-search-purpose-results\"]"));
    }

    public static WebElement clickPurpose(WebDriver driver) {
        return driver.findElement(By.cssSelector("span[id='select2-search-purpose-container']"));
    }

    /*public static WebElement requiredDocuments(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[class='col-lg-4 col-md-6']"));
    }*/

    //Select Order
    public static WebElement closeWhatsAppChat(WebDriver driver) {
        return driver.findElement(By.cssSelector("svg[class='df-svg-icon']"));
    }

    public static WebElement orderNow(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[onclick=\"getOrderId('1')\"]"));
    }

    public static WebElement orderSelected(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"step2\"]/div[2]/div/div[1]/div/h2"));
    }

    // Personal Information
    public static WebElement firstNamePI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='signup_fname']"));
    }

    public static WebElement lastNamePI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='signup_lname']"));
    }

    public static WebElement phoneNumberPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='phone_number']"));
    }

    public static WebElement mobNumberPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='mob_number']"));
    }

    public static WebElement travelDatePI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='travel_date']"));
    }

    public static WebElement emailPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='checkEmailsignup']"));
    }

    public static WebElement appFirstMiddleNamePI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='first_name1']"));
    }

    public static WebElement appLastNamePI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='last_name1']"));
    }

    public static WebElement billingAddressPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='billing_address']"));
    }

    public static WebElement billingCityPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='billing_city']"));
    }

    public static Select billingCountryPI(WebDriver driver) {
        return new Select(driver.findElement(By.xpath("//*[@id=\"billing_country\"]")));
    }

    public static WebElement postalCodePI(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]"));
    }

    public static WebElement selectDeliveryAddressPI(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='radio1']"));
    }

    public static WebElement deliveryAddressSize (WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"step2\"]/div[2]/div/div[2]/div[1]/div[5]/div/div/form"));
    }

    //Payment option

    public static WebElement paymentOptionPI(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"radio_pay_now\"]"));
    }

    public static WebElement clickRevisionPayment(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[onclick='payment()']"));
    }

    public static WebElement paymentVisaTypes(WebDriver driver) {
        return driver.findElement(By.cssSelector("ol[class='layout  payment-method-list']"));
    }

    //Payment process
    public static WebElement selectVisaType(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/ol/li[5]/form/button/span[2]"));
    }

    public static WebElement formDisplayed(WebDriver driver) {
        return driver.findElement(By.cssSelector("form[method='post']"));
    }

    //Visa info
    public static WebElement cardNumber(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='form-card_details.field-pan']"));
    }

    public static WebElement cardExpiryDateMonth(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='form-card_details.field-expiry_mm']"));
    }

    public static WebElement cardExpiryDateYear(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='form-card_details.field-expiry_yy']"));
    }

    public static WebElement cardCvv(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='form-card_details.field-cvc']"));
    }

    public static WebElement confirmCard(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='btn btn--positive btn--large--if-palm btn--full--if-palm']"));
    }

    public static WebElement reviewOrderPage(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/div"));
    }

    public static WebElement clickPayNow(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='btn btn--positive btn--large--if-palm btn--full--if-palm']"));
    }

    public static WebElement clickContinue(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"ContinueButton\"]"));
    }

    public static WebElement verificationPage(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[class='layout__item 1/1 lap-and-up-2/3']"));
    }

    public static WebElement clickSubmitButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[id='ValidateButton']"));
    }

    public static WebElement visaPaidAndCreated(WebDriver driver) {
        return driver.findElement(By.xpath("//*[contains(text(),'You have successfully created visa application')]"));
    }
}
