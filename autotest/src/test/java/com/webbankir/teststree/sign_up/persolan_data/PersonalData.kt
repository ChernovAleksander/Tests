package com.webbankir.teststree.sign_up.persolan_data

import com.webbankir.teststree.sign_up.calculator_screen.BirthdayGenerator
import io.appium.java_client.android.AndroidDriver
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
        dateOfIssueField.sendKeys(formattedDate)
    }
}



