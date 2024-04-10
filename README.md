# Graphs

## 1. Android Pie Chart using Jetpack Compose, Compose Animation and Kotlin
This repository demonstrates how to create a pie chart with animation along with legends in an Android app using Jetpack Compose and Kotlin. The application visualizes data using a pie chart along with legends, providing an intuitive representation of data distribution.

![Pie Chart](https://github.com/androidAppCreator/Graphs/assets/155815743/ce7da33f-9e31-4cec-ae7b-b218817dd915)


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
```
https://github.com/androidAppCreator/Graphs.git
```

2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.

### Usage
1. Modify Data: Customize the pie chart segments by providing your data in the code. Update the values and labels as needed.
2. Customize Appearance: Adjust colors, sizes, and other visual properties of the pie chart and legends to match your application's design.

### Example
1. Create entrie using PieChartEntry and pass that entries to PieChart()
```
PieChartEntry(val pieArcName: String, val pieArcColor: Int, val pieArcValue: Float, val  pieLegendIcon : Int)
```
2. Use PieChart composeable function to display Pie Chart, pass the PieChartEntry, along with animation duration and you can pass the PieChart Size.
```
 PieChart( // PieChart Entries, animDuration = 2000, pieChartSize = 180.dp)    
```

## 2. Android Bar Graph with Compose, Compose Animation and Kotlin
This repository showcases how to create a bar graph with animation using Jetpack Compose and Kotlin in an Android application. The application allows users to visualize data using animated bar graphs, providing a dynamic and engaging user experience.

![Bar Graph](https://github.com/androidAppCreator/Graphs/assets/155815743/4d2ced71-5f64-483d-a049-19300b4fbdc4)


### Features
* Bar graph visualization using Jetpack Compose.
* Smooth animation for bar graph transitions.
* Customizable bar colors and data points.

### Requirements
* Android Studio 4.0 or later.
* Kotlin version 1.4.x or later.
* Android SDK version 21 or later.

### Installation
1. Clone this repository to your local machine:
```
https://github.com/androidAppCreator/Graphs.git
```

2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.

### Usage
1. Modify Data: Customize the bar graph data by providing your dataset in the code. Update the values and labels as needed.
2. Customize Appearance: Adjust colors, sizes, and other visual properties of the bar graph to match your application's design.
3. Experiment with Animation: Explore Compose animation features to enhance the user experience. Adjust animation durations, interpolators, and triggers to achieve desired effects.

### Example
1. Create Bar entries using BarChartEntry()
```
BarChartEntry(val barValueName: String, val barValueCount: Float, val barValueIcon : Int)
```
2. Use BarGraph() composeable function to display the Bar Chart.
```
BarGraph(//Bar chart Entries)
````

### Acknowledgments
* Built with Jetpack Compose, the modern UI toolkit for Android, leveraging its animation capabilities for smooth transitions.
