package com.example.mypokemonapplication.core

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure<out T>(val message: String? = null) :
        Result<T>()
}