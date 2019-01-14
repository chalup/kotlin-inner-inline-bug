package org.chalup.kotlinbug

import java.util.*

fun main(args: Array<String>) {
    val printer = object : Printer {
        override fun print(message: String) {
            println(message)
        }
    }

    val value = Random().nextInt()
    with(SomeClass(printer, LogLevel.DEBUG)) {
        builder(value).print()
        builder(value + 1).print()
    }
}
