package com.example.a02_kotlinintermedio

interface Game {

    val game:String

    fun play()

    fun stream(){
        println("estoy haciendo stream de mi juego $game")
    }
}