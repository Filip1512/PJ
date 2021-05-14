package com.example.bmi_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries

class activity_graph : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        val graph = findViewById<GraphView>(R.id.graph)
        val series = LineGraphSeries(arrayOf<DataPoint>(
                DataPoint(22.0, 286301.0),
                DataPoint(23.0, 275958.0),
                DataPoint(24.0, 263751.0)))
        val seriesPoint = PointsGraphSeries(arrayOf<DataPoint>(
                DataPoint(22.0, 286301.0),
                DataPoint(23.0, 275958.0),
                DataPoint(24.0, 263751.0)))
        graph.addSeries(series)
        graph.addSeries(seriesPoint)
    }
}