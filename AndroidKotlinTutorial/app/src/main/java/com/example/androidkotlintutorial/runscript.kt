package com.example.androidkotlintutorial

import androidx.annotation.RequiresApi
@RequiresApi(24)
// run with right-click menu   or   ctrl+shift+F10

fun main(args: Array<String>) {

    val name = "JohnnyB" //val == const
    var isAwesome = true


    var doubleNum = 124.23  //64bit
    var floatNum = 123.65f  //32bit
    var longNum = 62173613183281L  //64bit

    var toString = doubleNum.toString()
    var fixedType: String
    var comparableString = "aballaballaball"

    println("Is " + name + " awesome?\n the \"answer\" is \t" + isAwesome)
    println("Is " + name + " awesome?\n the answer is \t" + isAwesome)
    println("May the force\b be with you")
    println("Is " + name + " awesome?/n the answer is /t" + isAwesome + "/r\r")  //this doesn't work
    fixedType = "aballaballaball"
    println("\n")
    val rawCrawl = """ |A long long time ago,
        |in a kingdom 
        |not so far 
        |away...""".trimMargin()   //the pipe shows where to trim
    println(rawCrawl)
    println(fixedType.contentEquals(comparableString))
    println(fixedType == comparableString)
    println(fixedType === comparableString)
    println(fixedType.contains("ball", ignoreCase = false))
    fixedType.uppercase()
    fixedType.lowercase()
    println("\n")
    println(doubleNum.toString() + doubleNum)  //treated as string not number
    println(doubleNum.toString() + doubleNum + 4)  //treated as string not number
    println(doubleNum.toString() + (doubleNum + 4))  //the last doubleNum and 4 are added together

    println("\n")

    var subString: String = ""
    var shortNum = 0
    println(fixedType.substring(1, 5))
    for (char in fixedType) {
        if (shortNum % 3 == 0) {
            subString += char
        }
        shortNum++;
    }
    println(subString)

    println("\n")

    val luke = "Luke Skywalker"
    val lightsaberColor = "Blue"
    val race = "wookie"
    println(luke+" has a "+lightsaberColor+" lightsaber and he is a "+race+".")
    println("$luke has a $lightsaberColor lightsaber and he is not a $race.")
    println("lukes fullname has ${luke.length} characters including spaces")

    println("\n")

    println(myFunc())

    println("\n")

    if(shortNum >= 5){println("it is")}
    else if(doubleNum >= 5){println("it isn't but doubleNum is")}
    else {println("seems like nobody is")}
    //also: == != >= <= < > && ||
    println("\n")
    val x  = 1
    when(x) {
        1 -> println("It's one yo!")
        2 -> println("YO! It's 2 now")
        5 -> println("YOOOO! This number don't give a single f*")

        else -> println("unkown computer glitch, check for divided by 0 and scan for disk corruption")
    }

    //immutable list
    val imperials = listOf("Admiral Piet","Darth Vader","Emperor Palpatine","Moff Tarkin","Admiral Thrawn","Colonel Starch")
    println(imperials.sorted())
    println(imperials[2])
    println(imperials.sorted()[2])
    println(imperials.sorted().last())
    println(imperials.sorted().first())
    println(imperials.contains("Luke"))

    //mutable list
    val rebels = arrayListOf<String>("Han Solo","Leia","luke","Rey","Chewbacca","Bill Nye")
    println(rebels.size)
    rebels.add("Lando")                                 //add at start
    println(rebels.size)
    println(rebels)
    println(rebels.indexOf("luke"))                     //get index
    rebels.add(rebels.indexOf("luke"),"C-3PO")  //add at and push back luke
    println(rebels)
    rebels.add(rebels.size,"Greedo")            // append
    println(rebels)
    rebels.remove("Greedo")
    println(rebels)
    rebels.removeLast()
                                                        //NB adds at the end
    rebels.addAll(listOf("Gary Lewis","Tom Kotlin","J.R. Tolkien","Albus Percival Wulfric Brian Dumbledore"))
    println(rebels)

    // immutable map
    val rebelCarMap = mapOf(
        //key           value
        "Han Solo" to "Millennium Falcon",
        "Luke Skywalker" to "Landspeeder",
        "Leia Organa" to "Star Destroyer",
        "Lando Calrissian" to "Millennium Falcon",          //key must be different but value can be the same
        )
    println(rebelCarMap["Han Solo"])
    println(rebelCarMap.get("Han Solo"))

    println(rebelCarMap.getOrDefault("Leia", "This person doesn't have a ship"))
    println(rebelCarMap["Lando Calrissian"])
 println("\n")
    val varShipMap = hashMapOf<String, String>("han" to "leia","luke" to "leia", "leia" to "han", "jabba" to "leia")
    varShipMap["luke"] = "lukes right hand"
    varShipMap.remove("jabba")
    varShipMap.put("jabba", "leia")
    for(lameDuck in rebels){
        println(lameDuck)

    }
    println("\n")
    for((key,value) in varShipMap){
        if(varShipMap.containsKey(value)){
            varShipMap[value]=key
        }
        println("${key} and ${varShipMap[key]} are sitting in a tree K I S S I N G!")
    }

    println("\n")

}


//nullable types
fun myFunc(str:String? = null):String?{
    var retVal = str
    if (retVal == null) {
        retVal="empty"
    }
    return retVal
}