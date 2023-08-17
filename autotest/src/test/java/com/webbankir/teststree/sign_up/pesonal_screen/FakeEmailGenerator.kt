package com.webbankir.teststree.sign_up.pesonal_screen

import kotlin.random.Random

class FakeEmailGenerator {
    fun generateEmail(): String {
        val mailDomains = listOf("mail.ru", "yandex.ru", "hotmail.com", "gmail.com")
        val userName = (1..Random.nextInt(3, 9)).map { ('a'..'z').random() }.joinToString("")
        return "$userName@${mailDomains.random()}"
    }
}