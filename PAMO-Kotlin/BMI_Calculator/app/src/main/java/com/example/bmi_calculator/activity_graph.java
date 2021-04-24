package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class activity_graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(22, 286301),
                new DataPoint(23, 275958),
                new DataPoint(24, 263751),
        });
        PointsGraphSeries<DataPoint> seriesPoint = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(22, 286301),
                new DataPoint(23, 275958),
                new DataPoint(24, 263751),
        });
        graph.addSeries(series);
        graph.addSeries(seriesPoint);
    }
}