package com.webbankir.teststree.sign_up.calculator_screen

import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import io.qameta.allure.Step
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

@Story("CalculatorScreen")
@DisplayName("Первый калькулятор")
class CalculatorScreen(private val driver: AndroidDriver, private val wait: WebDriverWait) {

    @Test
    fun start() {
        EditCalckSum()
        EditCalckDays()
        clickButtonCalck()
    }

    @Step("Изменяем сумму")
    private fun EditCalckSum() {
        println("Сумма изменена")
        val seekBar = WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("com.webbankir:id/seekBar")))

        // Возможно, стоит также проверить видимость элемента перед взаимодействием
        WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(seekBar))

        leftRightSwipeSum(seekBar)
    }

    private fun leftRightSwipeSum(seekBar: WebElement) {
        val size = driver.manage().window().size
        val startx = (size.width * 0.30).toInt()
        val endx = (size.width * 0.50).toInt()
        val starty = seekBar.location.y + seekBar.size.height / 2

        val touchAction = TouchAction(driver)
        touchAction.press(PointOption.point(startx, starty))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(9000)))
            .moveTo(PointOption.point(endx, starty))
            .release()
            .perform()
    }
    @Step("Изменяем срок")
    private fun EditCalckDays() {
        println("Сумма изменена")
        driver.findElement(By.id("com.webbankir:id/seekBar"))
        leftRightSwipeDays()
    }
    private fun leftRightSwipeDays() {
        val size = driver.manage().window().size
        val startx = (size.width / 4.5).toInt()
        val endx = (size.width / 3.137).toInt()
        val starty = (size.height / 2.011).toInt()

        val touchAction = TouchAction(driver)
        touchAction.press(PointOption.point(startx, starty))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(9000)))
            .moveTo(PointOption.point(endx, starty))
            .release()
            .perform()
    }

    @Step("Клик Продолжить на калькуляторе")
    private fun clickButtonCalck() {
        val buttonCalck = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.webbankir:id/btnNext")))
        buttonCalck.click()
    }
}