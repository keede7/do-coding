package io.keede.kotlinstarter.classes

class Cat (
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양쓰")
    }
}