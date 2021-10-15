package com.example.androidkotlintutorial
//inherit :: open, open allows override
open class TestClass constructor(type: String, poo: Int){
    val type = type
    var poo = poo
    var helper = Helper(type)


    fun work() {
        poo++
    }
    open fun report(){
        println("I did my part as a $type and i have done $poo units of work")
        helper.help()
    }
    fun fallBehind() {
        poo--
    }
    fun status(){
        println("This ${type}er is active")
        helper.help()
    }



}
//inherit :: constructor
class ExamClass(exam:String, type:String, poo:Int) : TestClass( type, poo){
    var exam= exam
    override fun report(){
        println("In Russia the $type tests YOU and $poo units of work is not enough")
        println("and as always ${helper.name} helped")
    }
}

class Helper (var type:String){
val name = type + "-bot"
    fun help(){
        println("i helped, as a $type-helper.")

    }
}