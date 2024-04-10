package com.droid.ui.graphs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.droid.ui.graphs.piechart.model.PieChartEntry
import com.droid.ui.graphs.piechart.ui.BarGraph
import com.droid.ui.graphs.piechart.ui.PieChart
import com.droid.ui.graphs.piechart.ui.PieChartLegend
import com.droid.ui.graphs.piechart.viewmodel.GraphViewModel
import com.droid.ui.graphs.ui.theme.GraphsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    ViewModelProvider(this@MainActivity)[GraphViewModel::class.java].apply {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            BackButton(this@apply, !graphUIState.value.isHomeScreen)
                            AnimatedVisibility(graphUIState.value.isHomeScreen, enter = fadeIn(), exit = fadeOut()) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(colors = ButtonDefaults.buttonColors(Color.Cyan), onClick = { handleScreenNavigation(showPieChart = true) }) {
                                        Text(text = "Pie Chart", color = Color.Black)
                                    }
                                    Button(colors = ButtonDefaults.buttonColors(Color.Cyan), onClick = { handleScreenNavigation(showBarGraph = true) }) {
                                        Text(text = "Bar Graph", color = Color.Black)
                                    }
                                }
                            }

                            if (graphUIState.value.showPieChart) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Column {
                                        PieChartView(getPieChart())
                                    }
                                }
                            }

                            if (graphUIState.value.showBarGraph) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Column {
                                        BarGraph(getBarChartEntries())
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BackButton(viewModel: GraphViewModel, showBackButton: Boolean = false) {
    val alpha: Float by animateFloatAsState(if (showBackButton) 1f else 0f, label = "Back animation")
    Row(modifier = Modifier.padding(25.dp)) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Back Icon",
            tint = Color.Black,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .alpha(alpha)
                .clickable {
                    viewModel.handleScreenNavigation(isHomeScreen = true)
                }

        )
        Text(
            text = "Market Cap",
            fontSize = 18.sp,
            color = Color.Black, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PieChartView(pieChartEntries: ArrayList<PieChartEntry>) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        PieChart(pieChartEntries = pieChartEntries, animDuration = 2000, pieChartSize = 180.dp)
        Spacer(modifier = Modifier.height(25.dp))
        PieChartLegend(pieChartEntries = pieChartEntries)
        Spacer(modifier = Modifier.height(25.dp))
    }
}