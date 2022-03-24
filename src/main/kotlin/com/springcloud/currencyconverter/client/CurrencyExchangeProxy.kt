package com.springcloud.currencyconverter.client

import com.springcloud.currencyconverter.model.CurrencyConverter
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun getCurrencyExchange(@PathVariable from: String, @PathVariable to: String): CurrencyConverter
}