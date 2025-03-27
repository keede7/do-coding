package io.keede.kotlinstarter.classes

class Person private constructor(
    private var name: String,
    private var age: Int
) {

    // static 함수
    companion object Factory {
        private val MIN_AGE = 1 // 런타임시 변수 할당
        private const val MIN_AGE2 = 1 // 컴파일시 변수 할당

        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }
    }

}