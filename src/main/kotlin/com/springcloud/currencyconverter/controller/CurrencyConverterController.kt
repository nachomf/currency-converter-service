package com.springcloud.currencyconverter.controller

import com.springcloud.currencyconverter.model.CurrencyConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyConverterController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    fun getCurrencyConverter(
        @PathVariable from: String,
        @PathVariable to: String,
        @PathVariable quantity: BigDecimal
    ): CurrencyConverter = CurrencyConverter(1001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "")
}