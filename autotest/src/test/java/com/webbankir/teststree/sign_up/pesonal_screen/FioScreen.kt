package com.webbankir.teststree.sign_up.pesonal_screen

import io.appium.java_client.android.AndroidDriver
import io.qameta.allure.Step
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

@Story("FIOScreen")
@DisplayName("экран ФИО")
class FioScreen(private val driver: AndroidDriver, private val wait: WebDriverWait, private val fakeFioGenerator: FakeFioGenerator, private val fakeEmailGenerator: FakeEmailGenerator) {

    fun start() {
        Fioinput(wait)
        val generatedFio = fakeFioGenerator.generateFio() // Генерируем ФИО
        Emailinput(driver, wait)
        val generatedEmail = fakeEmailGenerator.generateEmail() // Генерируем email
        Arrowagriments(driver, wait)
        Clickbutton(driver)
    }

    @Step
    private fun Fioinput(wait: WebDriverWait) {
        val fiofield =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.webbankir:id/fullNameEditText")))
        val fio = fakeFioGenerator.generateFio()
        fiofield.sendKeys(fio)
    }

    @Step
    private fun Emailinput(driver: AndroidDriver, wait: WebDriverWait) {
        val emailfield = driver.findElement(By.id("com.webbankir:id/emailEditText"))
        emailfield.click()
        emailfield.sendKeys(fakeEmailGenerator.generateEmail())
        val dadatahelperemail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")))
        dadatahelperemail.click()
        (driver as AndroidDriver).hideKeyboard()
    }

    @Step
    private fun Arrowagriments(driver: AndroidDriver, wait: WebDriverWait) {
        val arrowopenagriments = driver.findElement(By.id("com.webbankir:id/arrows"))
        arrowopenagriments.click()
        val agriment1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.CheckBox")))
        val agriment2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.CheckBox"))
        agriment1.click()
        agriment2.click()
    }

    @Step
    private fun Clickbutton(driver: AndroidDriver) {
        val buttonElement = driver.findElement(By.id("com.webbankir:id/btnNext"))
        buttonElement.click()
    }
}