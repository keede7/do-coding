package io.keede.kotlinstarter.functions

// 확장함수
/*
    1. 원본 클래스의 private, protected 멤버 접근 불가능
    2. 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
    3. 확장함수는 현재 타입을 기준으로 호출된다.
 */
// custom getter에도 사용이 가능하다. get() = ...
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 만약 멤버함수와 확장함수의 시그니처가 같으면 멤버함수가 먼저 호출된다.
fun main() {
    val s: String = "asdf"

    println(s.lastChar())
}
