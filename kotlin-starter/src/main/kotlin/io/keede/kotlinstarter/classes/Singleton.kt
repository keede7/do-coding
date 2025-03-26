package io.keede.kotlinstarter.classes

// 싱글톤 객체 생성
object Singleton {
}

fun main() {
    // 익명클래스를 사용할 경우
    moveSomething(object: Movable {
        override fun move() {

        }

        override fun fly() {

        }
    })
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

interface Movable {
    fun move()
    fun fly()
}