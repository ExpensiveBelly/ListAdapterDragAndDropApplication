package com.example.listadapterdraganddropapplication

fun <T> List<T>.move(from: Int, to: Int) = toMutableList().apply { add(to, removeAt(from)) }

