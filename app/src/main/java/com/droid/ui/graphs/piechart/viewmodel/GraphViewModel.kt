package com.droid.ui.graphs.piechart.viewmodel

import androidx.lifecycle.ViewModel
import com.droid.ui.graphs.R
import com.droid.ui.graphs.piechart.model.PieChartEntry

class GraphViewModel : ViewModel() {

    fun getPieChart(): ArrayList<PieChartEntry> {
        //Default holder for pieEntries
        val pieChartEntries = arrayListOf<PieChartEntry>()
        pieChartEntries.apply {
            add(
                PieChartEntry(
                    "Large Cap",
                    R.color.large_cap_color,
                    34.09f,
                    R.drawable.ic_large_cap
                )
            )
            add(
                PieChartEntry(
                    "Mid Cap",
                    R.color.mid_cap_color,
                    45.45f,
                    R.drawable.ic_mid_cap
                )
            )
            add(
                PieChartEntry(
                    "Small Cap",
                    R.color.small_cap_color,
                    20.46f,
                    R.drawable.ic_small_cap
                )
            )
        }
        return pieChartEntries
    }
}