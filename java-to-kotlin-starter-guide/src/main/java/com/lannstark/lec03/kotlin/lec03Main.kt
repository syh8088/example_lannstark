package com.lannstark.lec03.kotlin

import com.lannstark.lec03.Person

fun main() {

    val number1 = 3
    val number2: Long = number1.toLong()

    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0

    val person = Person("test", 100)
    println("이름 : ${person.name}")

    var str = """
        ABCD
        EFG
        ${person.name}
    """.trimIndent()
    println(str)

    var str2 = "ABC"
    println(str2[0])
    println(str2[1])
    println(str2[2])


}

/**
 * 타입 캐스팅
 */
fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
    }
}

fun printAgeIfPerson2(obj: Any) {
    if (obj !is Person) {
        val person = obj as Person
        println(person.age)
    }
}

fun printAgeIfPerson3(obj: Any?) {
    var person = obj as? Person
    println(person?.age)
}