package com.droid.ui.graphs.piechart.model

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.graphics.Color

/**
 * Data class that hold value to animate the pie chart
 * @param animation to animate to the angle
 * @param targetSweepAngle target sweep angle till the pie arc will be drawn
 * @param color color of the pie arc
 */
data class ArcAnimatedData(var animation: Animatable<Float, AnimationVector1D>, val targetSweepAngle: Float, val color: Color)