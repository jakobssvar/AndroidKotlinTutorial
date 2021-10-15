package com.example.androidkotlintutorial

class TestClass constructor(type: String, poo: Int){
    val type = type
    var poo = poo
    var helper = Helper(type)


    fun work() {
        poo++
    }
    fun report(){
        println("I did my part as a $type and i have done $poo units of work")
        helper.help()
    }



}

class Helper (var type:String){

    fun help(){
        println("i helped, as a $type-helper.")

    }
}