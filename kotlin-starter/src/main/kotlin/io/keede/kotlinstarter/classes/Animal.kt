package io.keede.kotlinstarter.classes

abstract class Animal (
    // open 프로퍼티 사용시 예상치 못한 버그 발생
    protected val species: String,
    protected open val legCount: Int
) {
   abstract fun move()
}