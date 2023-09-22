package com.webbankir.teststree.sign_up.persolan_data

import com.webbankir.teststree.sign_up.calculator_screen.BirthdayGenerator
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.touch.TapOptions
import io.appium.java_client.touch.offset.PointOption
import io.qameta.allure.Step
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Story("PersonalData")
@DisplayName("экран персональных данных")
class PersonalData (private val driver: AndroidDriver, private val wait: WebDriverWait, private val birthdayGenerator: BirthdayGenerator) {

    fun start() {
        setRandomBirthday()
        Bplace()
        gender()
        setRandomPassportNumber()
        setTodayAsDateOfIssue()
        CodePassport()
        issuedByPassport()
        adress()
    }

    @Step
    fun setRandomBirthday() {
        val randomBirthday = birthdayGenerator.generateRandomDate()
        val day = randomBirthday.dayOfMonth
        val month = randomBirthday.monthValue
        val year = randomBirthday.year
        val formattedBirthday = "$year-$month-$day"
        val birthdayField = driver.findElement(By.id("com.webbankir:id/birthdateEditText"))
        birthdayField.sendKeys(formattedBirthday)
    }

    @Step
    fun Bplace(){
        val bplacefild = driver.findElement(By.id("com.webbankir:id/placeOfBirthEditText"))
        val city = "Тестландия"
        bplacefild.click()
        bplacefild.sendKeys(city)
    }
    @Step
    fun gender(){
        val genderchange = driver.findElement(By.id("com.webbankir:id/femaleGender"))
        genderchange.click()
    }

    @Step
    fun setRandomPassportNumber() {
        val randomPassportNumber = generateRandomNumber()
        val passportField = driver.findElement(By.id("com.webbankir:id/seriesAndNumberOfPassportEditText"))
        passportField.sendKeys(randomPassportNumber)
    }

    @Step
    private fun generateRandomNumber(): String {
        val randomNumber = StringBuilder(10)
        for (i in 1..10) {
            val digit = Random.nextInt(10)
            randomNumber.append(digit)
        }
        return randomNumber.toString()
    }

    @Step
    fun setTodayAsDateOfIssue() {
        val currentDate = LocalDate.now()
        val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd MM yyyy"))
        val dateOfIssueField = driver.findElement(By.id("com.webbankir:id/dateOfIssuePassportEditText"))
        dateOfIssueField.click()
        dateOfIssueField.sendKeys(formattedDate)
    }

    @Step
    fun CodePassport() {
        val setCodePassport = driver.findElement(By.id("com.webbankir:id/divisionCodePassportEditText"))
        val scrollOptions = mapOf("direction" to "down")
        (driver as AndroidDriver).executeScript("mobile: scroll", scrollOptions)
        setCodePassport.click()
        setCodePassport.sendKeys("77017")
    }

    @Step
    fun issuedByPassport() {
        val xCoordinate = 560 // Пример: x-координата
        val yCoordinate = 1355 // Пример: y-координата

// Используйте TouchAction для выполнения клика по указанным координатам
        val touchAction = TouchAction(driver as AndroidDriver)
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(xCoordinate, yCoordinate))).perform()
    }

    @Step
    fun adress() {
        val setAdress = driver.findElement(By.id("com.webbankir:id/passportRegistrationAddressEditText"))
        setAdress.click()
        setAdress.sendKeys("Арбат 40")
        val x = 549
        val y = 515
        val touchAction = TouchAction(driver as AndroidDriver)
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y))).perform()
        (driver as AndroidDriver).hideKeyboard()
    }
    @Step
    fun nextstep() {
        val buttonnext = driver.findElement(By.id("com.webbankir:id/btnNext"))
        buttonnext.click()
    }
}



