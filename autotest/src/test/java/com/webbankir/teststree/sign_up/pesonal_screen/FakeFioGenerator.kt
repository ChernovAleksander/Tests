package com.webbankir.teststree.sign_up.pesonal_screen

class FakeFioGenerator {

    private val names = arrayOf("Бориславдревний", "Афанасийкарамелька", "Гертрудафантик", "Васянеклубника", "Зиновийпельмень", "Ольгамандаринка", "Ипполитрадуган", "Феодосийморж", "Евградуга", "Марфахлебник")
    private val middleName = arrayOf("Пельменович", "Бубликович", "Котлетович", "Вареникович", "Шарикович", "Мандаринович", "Хлебникович", "Пиццович", "Карамелькович", "Гогонович")
    private val lastName = arrayOf("Дрыгалкин", "Плюшкин", "Прошкин", "Пельменёв", "Попкорнов", "Забиякин", "Торопыжкин", "Пупкин", "Колесников", "Пельменихин")

    fun generateFio(): String = "${lastName.random()} ${names.random()} ${middleName.random()}"
}