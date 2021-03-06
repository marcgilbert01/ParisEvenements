package com.example.domain.common

interface UseCase<out Type, in Params> where Type : Any {
    suspend fun exeUseCase(params: Params): Type
}