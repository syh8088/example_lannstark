package com.group.libraryapp.calculator

data class Calculator(
    private var number: Int,
) {

    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand <= 0) {
            throw IllegalArgumentException("Division by zero")
        }

        this.number /= operand
    }


}

 class Calculator2(
     private var _number: Int,
) {

     val number: Int
     get() = this._number

    fun add(operand: Int) {
        this._number += operand
    }

    fun minus(operand: Int) {
        this._number -= operand
    }

    fun multiply(operand: Int) {
        this._number *= operand
    }

    fun divide(operand: Int) {
        if (operand <= 0) {
            throw IllegalArgumentException("Division by zero")
        }

        this._number /= operand
    }


}