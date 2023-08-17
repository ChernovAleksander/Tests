package com.webbankir.teststree.sign_up.calculator_screen
import java.time.LocalDate
import java.time.Period
import java.util.concurrent.ThreadLocalRandom

class BirthdayGenerator {
    fun generateRandomDate(): LocalDate {
        val currentDate = LocalDate.now()
        val minBirthDate = currentDate.minusYears(65)
        val maxBirthDate = currentDate.minusYears(20)
        val randomYear = ThreadLocalRandom.current().nextInt(minBirthDate.year, maxBirthDate.year + 1)
        val randomMonth = ThreadLocalRandom.current().nextInt(1, 13)
        val randomDay = ThreadLocalRandom.current().nextInt(1, LocalDate.of(randomYear, randomMonth, 1).lengthOfMonth() + 1)

        return LocalDate.of(randomYear, randomMonth, randomDay)
    }
}