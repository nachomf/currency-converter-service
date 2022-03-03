package com.springcloud.currencyconverter.model

import java.math.BigDecimal

data class CurrencyConverter(
    val id: Long,
    val from: String,
    val to: String,
    val quantity: BigDecimal?,
    val conversionMultiple: BigDecimal,
    val totalCalculatedAmount: BigDecimal?,
    val environment: String,
)