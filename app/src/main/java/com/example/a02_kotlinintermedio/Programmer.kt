package com.example.a02_kotlinintermedio

class Programmer(name:String,age:Int,val languaje:String): Person(name,age), Vehicle {

    override fun work() {
        println("Esta persona esta programando")
    }

    fun sayLanguaje(){
        println("Este programador usa el lenguaje $languaje")
    }

    override fun goToWork() {
        println("Esta persona va a Google")
    }

    override fun drive() {
        println("Esta persona conduce un coche")
    }
}