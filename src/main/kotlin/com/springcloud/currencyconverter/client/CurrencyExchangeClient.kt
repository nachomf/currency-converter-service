package com.springcloud.currencyconverter.client

import com.springcloud.currencyconverter.exception.CurrencyExchangeEmptyBodyException
import com.springcloud.currencyconverter.exception.CurrencyExchangeServiceErrorException
import com.springcloud.currencyconverter.model.CurrencyConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class CurrencyExchangeClient(
    private val proxy: CurrencyExchangeProxy
) {
    fun getCurrencyExchange(from: String, to: String): CurrencyConverter {
        try {
            return RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConverter::class.java,
                mapOf("from" to from, "to" to to)
            ).body ?: throw CurrencyExchangeEmptyBodyException()
        } catch (e: Exception) {
            throw  CurrencyExchangeServiceErrorException(e.message ?: "")
        }
    }

    fun proxyGetCurrencyExchange(from: String, to: String) = kotlin
        .runCatching { proxy.getCurrencyExchange(from, to) }
        .onFailure { e -> throw  CurrencyExchangeServiceErrorException(e.message ?: "") }
        .getOrNull()!!
}