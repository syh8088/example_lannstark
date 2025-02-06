package com.lannstark.lec15.kotlin

fun main() {

    /**
     * 배열
     */
    val array = arrayOf(100, 200)
    array.plus(300)

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    for ((idx, value) in array.withIndex()) {
        println("$idx: $value")
    }

    /**
     * 코틀린에서의 collection
     *
     * - 컬랙션을 만들어 줄때 '불변' 인지 '가변' 인지 설정 해줘야 합니다.
     */
    val numbers = listOf(100 ,200) // listOf 를 통해 '불변 리스트' 를 만든다.
    val numbers2 = mutableListOf(100 ,200) // mutableListOf 를 통해 '가변 리스트' 를 만든다.
    numbers2.add(300)

    val emptyList = emptyList<Int>()

    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx: $value")
    }

    val numbers3 = mutableSetOf(100, 100)

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY", 3 to "WEDNESDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

    /**
     * 컬렉션의 null 가능성, Java 와 함께 사용하기
     *
     * - List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
     * - List<Int>? : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
     * - List<Int?>? : 리스트에 nu이 들어갈 수도 있고, 리스트가 null일 수도 있음
     */


}