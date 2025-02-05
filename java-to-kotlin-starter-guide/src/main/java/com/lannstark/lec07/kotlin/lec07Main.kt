package com.lannstark.lec07.kotlin

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {

    fun parseIntOrThrow(str: String): Int {
        try {
            return str.toInt()
        }
        catch (e: NumberFormatException) {
            throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
        }
    }

    fun parseIntOrThrow2(str: String): Int? {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun readFile() {
       val currentFile = File(".")
       val file = File(currentFile.absolutePath + "/a.txt")
       val reader = BufferedReader(FileReader(file))
       println(reader.readLine())
       reader.close()
    }

    // Kotlin 에서는 try with resource 구문이 없습니다.
    // 대신 Kotlin 의 언어적 특징을 활용해 close 를 호출해준다.
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { br -> {
            println(br.readLine())
        }}
    }
}