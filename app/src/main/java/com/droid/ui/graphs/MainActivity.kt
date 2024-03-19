package com.droid.ui.graphs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.droid.ui.graphs.piechart.model.PieChartEntry
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
                        PieChartView(getPieChart())
                    }
                }
            }
        }
    }
}

@Composable
fun PieChartView(pieChartEntries: ArrayList<PieChartEntry>) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Market Cap", fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 25.dp))
        Spacer(modifier = Modifier.height(25.dp))
        PieChart(pieChartEntries = pieChartEntries, animDuration = 2000, pieChartSize = 180.dp)
        Spacer(modifier = Modifier.height(25.dp))
        PieChartLegend(pieChartEntries = pieChartEntries)
        Spacer(modifier = Modifier.height(25.dp))
    }
}