package com.lannstark.lec08.kotlin

fun main() {

    repeat("Hello World")

    // 3. named argument
    repeat("Hello World", useNewLine = false)
    printNameAndGender(name = "test", gender = "Male")

    // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
    // 문자열을 N개 받아 출력
    printAll("A", "B", "C")
    var array = arrayOf("A", "B", "C")

    // 배열을 바로 넣는 대신 스프레드 연산자 (*) 를 붙여주어야 합니다.
    printAll(* array)
}

// 1. 두 정수를 받아 더 큰 정수를 반환하는 예제
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

// 2. default parameter
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println("$str")
        }
        else {
            print("$str")
        }
    }
}

// 3. named argument
fun printNameAndGender(name: String, gender: String) {
    println("$name")
    println("$gender")
}

// 4. 같은 타입의 여러 파라미터 받기 (가변인자)
// 문자열을 N개 받아 출력
fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}
