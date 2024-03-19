package com.droid.ui.graphs.piechart.model

/**
 * Data class that hold value of the pie chart
 * @param pieArcName name associated with pie value
 * @param pieArcColor color of the pie arc
 * @param pieArcValue calculated pie arc value
 * @param pieLegendIcon legend icon to be displaced in legends below pie chart.
 */
data class PieChartEntry(val pieArcName: String, val pieArcColor: Int, val pieArcValue: Float, val  pieLegendIcon : Int)