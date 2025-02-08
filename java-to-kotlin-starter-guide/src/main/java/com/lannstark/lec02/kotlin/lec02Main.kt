package com.lannstark.lec02.kotlin

import com.lannstark.lec02.Person

/**
 * kotlin 에서는 null 이 가능한 타입을 완전히 다르게 취급 한다!
 */
fun main() {

    // Safe Call
    val str: String? = null
    println(str?.length)

    // Elvis
    var str2: String? = null
    println(str?.length ?: 0)


    val person = Person("test")
//    startsWithACheck(person.name)

}

fun startsWithACheck(str: String): Boolean {
    return str.startsWith("A")
}

// Elvis
fun test2(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("Elivis")
}

fun test(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("String cannot be null")
    }

    return str.startsWith("A")
}

fun startsWithA1_1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("String cannot be null")
}

fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null;
    }

    return str.startsWith("A")
}

fun startsWithA2_1(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    if (str == null) {
        return false;
    }

    return str.startsWith("A")
}

fun startsWithA3_1(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

/**
 * null 아님을 단언!!
 */
fun startWith(str: String?): Boolean {
    return str!!.startsWith("A")
}