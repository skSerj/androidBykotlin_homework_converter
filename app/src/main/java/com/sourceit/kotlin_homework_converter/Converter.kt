package com.sourceit.kotlin_homework_converter

fun saveInputToConvertParameters(position: Int): String {
    return when (position) {
        0 -> "mm"
        1 -> "sm"
        2 -> "dm"
        3 -> "m"
        else -> "wrong"
    }
}

fun convertNum(selectedUnit: String, inputNum: Double, position: Int): Double {
    when {
        selectedUnit.contains("mm") -> {
            return when (position) {
                0 -> 1.0
                1 -> inputNum / 10
                2 -> inputNum / 100
                3 -> inputNum / 100
                else -> 0.0
            }
        }
        selectedUnit.contains("sm") -> {
            return when (position) {
                0 -> inputNum * 10
                1 -> 1.0
                2 -> inputNum / 10
                3 -> inputNum / 100
                else -> 0.0
            }
        }
        selectedUnit.contains("dm") -> {
            return when (position) {
                0 -> inputNum * 100
                1 -> inputNum * 10
                2 -> 1.0
                3 -> inputNum / 10
                else -> 0.0
            }
        }
        selectedUnit.contains("m") -> {
            return when (position) {
                0 -> inputNum * 1000
                1 -> inputNum * 100
                2 -> inputNum * 10
                3 -> 1.0
                else -> 0.0
            }
        }
    }
    return 0.0
}