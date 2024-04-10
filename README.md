# Graphs

## Android Pie Chart using Jetpack Compose and Kotlin
This repository demonstrates how to create a pie chart with legends in an Android app using Jetpack Compose and Kotlin. The application visualizes data using a pie chart along with legends, providing an intuitive representation of data distribution.

### Features
* Pie chart visualization using Jetpack Compose.
* Legends for each segment of the pie chart.
* Customizable colors for each segment.

### Requirements
* Android Studio 4.0 or later.
* Kotlin version 1.4.x or later.
* Android SDK version 21 or later.

### Installation
1. Clone this repository to your local machine:
> https://github.com/androidAppCreator/Graphs.git
2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.

### Example
1. Create entrie using PieChartEntry and pass that entries to PieChart()
```
PieChartEntry(val pieArcName: String, val pieArcColor: Int, val pieArcValue: Float, val  pieLegendIcon : Int)
```
2. Use PieChart composeable function to display Pie Chart, pass the PieChartEntry, along with animation duration and you can pass the PieChart Size.
```
@Composable
fun PieChartView(pieChartEntries: ArrayList<PieChartEntry>) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        PieChart(pieChartEntries = pieChartEntries, animDuration = 2000, pieChartSize = 180.dp)
    }
}
```
