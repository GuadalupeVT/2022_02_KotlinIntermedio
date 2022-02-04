package com.example.a02_kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

typealias MyMapList = MutableMap<Int,ArrayList<String>>
typealias MyFun = (Int,String,MyMapList) -> Boolean
typealias MyNestedClass = MyNestesAndInnerClass.MyNestedClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enum clases
        //enumClasses()

        //Nested and Inner Classes
        nestedAndInnerClasses()
    }

    //Lección 1 Kotlin Intermedio: EnumClasses --------------------------------------------
    enum class Direction(val dir:Int){
        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description():String{
            return when (this){
                NORTH -> "La dirección es NORTE"
                SOUTH -> "La dirección es SUR"
                EAST -> "La dirección es ESTE"
                WEST -> "La dirección es OESTE"
                else -> "No se sabe ña dirección"
            }
        }
    }

    private fun enumClasses() {
        //Aisgnación de valores
        var userDirection: Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH
        println("Direccion: $userDirection")

        //Propiedades por defecto
        println("Propiedad name: ${userDirection.name}")
        println("Propiedad ordinal: ${userDirection.ordinal}")

        //Funciones
        println(userDirection.description())

        //Inicialización
        println(userDirection.dir)
    }

    //Lección 2 Kotlin Intermedio: Clases anidadas ----------------------------------------
    private fun nestedAndInnerClasses(){
        //Clase anidada (nester)
        val myNestesClass = MyNestedClass()
        val sum = myNestesClass.sum(10,5)
        println("El resultado de la suma es $sum")

        //Clase interna (inner)
        val myInnerClass:MyNestesAndInnerClass.MyInnerClass = MyNestesAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(10)
        println("El resultado de la usma es $sumTwo")
    }

    //Lección 3 Kotlin Intermedio: Class Inheritance --------------------------------------
    private fun classInheritance(){
        val person = Person("sara",33)

        val programmer = Programmer("guadalupe",22,"Kotlin")
        programmer.work()
        programmer.sayLanguaje()
        programmer.goToWork()
        programmer.drive()

        val designer =Designer("erik",23)
        designer.work()
        designer.goToWork()
    }

    //Lección 4 Kotlin Intermedio: Interfaces ------------------------------------------------
    private fun interfaces(){
        val gamer=Person("Guadalupe",22)
        gamer.play()
        gamer.stream()
    }

    //Lección 5 Kotlin Intermedio: Modificadores de visibilidad ------------------------------
    private fun visibilityModifiers(){

        //val visibility = Visibility()
        //visibility.name="Guadalupe"
        //visibility.sayMyName()

        val visibilityTwo = VisibilityTwo()
        //visibilityTwo.sayMyNameTwo()
    }

    //Lección 6 Kotlin Intermedio: Data classes ----------------------------------------------
    private fun dataClasses(){
        val guadalupe =Worker("Guadalupe",22,"Student")
        guadalupe.lastWork="NA"

        val gvt =Worker("Guadalupe",22,"Student")
        gvt.lastWork="NA"

        val worker=Worker()

        //equals & hasCode
        if(guadalupe.equals(gvt)){
            println("Son iguales")
        }else{
            println("No son iguales")
        }

        //toString
        println(guadalupe.toString())

        //copy
        val gvt2 = gvt.copy(age=23)
        println(gvt.toString())
        println(gvt2.toString())

        //componentN
        val (name,age) = gvt
        println(name)
        println(age)

    }

    //Lección 7 Kotlin Intermedio: Type Aliases -----------------------------------------
    var myMap: MyMapList = mutableMapOf()

    private fun typeAliases(){
        var myNewMap: MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("Guadalupe","Vazquez")
        myNewMap[2] = arrayListOf("Sara","Marquez")

        myMap = myNewMap
    }

    //Lección 8 Kotlin Intermedio: Destructuring declarations -----------------------
    private fun destructuringDeclarations(){
        val (name,_,work) = Worker("Guadalupe",22,"Programadora")
        println("$name, $work")

        val guadalupe = Worker("Guadalupe",22, "Programadora")
        println(guadalupe.component1())

        val (gvtName,gvtAge) = myWorker()
        println("$gvtName,$gvtAge")

        val myMap = mapOf(1 to "Guadalupe", 2 to "Ana", 3 to "Sara")
        for (element in myMap){
            println("${element.component1()}, ${element.component2()}")
        }
        for((key, value) in myMap){
            println("$key,$value")
        }

    }

    private fun myWorker(): Worker{
        return Worker("Guadalupe",22,"Programadora")
    }

    //Lección 9 Kotlin Intermedio: Extensions --------------------------------------
    private fun extensions(){
        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        val myDateNullable:Date? =null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    //Lección 10 Kotlin Intermedio: Lambdas -----------------------------------------
    private fun lambdas(){
        val myIntList=arrayListOf<Int>(0,1,2,3,4,5,6,7,8,9,10)

        val myFilterIntList = myIntList.filter { myInt->
            println(myInt)
            if(myInt ==1){
                return@filter true
            }
            myInt > 5
        }

        println(myFilterIntList)

        val mySumFun = fun(x:Int,y:Int):Int = x+y
        val myMultFun =fun(x:Int,y:Int):Int = x*y


        myAsyncFun("Guadalupe"){
            println(it)
        }

        println(myOperateFun(5,10,mySumFun))
        println(myOperateFun(5,10,myMultFun))

        myOperateFun(5,10){ x,y -> x-y }
    }

    private fun myOperateFun(x:Int, y:Int, myFun:(Int,Int)->Int) :Int{
        return myFun(x,y)
    }

    private fun myAsyncFun(name:String, hello:(String) -> Unit){
        val myNewString = "Hola $name"
        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }
        thread {
            Thread.sleep(1000)
            hello(myNewString)
        }
        thread {
            Thread.sleep(7000)
            hello(myNewString)
        }
    }
}