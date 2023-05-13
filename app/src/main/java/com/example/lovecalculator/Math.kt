package com.example.lovecalculator

class Math {

    fun add(a: String, b: String): String {
        var result = ""
        if ((!isNumeric(a) || !isNumeric(b)) && (!a.contains(".") || b.contains("."))) {
            result = "Is not a number"
        } else {
            result = (a.toBigDecimal() + b.toBigDecimal()).toString()
        }
        return result
    }

    fun isNumeric(str: String) = str.all {it in '0'..'9'}
}