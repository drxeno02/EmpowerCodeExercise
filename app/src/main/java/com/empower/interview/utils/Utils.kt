package com.empower.interview.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.Locale

object Utils {
    private const val DATE_FORMAT = "MM/dd/yyyy"
    private const val CODE_P = "P"
    private const val PRIMARY = "Primary"
    private const val CODE_C = "C"
    private const val CONTINGENT = "Contingent"

    /**
     * Method is used to format date.
     *
     * @param dateOfBirth An example of anticipated date value would be `09022013`.
     * @return String The formatted date.
     */
    fun formatDateOfBirth(
        dateOfBirth: Long
    ): String {
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.US)
        return formatter.format(dateOfBirth)
    }

    /**
     * Open a data stream for reading a raw resource. This can only be used with resources
     * whose value is the name of an asset files -- that is, it can be used to open drawable,
     * sound, and raw resources; it will fail on string and color resources.
     *
     * @param context Interface to global information about an application environment.
     * @param id The id for the resource to load, typically held in the raw/ folder.
     */
    fun getRawResourceAsString(
        context: Context,
        id: Int
    ): String = context.resources.openRawResource(id)
        .bufferedReader().use { it.readText() }

    /**
     * Translate designation code to specific value associations; P = Primary, C = Contingent.
     *
     * @param designationCode The code to translate.
     * @return String The translated code.
     */
    fun convertDesignationCode(
        designationCode: String
    ): String {
        when (designationCode.lowercase(Locale.US)) {
            CODE_P.lowercase(Locale.US) -> {
                return PRIMARY
            }

            CODE_C.lowercase(Locale.US) -> {
                return CONTINGENT
            }
        }
        return designationCode
    }
}
