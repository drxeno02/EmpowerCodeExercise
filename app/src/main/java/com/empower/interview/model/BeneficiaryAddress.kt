package com.empower.interview.model

data class BeneficiaryAddress(
    val firstLineMailing: String? = null,
    val secondLineMailing: String? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val stateCode: String? = null,
    val country: String? = null
)
