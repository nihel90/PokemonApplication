package com.example.mypokemonapplication.core.datasource

interface DataSource<PARAM, RESPONSE> {
    suspend fun execute(param: PARAM): RESPONSE
}