package io.keede.kotlinstarter.classes

class Penguin (
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄쓰")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        // 중복되는 인터페이스를 특정할 때 super<타입>.함수 사용
        super<Swimable>.act()
        super<Flyable>.act()
    }

}