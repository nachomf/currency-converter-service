package com.springcloud.currencyconverter.controller

import com.springcloud.currencyconverter.client.CurrencyExchangeClient
import com.springcloud.currencyconverter.exception.CurrencyExchangeServiceErrorException
import com.springcloud.currencyconverter.model.CurrencyConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@RestController
class CurrencyConverterController(
    private val currencyExchangeClient: CurrencyExchangeClient
) {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    fun getCurrencyConverter(
        @PathVariable from: String,
        @PathVariable to: String,
        @PathVariable quantity: BigDecimal
    ): CurrencyConverter = currencyExchangeClient
        .getCurrencyExchange(from, to)
        .run {
            CurrencyConverter(
                1001L,
                from,
                to,
                quantity,
                conversionMultiple,
                quantity.multiply(conversionMultiple),
                environment
            )
        }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    fun getCurrencyConverterFeign(
        @PathVariable from: String,
        @PathVariable to: String,
        @PathVariable quantity: BigDecimal
    ): CurrencyConverter = currencyExchangeClient
        .proxyGetCurrencyExchange(from, to)
        .run {
            CurrencyConverter(
                1001L,
                from,
                to,
                quantity,
                conversionMultiple,
                quantity.multiply(conversionMultiple),
                environment
            )
        }
}