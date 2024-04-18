package com.empower.interview.adapter.parser

import com.empower.interview.model.Beneficiary
import com.empower.interview.model.BeneficiaryAddress
import org.json.JSONArray

/**
 * DSL created to parse and reconstruct a list of [Beneficiary] objects.
 *
 * @param beneficiaries JSONArray of [Beneficiary] objects.
 * @return MutableList<Beneficiary>
 */
fun parse(
    beneficiaries: JSONArray
): MutableList<Beneficiary> {
    val beneficiariesList: MutableList<Beneficiary> = mutableListOf()

    try {
        for (i in 0 until beneficiaries.length()) {
            // retrieve JSONObject by index
            val beneficiaryObject = beneficiaries.getJSONObject(i)
            val addressObject = beneficiaryObject.getJSONObject("beneficiaryAddress")

            // retrieve values from JSONObject
            val lastName = beneficiaryObject.getString("lastName").orEmpty()
            val firstName = beneficiaryObject.getString("firstName").orEmpty()
            val designationCode = beneficiaryObject.getString("designationCode").orEmpty()
            val beneType = beneficiaryObject.getString("beneType").orEmpty()
            val socialSecurityNumber = beneficiaryObject.getString("socialSecurityNumber").orEmpty()
            val dateOfBirth = beneficiaryObject.getString("dateOfBirth").orEmpty()
            val middleName = beneficiaryObject.getString("middleName").orEmpty()
            val phoneNumber = beneficiaryObject.getString("phoneNumber").orEmpty()

            // retrieve values from Address JSONObject
            val firstLineMailing = addressObject.getString("firstLineMailing").orEmpty()
            val secondLineMailing = addressObject.getString("scndLineMailing").orEmpty()
            val city = addressObject.getString("city").orEmpty()
            val zipCode = addressObject.getString("zipCode").orEmpty()
            val stateCode = addressObject.getString("stateCode").orEmpty()
            val country = addressObject.getString("country").orEmpty()

            // set BeneficiaryAddress model properties
            val beneficiaryAddress = BeneficiaryAddress(
                firstLineMailing = firstLineMailing,
                secondLineMailing = secondLineMailing,
                city = city,
                zipCode = zipCode,
                stateCode = stateCode,
                country = country
            )
            // set Beneficiary model properties
            val beneficiary = Beneficiary(
                lastName = lastName,
                firstName = firstName,
                designationCode = designationCode,
                beneType = beneType,
                socialSecurityNumber = socialSecurityNumber,
                dateOfBirth = dateOfBirth,
                middleName = middleName,
                phoneNumber = phoneNumber,
                beneficiaryAddress = beneficiaryAddress
            )
            // add to list
            beneficiariesList.add(beneficiary)
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return beneficiariesList
}
