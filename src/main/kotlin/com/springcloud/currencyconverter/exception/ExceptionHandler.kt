package com.springcloud.currencyconverter.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

class CurrencyExchangeServiceErrorException(message: String) : RuntimeException(message)
class CurrencyExchangeEmptyBodyException : RuntimeException("currency exchange empty body")

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [CurrencyExchangeServiceErrorException::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handle(e: CurrencyExchangeServiceErrorException) = errorMessage(e, "currency_exchange_error")

    @ExceptionHandler(value = [CurrencyExchangeEmptyBodyException::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handle(e: CurrencyExchangeEmptyBodyException) = errorMessage(e, "currency_exchange_empty_body")

    fun errorMessage(exception: Throwable, code: String) = ErrorMessage(exception.message ?: "", code)

    data class ErrorMessage(val message: String, val code: String)
}