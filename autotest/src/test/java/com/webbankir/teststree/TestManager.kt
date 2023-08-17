import com.webbankir.teststree.greetings.phone_number_screen.PhoneNumberScreen
import com.webbankir.teststree.sign_up.calculator_screen.CalculatorScreen
import io.appium.java_client.android.AndroidDriver
import io.qameta.allure.Allure
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Step
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait
import org.junit.jupiter.api.Test
import io.qameta.allure.Story
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.junit.jupiter.api.DisplayName
import org.openqa.selenium.OutputType
import java.net.URL
import java.time.Duration
//for ios

@Aspect
class AllureStepAspect {

    @Pointcut("execution(@io.qameta.allure.Step * *(..))")
    fun stepMethod() {}

    @After("stepMethod()")
    fun logStepExecution(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        println("Executing step: $methodName")
    }
}


@Story("grandma dick")
class TestManager {
    //for ios
//    private fun createCapabilities(): DesiredCapabilities {
//        val caps = DesiredCapabilities()
//
//        caps.setCapability("platformName", "iOS")
//        caps.setCapability("deviceName", "iPhone 14 Pro")
//        caps.setCapability("bundleId", "com.webbankir.app")
//        caps.setCapability("automationName", "XCUITest")
//
//        return caps
//    }

    //for android
    private fun createCapabilities():DesiredCapabilities{
        val caps = DesiredCapabilities()

        caps.setCapability("platformName", "Android")
        caps.setCapability("deviceName", "shnir")
        caps.setCapability("app", "/Users/sashachernov/Downloads/app.apk")
        caps.setCapability("automationName", "uiautomator2")

        return caps
    }

    @Test
    @Story("Регистрация")
    @Feature("Регистрация")
    @DisplayName("Проверка связи")
    fun signUp() {
       // val driver = IOSDriver(URL("http://0.0.0.0:4723/"), createCapabilities())
        //for android
        val driver = AndroidDriver(URL("http://0.0.0.0:4723/"), createCapabilities())
        val wait = WebDriverWait(driver, Duration.ofSeconds(20)) // Ожидание до 20 секунд

        try {
            teststep()
            PhoneNumberScreen(driver, wait).start()
            CalculatorScreen(driver, wait).start()
            //inputFIO()
            println("Тесты успешно завершены!")
        } catch (e: Throwable) {
            println("Произошла ошибка: ${e.message}")
            takeScreenshot(driver)
            throw e
        }
        finally {
            // Закроем сессию после выполнения действий
            driver.quit()
        }
    }

//    @Step("Заполняем поле ФИО")
//    private fun inputFIO(wait: WebDriverWait) {
//        println("Заполняем поле ФИО")
//        val FIOfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id())
//    }
private fun takeScreenshot(driver: AndroidDriver) {
    val screenshot = driver.getScreenshotAs(OutputType.BYTES)
    Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", screenshot)
}
}
@Test
@Step("ALLO BLIA")
private fun teststep(){}