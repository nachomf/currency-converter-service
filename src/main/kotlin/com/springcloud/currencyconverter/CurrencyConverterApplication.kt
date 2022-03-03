package com.springcloud.currencyconverter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CurrencyConverterApplication

fun main(args: Array<String>) {
	runApplication<CurrencyConverterApplication>(*args)
}
