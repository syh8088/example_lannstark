package com.lannstark.lec10.kotlin

class Penguin(
    species: String
) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("팽귄이 움직인다~ 꿱꿱")
    }

    override val legCount: Int
        get() {
            return super.legCount + this.wingCount
        }
}