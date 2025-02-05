package com.lannstark.lec11.kotlin

/**
 * 3. 다양한 구성요소의 접근 제어 - 생성자
 */
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}