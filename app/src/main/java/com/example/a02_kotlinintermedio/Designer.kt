package com.example.a02_kotlinintermedio

class Designer(name:String,age:Int): Person(name,age) {

    override fun work() {
        println("Esta persona esta diseñando")
        super.work()
    }
}