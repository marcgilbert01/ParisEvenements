package com.nowtv.domain.common

interface UseCaseVoid<out Type> where Type : Any {
    suspend fun exeUseCase(): Type
}