package com.empower.interview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.empower.interview.model.Beneficiary
import com.empower.interview.utils.Utils.convertDesignationCode
import com.empower.interview.utils.Utils.formatDateOfBirth

class BeneficiaryAdapter(
    private var beneficiaries: MutableList<Beneficiary>
) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

    /**
     * Create new views (invoked by the layout manager).
     *
     * @param parent A ViewGroup is a special view that can contain other views (called children).
     * @param viewType An id reference to the view.
     * @return [ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = BeneficiaryItem(parent)
        return ViewHolder(item)
    }

    /**
     * Return the size of the dataset (invoked by the layout manager).
     *
     * @return Int The number of [Beneficiary] items.
     */
    override fun getItemCount(): Int = beneficiaries.size

    /**
     * Replace the contents of a view (invoked by the layout manager).
     *
     * @param holder Provide a reference to the type of views beings used.
     * @param position The item position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // set base information
        holder.item.firstName(beneficiaries[position].firstName.orEmpty())
        holder.item.lastName(beneficiaries[position].lastName.orEmpty())
        holder.item.beneType(beneficiaries[position].beneType.orEmpty())
        // translate designation code
        val code = convertDesignationCode(
            beneficiaries[position].designationCode.orEmpty()
        )
        holder.item.designation(code)

        // set additional information
        holder.item.socialSecurityNumber(beneficiaries[position].socialSecurityNumber.orEmpty())
        holder.item.phoneNumber(beneficiaries[position].phoneNumber.orEmpty())
        holder.item.address(beneficiaries[position].beneficiaryAddress?.firstLineMailing.orEmpty())
        // format date
        val formattedDate = formatDateOfBirth(beneficiaries[position].dateOfBirth?.toLong() ?: 0L)
        holder.item.dateOfBirth(formattedDate)

        // set OnClickListener. When clicked, the child view visibility will toggle
        holder.item.setOnClickListener {
            holder.item.toggleVisibility()
        }
    }

    /**
     * Provide a reference to the type of views beings used.
     *
     * @property item The adapter item.
     * @constructor
     */
    class ViewHolder(
        beneficiaryItem: BeneficiaryItem
    ) : RecyclerView.ViewHolder(beneficiaryItem) {
        val item: BeneficiaryItem = beneficiaryItem
    }
}
