package com.droid.ui.graphs.piechart.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droid.ui.graphs.piechart.model.BarChartEntry

/**
 * Composable fun to show bar graph
 */
@Composable
fun BarGraph(barChartEntries: List<BarChartEntry>) {

    val entries = barChartEntries.sortedByDescending { it.barValueCount }

    //Get max values from the entries tha will be consider has 100% of the bar graph
    val maxValue = entries.maxOf { it.barValueCount }
    //Holder for the the bar char values
    val barChartFloatValues = mutableListOf<Float>()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        //Graph width is the half of screen size
        val graphContainerWidth = screenWidth / 2

        //Store the sp value of the text i.e count of the emotion. It is stored so that we can get size of graph line by subtracting the text size with container
        val emotionCountTextWidthSp = 24.sp
        val emotionCountTextWidthDp: Dp = with(LocalDensity.current) {
            emotionCountTextWidthSp.toDp()
        }

        //Her graph bar size is total container width - emotionTextCountSize - space between the bar line and textCount
        val maxBarSize = (graphContainerWidth - emotionCountTextWidthDp - 25.dp).value

        // Calculate the Pie arc using the formula 360 * pieValue / totalPieValue
        entries.forEachIndexed { index, entry ->
            //Calculate the percentage for the entry of the graph by dividing emotion count from max count and multiply it by 100
            val percentageValue = 100 * (entry.barValueCount / maxValue)
            //Calculate the value by multiplying maxBarSize * percentageValue / 100
            barChartFloatValues.add(index, (maxBarSize * (percentageValue / 100)))
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            barChartFloatValues.forEachIndexed { index, barValue ->

                var animationTriggered by remember {
                    mutableStateOf(false)
                }

                //Animation for the growing line
                //Used FastOutSlowInEasing it will start fast and end slowly
                val graphBarHeight by animateFloatAsState(
                    targetValue = if (animationTriggered) barValue else 0f,
                    animationSpec = tween(
                        durationMillis = 2000,
                        delayMillis = 0,
                        easing = FastOutSlowInEasing
                    ), label = "graphBarHeight"
                )

                LaunchedEffect(key1 = true) {
                    animationTriggered = true
                }

                // Each Graph
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    //Left side
                    Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                        Text(text = entries[index].barValueName, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = entries[index].barValueIcon),
                            contentDescription = entries[index].barValueName
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(modifier = Modifier.width(graphContainerWidth), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(graphBarHeight.dp)
                                .background(
                                    color = Color.Green,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                        Text(text = entries[index].barValueCount.toString(), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }

                if (index != barChartFloatValues.lastIndex)
                    Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}