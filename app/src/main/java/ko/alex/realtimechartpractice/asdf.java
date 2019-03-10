package ko.alex.realtimechartpractice;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class asdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asdf);

        TextView asdfTextView = findViewById(R.id.asdfTextView);
        asdfTextView.setText("package ko.alex.realtimechartpractice;\n" +
                "\n" +
                "import android.Manifest;\n" +
                "import android.content.Intent;\n" +
                "import android.content.pm.PackageManager;\n" +
                "import android.graphics.Color;\n" +
                "import android.net.Uri;\n" +
                "import android.os.Bundle;\n" +
                "import androidx.core.content.ContextCompat;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "import android.util.Log;\n" +
                "import android.view.Menu;\n" +
                "import android.view.MenuItem;\n" +
                "import android.view.View;\n" +
                "import android.view.WindowManager;\n" +
                "import android.widget.SeekBar;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "import com.github.mikephil.charting.charts.LineChart;\n" +
                "import com.github.mikephil.charting.components.Legend;\n" +
                "import com.github.mikephil.charting.components.Legend.LegendForm;\n" +
                "import com.github.mikephil.charting.components.XAxis;\n" +
                "import com.github.mikephil.charting.components.YAxis;\n" +
                "import com.github.mikephil.charting.components.YAxis.AxisDependency;\n" +
                "import com.github.mikephil.charting.data.Entry;\n" +
                "import com.github.mikephil.charting.data.LineData;\n" +
                "import com.github.mikephil.charting.data.LineDataSet;\n" +
                "import com.github.mikephil.charting.highlight.Highlight;\n" +
                "import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;\n" +
                "import com.github.mikephil.charting.listener.OnChartValueSelectedListener;\n" +
                "import com.github.mikephil.charting.utils.ColorTemplate;\n" +
                "import com.google.android.material.floatingactionbutton.FloatingActionButton;\n" +
                "//import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity implements //extends DemoBase\n" +
                "        OnChartValueSelectedListener {\n" +
                "\n" +
                "    private LineChart chart;\n" +
                "    int seekBarProgressValue = 0;\n" +
                "    float seekBarProgressValue2 = 0;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,\n" +
                "                WindowManager.LayoutParams.FLAG_FULLSCREEN);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "\n" +
                "        setTitle(\"RealtimeLineChartActivity\");\n" +
                "\n" +
                "        chart = findViewById(R.id.chart1);\n" +
                "        chart.setOnChartValueSelectedListener(this);\n" +
                "\n" +
                "        // enable description text\n" +
                "        chart.getDescription().setEnabled(true);\n" +
                "\n" +
                "        // enable touch gestures\n" +
                "        chart.setTouchEnabled(true);\n" +
                "\n" +
                "        // enable scaling and dragging\n" +
                "        chart.setDragEnabled(true);\n" +
                "        chart.setScaleEnabled(true);\n" +
                "        chart.setDrawGridBackground(false);\n" +
                "\n" +
                "        // if disabled, scaling can be done on x- and y-axis separately\n" +
                "        chart.setPinchZoom(true);\n" +
                "\n" +
                "        // set an alternative background color\n" +
                "        chart.setBackgroundColor(Color.LTGRAY);\n" +
                "\n" +
                "        LineData data = new LineData();\n" +
                "        data.setValueTextColor(Color.WHITE);\n" +
                "\n" +
                "        // add empty data\n" +
                "        chart.setData(data);\n" +
                "\n" +
                "        // get the legend (only possible after setting data)\n" +
                "        Legend l = chart.getLegend();\n" +
                "\n" +
                "        // modify the legend ...\n" +
                "        l.setForm(LegendForm.LINE);\n" +
                "        //l.setTypeface(tfLight);\n" +
                "        l.setTextColor(Color.WHITE);\n" +
                "\n" +
                "        XAxis xl = chart.getXAxis();\n" +
                "        //xl.setTypeface(tfLight);\n" +
                "        xl.setTextColor(Color.WHITE);\n" +
                "        xl.setDrawGridLines(false);\n" +
                "        xl.setAvoidFirstLastClipping(true);\n" +
                "        xl.setEnabled(true);\n" +
                "\n" +
                "        YAxis leftAxis = chart.getAxisLeft();\n" +
                "        //leftAxis.setTypeface(tfLight);\n" +
                "        leftAxis.setTextColor(Color.WHITE);\n" +
                "        leftAxis.setAxisMaximum(100f);\n" +
                "        leftAxis.setAxisMinimum(0f);\n" +
                "        leftAxis.setDrawGridLines(true);\n" +
                "\n" +
                "        YAxis rightAxis = chart.getAxisRight();\n" +
                "        rightAxis.setEnabled(false);\n" +
                "\n" +
                "        FloatingActionButton pinkFab = findViewById(R.id.pinkFab);\n" +
                "        pinkFab.setOnClickListener(new View.OnClickListener(){\n" +
                "            @Override\n" +
                "            public void onClick(View view){\n" +
                "                //Toast.makeText(getApplicationContext(), \"Entry added!\", Toast.LENGTH_SHORT).show();\n" +
                "                addEntry();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        SeekBar seekBar = findViewById(R.id.seekBar);\n" +
                "        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {\n" +
                "            //int seekBarProgressValue = 0;\n" +
                "            @Override\n" +
                "            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {\n" +
                "                seekBarProgressValue = progress;\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStartTrackingTouch(SeekBar seekBar) {\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStopTrackingTouch(SeekBar seekBar) {\n" +
                "                //Toast.makeText(getApplicationContext(), \"Seekbar progress: \"+seekBarProgressValue, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        SeekBar seekBar2 = findViewById(R.id.seekBar2);\n" +
                "        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {\n" +
                "            //int seekBarProgressValue2 = 0;\n" +
                "            @Override\n" +
                "            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {\n" +
                "                seekBarProgressValue2 = progress;\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStartTrackingTouch(SeekBar seekBar2) {\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStopTrackingTouch(SeekBar seekBar2) {\n" +
                "                //Toast.makeText(getApplicationContext(), \"Seekbar progress: \"+seekBarProgressValue2, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    private void addEntry() {\n" +
                "\n" +
                "        LineData data = chart.getData();\n" +
                "\n" +
                "        if (data != null) {\n" +
                "\n" +
                "            ILineDataSet set = data.getDataSetByIndex(0);\n" +
                "            // set.addEntry(...); // can be called as well\n" +
                "\n" +
                "            if (set == null) {\n" +
                "                set = createSet();\n" +
                "                data.addDataSet(set);\n" +
                "            }\n" +
                "\n" +
                "            data.addEntry(new Entry(set.getEntryCount(), (float) (Math.random() * seekBarProgressValue) + seekBarProgressValue2), 0); //+30f instead of seekBarProgressValue2\n" +
                "            data.notifyDataChanged();\n" +
                "\n" +
                "            // let the chart know it's data has changed\n" +
                "            chart.notifyDataSetChanged();\n" +
                "\n" +
                "            // limit the number of visible entries\n" +
                "            chart.setVisibleXRangeMaximum(120);\n" +
                "            // chart.setVisibleYRange(30, AxisDependency.LEFT);\n" +
                "\n" +
                "            // move to the latest entry\n" +
                "            chart.moveViewToX(data.getEntryCount());\n" +
                "\n" +
                "            // this automatically refreshes the chart (calls invalidate())\n" +
                "            // chart.moveViewTo(data.getXValCount()-7, 55f,\n" +
                "            // AxisDependency.LEFT);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    private LineDataSet createSet() {\n" +
                "\n" +
                "        LineDataSet set = new LineDataSet(null, \"Dynamic Data\");\n" +
                "        set.setAxisDependency(AxisDependency.LEFT);\n" +
                "        set.setColor(ColorTemplate.getHoloBlue());\n" +
                "        set.setCircleColor(Color.WHITE);\n" +
                "        set.setLineWidth(2f);\n" +
                "        set.setCircleRadius(4f);\n" +
                "        set.setFillAlpha(65);\n" +
                "        set.setFillColor(ColorTemplate.getHoloBlue());\n" +
                "        set.setHighLightColor(Color.rgb(244, 117, 117));\n" +
                "        set.setValueTextColor(Color.WHITE);\n" +
                "        set.setValueTextSize(9f);\n" +
                "        set.setDrawValues(false);\n" +
                "        return set;\n" +
                "    }\n" +
                "\n" +
                "    private Thread thread;\n" +
                "\n" +
                "    private void feedMultiple() {\n" +
                "\n" +
                "        if (thread != null)\n" +
                "            thread.interrupt();\n" +
                "\n" +
                "        final Runnable runnable = new Runnable() {\n" +
                "\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                addEntry();\n" +
                "            }\n" +
                "        };\n" +
                "\n" +
                "        thread = new Thread(new Runnable() {\n" +
                "\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                for (int i = 0; i < 1000; i++) {\n" +
                "\n" +
                "                    // Don't generate garbage runnables inside the loop.\n" +
                "                    runOnUiThread(runnable);\n" +
                "\n" +
                "                    try {\n" +
                "                        Thread.sleep(25);\n" +
                "                    } catch (InterruptedException e) {\n" +
                "                        e.printStackTrace();\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        thread.start();\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public boolean onCreateOptionsMenu(Menu menu) {\n" +
                "        getMenuInflater().inflate(R.menu.realtime, menu);\n" +
                "        return true;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public boolean onOptionsItemSelected(MenuItem item) {\n" +
                "\n" +
                "        switch (item.getItemId()) {\n" +
                "            case R.id.viewGithub: {\n" +
                "                Intent i = new Intent(Intent.ACTION_VIEW);\n" +
                "                i.setData(Uri.parse(\"https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/com/xxmassdeveloper/mpchartexample/RealtimeLineChartActivity.java\"));\n" +
                "                startActivity(i);\n" +
                "                break;\n" +
                "            }\n" +
                "            case R.id.actionAdd: {\n" +
                "                addEntry();\n" +
                "                break;\n" +
                "            }\n" +
                "            case R.id.actionClear: {\n" +
                "                chart.clearValues();\n" +
                "                Toast.makeText(this, \"Chart cleared!\", Toast.LENGTH_SHORT).show();\n" +
                "                break;\n" +
                "            }\n" +
                "            case R.id.actionFeedMultiple: {\n" +
                "                feedMultiple();\n" +
                "                break;\n" +
                "            }\n" +
                "            case R.id.actionSave: {\n" +
                "                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {\n" +
                "                    //saveToGallery();\n" +
                "                } else {\n" +
                "                    //requestStoragePermission(chart);\n" +
                "                }\n" +
                "                break;\n" +
                "            }\n" +
                "            case R.id.asdf: {\n" +
                "                Intent intentID = new Intent(getApplicationContext(), asdf.class);\n" +
                "                startActivity(intentID);\n" +
                "                break;\n" +
                "            }\n" +
                "        }\n" +
                "        return true;\n" +
                "    }\n" +
                "\n" +
                "//    @Override\n" +
                "//    protected void saveToGallery() {\n" +
                "//        //saveToGallery(chart, \"RealtimeLineChartActivity\");\n" +
                "//    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onValueSelected(Entry e, Highlight h) {\n" +
                "        Log.i(\"Entry selected\", e.toString());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNothingSelected() {\n" +
                "        Log.i(\"Nothing selected\", \"Nothing selected.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onPause() {\n" +
                "        super.onPause();\n" +
                "\n" +
                "        if (thread != null) {\n" +
                "            thread.interrupt();\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "package ko.alex.realtimechartpractice;\n" +
                "\n" +
                "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "    }\n" +
                "}\n" +
                " */");

    }

}
