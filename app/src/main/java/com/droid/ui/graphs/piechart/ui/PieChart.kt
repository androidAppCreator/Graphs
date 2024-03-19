package com.droid.ui.graphs.piechart.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droid.ui.graphs.piechart.model.ArcAnimatedData
import com.droid.ui.graphs.piechart.model.PieChartEntry
import kotlinx.coroutines.launch

/**
 * Composable to draw a Pie Chart using given values.
 * @param pieChartEntries Holds pieSliceValues , pieSliceColor and pieArcName
 * @param pieChartSize total pie chart size.
 * @param animDuration duration of the animation
 */
@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    pieChartEntries: List<PieChartEntry>,
    pieChartSize: Dp,
    animDuration: Int = 4000,
) {
    val count = pieChartEntries.count { it.pieArcValue > 0 }

    //Total sum of pieData divided by the 360
    val total = pieChartEntries.fold(0f) { acc, pieData ->
        acc + pieData.pieArcValue
    }.div(360)

    var sumOfAngle = 0f

    //Create the animated arcData.
    val arc = pieChartEntries.map {
        sumOfAngle += it.pieArcValue
        ArcAnimatedData(
            animation = Animatable(0f),
            targetSweepAngle = sumOfAngle / total, //sweep angle is the sum divided by the total angle
            color = colorResource(id = it.pieArcColor)
        )
    }

    LaunchedEffect(key1 = arc) {
        arc.map {
            launch {
                it.animation.animateTo(
                    targetValue = it.targetSweepAngle,
                    animationSpec = tween(
                        durationMillis = animDuration,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        }
    }


    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(
            modifier = modifier
                .padding(25.dp)
                .size(pieChartSize)
        ) {
            val radius = size.width / 2f
            val lineStrokeWidth = 1.dp.toPx()

            //this will draw arcs
            arc.reversed().map {
                drawArc(
                    startAngle = -90f,
                    sweepAngle = it.animation.value,
                    color = it.color,
                    useCenter = true,
                )
            }

            if (count > 1) {
                //this will draw lines on top of the arcs
                arc.reversed().map {
                    rotate(it.animation.value) {
                        drawLine(
                            color = Color.White,
                            start = Offset(radius, radius),
                            end = Offset(radius, 0f),
                            strokeWidth = lineStrokeWidth
                        )
                    }
                }
            }
        }
    }
}


