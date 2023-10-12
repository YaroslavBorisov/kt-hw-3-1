package ru.netology

import kotlin.random.Random

fun agoToText(seconds : Int) : String {
    return "был(а) " + when{
        seconds < 60        -> "только что"
        seconds < 3600      -> minutesAgo(seconds/60)
        seconds < 86400     -> hoursAgo(seconds/3600)
        seconds < 2*86400   -> "вчера"
        seconds < 3*86400   -> "позавчера"
        else                -> "давно"

    }
}

fun minutesAgo(minutes: Int): String {
    val minutesModulo10 = minutes % 10
    return "$minutes минут" +
            when {
                (minutes / 10) == 1     -> ""
                minutesModulo10 == 1    -> "у"
                minutesModulo10 <= 4    -> "ы"
                else                    -> ""
            } +
            " назад"
}

fun hoursAgo(hours: Int): String {
    val hoursModulo10 = hours % 10
    return "$hours час" +
            when {
                (hours/10) == 1     -> "ов"
                hoursModulo10 == 1  -> ""
                hoursModulo10 <= 4  -> "а"
                else                -> "ов"
            } +
    " назад"
}


fun main(){
    for(i in 1..50){
        println(agoToText(Random.nextInt(1,4*86400)))
    }
}