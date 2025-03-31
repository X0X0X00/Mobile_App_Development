package com.zzh133.movies


fun main () {

//    Welcome [20 points]
//    Next to MainActivity.kt add a new Kotlin file called Movies.kt.
//    Add a main function that prints: "Welcome to the Movies!"

    println("Welcome to the Movies!")


//    Faves [20 points]
//    Hard-code a map called faves with 7 key and value pairs for
//    movie title and lead (e.g., "Serpico" : "Al Pacino"). Print faves at
//    the end of main by passing it as parameter to println.

    val faves = mapOf(
        "There Will Be Blood" to "Daniel Day-Lewis",
        "Chinatown" to "Jack Nicholson",
        "Apocalypse Now" to "Marlon Brando",
        "Raging Bull" to "Robert De Niro",
        "Serpico" to "Al Pacino",
        "Tootsie" to "Dustin Hoffman",
        "The Silence of the Lambs" to "Anthony Hopkins"
    )

    println(faves)


//    Sets [20 points]
//    A map can be deconstructed into keys and values sets (e.g., faves.keys). Create a function
//    printSets that takes a map and prints out its keys and values using two for loops. Call printSets at the end of main.

    printSets(faves)


//Sort [30 points]
//Create a function printSorted. It takes a map and a Boolean as parameters. The Boolean is to
//indicate the sort direction. Deconstruct your map into sets and use toTypedArray() on them to create
//arrays for your keys and values. Arrays have sort() and reverse() methods that you can use. Call
//printSorted at the end of main and print your movie titles and lead actors sorted in reverse.

    printSorted(faves, true)


//Git [10 points]
//Your project's git repo has a commit depth of minimally 3.
}


fun printSets(map: Map<String, String>) {
    println("__print keys:")
    for (key in map.keys) {
        print("$key," + " ")
    }
    println()
    println("__print values:")
    for (value in map.values) {
        print("$value," + " ")
    }
}

fun printSorted(map: Map<String, String>, reverse: Boolean) {
    val keys = map.keys.toTypedArray()
    val values = map.values.toTypedArray()

    if (reverse) {
        keys.sortDescending()
        values.sortDescending()
    } else {
        keys.sort()
        values.sort()
    }

    println()
    println("__print sorted:")

    for (i in keys.indices) {
        print("${keys[i]}," + " ")
    }

    println()

    for (i in keys.indices) {
        print("${values[i]}," + " ")
    }
}
