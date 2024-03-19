package com.droid.ui.graphs.piechart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droid.ui.graphs.piechart.model.PieChartEntry

/**
 * Composable to draw a Pie Chart Legends using given values.
 * @param pieChartEntries Holds pieSliceValues , pieSliceColor and pieArcName
 */
@Composable
fun PieChartLegend(pieChartEntries: List<PieChartEntry>) {
    Row(
        modifier = Modifier.padding(horizontal = 25.dp)
    ) {
        pieChartEntries.forEachIndexed { index, item ->
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .size(32.dp), painter = painterResource(id = item.pieLegendIcon), contentDescription = item.pieArcName
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.pieArcName, fontSize = 14.sp, color = colorResource(id = item.pieArcColor), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.pieArcValue.toString() + "%", fontSize = 12.sp, color = colorResource(id = item.pieArcColor), fontWeight = FontWeight.Bold)
            }
            if (index != pieChartEntries.lastIndex)
                Spacer(modifier = Modifier.width(16.dp))
        }
    }
}