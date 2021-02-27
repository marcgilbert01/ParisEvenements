package com.example.domain.common

interface UseCaseVoid<out Type> where Type : Any {
    suspend fun exeUseCase(): Type
}