package com.empower.interview.adapter

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.empower.interview.R

@SuppressLint("ViewConstructor")
class BeneficiaryItem(parent: ViewGroup) : LinearLayout(parent.context) {
    // base information
    private val tvFirstName: TextView
    private val tvLastName: TextView
    private val tvBeneType: TextView
    private val tvDesignation: TextView

    // additional information
    private val tvSocialSecurityNumber: TextView
    private val tvDateOfBirth: TextView
    private val tvPhoneNumber: TextView
    private val tvAddress: TextView

    // toggleable child view
    private val child: LinearLayout

    init {
        val context = parent.context
        // set layout params
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        // specify vertical orientation
        orientation = VERTICAL
        // set background color
        setBackgroundColor(context.getColor(R.color.white))
        // set padding
        setPadding(40, 40, 40, 40)

        // instantiate base information views
        tvFirstName = createTextView()
        tvLastName = createTextView()
        tvBeneType = createTextView()
        tvDesignation = createTextView()
        addView(tvFirstName)
        addView(tvLastName)
        addView(tvBeneType)
        addView(tvDesignation)

        // set layout params
        val params = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        params.setMargins(40, 20, 40, 10)
        // create child root view
        child = LinearLayout(context).apply {
            layoutParams = params
            orientation = VERTICAL
            setBackgroundColor(context.getColor(R.color.purple_200))
            setPadding(20, 20, 20, 20)
        }
        // instantiate additional information views
        tvSocialSecurityNumber = createTextView()
        tvDateOfBirth = createTextView()
        tvPhoneNumber = createTextView()
        tvAddress = createTextView()
        child.addView(tvSocialSecurityNumber)
        child.addView(tvDateOfBirth)
        child.addView(tvPhoneNumber)
        child.addView(tvAddress)
        // default visibility
        child.visibility = View.GONE
        addView(child)
    }

    /**
     * Method is used to create TextView.
     *
     * @return [TextView]
     */
    private fun createTextView(): TextView {
        // set TextView layout params
        val tvLayoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        // return view
        return TextView(context).apply {
            id = generateViewId()
            layoutParams = tvLayoutParams
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }

    /**
     * Bind the data to the view.
     *
     * @param text The first name.
     */
    fun firstName(text: String) {
        tvFirstName.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The last name.
     */
    fun lastName(text: String) {
        tvLastName.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The beneficiary type.
     */
    fun beneType(text: String) {
        tvBeneType.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The designation.
     */
    fun designation(text: String) {
        tvDesignation.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The social security number.
     */
    fun socialSecurityNumber(text: String) {
        tvSocialSecurityNumber.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The date of birth.
     */
    fun dateOfBirth(text: String) {
        tvDateOfBirth.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The phone number.
     */
    fun phoneNumber(text: String) {
        tvPhoneNumber.text = text
    }

    /**
     * Bind the data to the view.
     *
     * @param text The address (line 1).
     */
    fun address(text: String) {
        tvAddress.text = text
    }

    /**
     * Method is used to toggle visibility of the child root view.
     */
    fun toggleVisibility() {
        child.visibility = if (child.isVisible) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}
