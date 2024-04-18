package com.empower.interview.activity

import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.empower.interview.R
import com.empower.interview.adapter.BeneficiaryAdapter
import com.empower.interview.adapter.parser.parse
import com.empower.interview.model.Beneficiary
import com.empower.interview.utils.Utils.getRawResourceAsString
import org.json.JSONArray

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set layout params
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        // create root
        val root = createRoot(params)
        // set content
        setContentView(root, params)

        // create title
        val titleView = createTitleView()
        root.addView(titleView)

        // create RecyclerView
        val recyclerView = createRecyclerView()

        // retrieve JSON from raw resources
        val jsonString = getRawResourceAsString(applicationContext, R.raw.beneficiaries)
        // parse JSON string
        val beneficiaries = parse(JSONArray(jsonString))
        // initialize adapter
        val adapter = BeneficiaryAdapter(beneficiaries)
        recyclerView.adapter = adapter
        // add divider
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        root.addView(recyclerView)
    }

    /**
     * Method is used to create the root view for setting contentView.
     *
     * @param params LayoutParams are used by views to tell their parents how
     * they want to be laid out.
     * @return [LinearLayout]
     */
    private fun createRoot(
        params: ViewGroup.LayoutParams
    ): LinearLayout {
        // return view
        return LinearLayout(this).apply {
            layoutParams = params
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(applicationContext.getColor(R.color.white))
        }
    }

    /**
     * Method is used to create title TextView.
     *
     * @return [TextView]
     */
    private fun createTitleView(): TextView {
        // set layout params
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        // return view
        return TextView(this).apply {
            layoutParams = params
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
            text = context.getString(R.string.empower_code_challenge)
            setPadding(20, 20, 20, 20)
            setBackgroundColor(context.getColor(R.color.purple_200))
        }
    }

    /**
     * Method is used to create to create recycle view to display a list of [Beneficiary].
     *
     * @return [RecyclerView]
     */
    private fun createRecyclerView(): RecyclerView {
        // set layout params
        val params = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
        // return view
        return RecyclerView(this).apply {
            layoutParams = params
            layoutManager = LinearLayoutManager(
                this@MainActivity, RecyclerView.VERTICAL, false
            )
        }
    }
}
