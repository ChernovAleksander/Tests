package com.webbankir.teststree.greetings.phone_number_screen

import io.appium.java_client.android.AndroidDriver
import io.qameta.allure.Description
import io.qameta.allure.Step
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

@Story("PhoneNumberScreen")
@DisplayName("Экран ввода номера телефона")
class PhoneNumberScreen(private val driver: AndroidDriver, private val wait: WebDriverWait) {

   @Test
    fun start(){
        clickFirstButton(wait = wait)
        inputPhoneNumber(wait = wait, phoneNumber = "00012332121")
        clickSecondButton(wait = wait)
    }

    //@Step("Клик по первой кнопке")
//    private fun clickFirstButton() {
//        val wait = WebDriverWait(driver, Duration.ofSeconds(10)) // Ждем до 10 секунд
//        val buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeApplication[@name=\"Webbankir\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")))
//        buttonElement.click()
//    }
    //for android
    @Step("Клик по первой кнопке...")
    private fun clickFirstButton(wait: WebDriverWait) {
        val buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.webbankir:id/btnNext")))
        buttonElement.click()
    }

    @Step("Ввод номера телефона")
    private fun inputPhoneNumber(wait: WebDriverWait, phoneNumber: String) {
        println("Ввод номера телефона...")
        val phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.webbankir:id/numberEditText")))
        phoneNumberField.sendKeys("00012332121") // Замените на нужный вам номер телефона
    }

    @Step("Клик по второй кнопке")
    private fun clickSecondButton(wait: WebDriverWait) {
        println("Клик по второй кнопке...")
        val buttonElementt =
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.webbankir:id/btnNext")))
        buttonElementt.click()
    }
}