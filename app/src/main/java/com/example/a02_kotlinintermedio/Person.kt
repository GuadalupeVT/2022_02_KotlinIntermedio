package com.example.a02_kotlinintermedio

open class Person(name:String, age:Int): Work(), Game {

    //Cualquier clase tienen una superclase "Any"
    open fun work(){
        println("Esta persona está trabajando")
    }

    override fun goToWork() {
        println("Esta persona va al trabajo")
    }

    override val game: String
        get() = "Among Us"

    override fun play() {
        println("Esta persona esta jugando a $game")
    }
}