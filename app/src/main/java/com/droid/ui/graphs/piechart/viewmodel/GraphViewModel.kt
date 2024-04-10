package com.droid.ui.graphs.piechart.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.droid.ui.graphs.R
import com.droid.ui.graphs.piechart.model.BarChartEntry
import com.droid.ui.graphs.piechart.model.GraphsUIState
import com.droid.ui.graphs.piechart.model.PieChartEntry

class GraphViewModel : ViewModel() {

    @SuppressLint("MutableCollectionMutableState")
    private val _graphUIState = mutableStateOf(GraphsUIState())
    val graphUIState: State<GraphsUIState> = _graphUIState

    fun handleScreenNavigation(isHomeScreen: Boolean = false, showPieChart: Boolean = false, showBarGraph: Boolean = false) {
        _graphUIState.value = _graphUIState.value.copy(isHomeScreen = isHomeScreen, showPieChart = showPieChart, showBarGraph = showBarGraph)
    }

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

    fun getBarChartEntries(): ArrayList<BarChartEntry> {
        //Default holder for pieEntries
        val barChartEntry = arrayListOf<BarChartEntry>()

        return barChartEntry.apply {
            add(
                BarChartEntry(
                    "Large Cap",
                    34.09f,
                    R.drawable.ic_large_cap
                )
            )
            add(
                BarChartEntry(
                    "Mid Cap",
                    45.45f,
                    R.drawable.ic_mid_cap
                )
            )
            add(
                BarChartEntry(
                    "Small Cap",
                    20.46f,
                    R.drawable.ic_small_cap
                )
            )
        }
    }
}