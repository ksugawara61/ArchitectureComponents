package net.kokohadoko.instil.samplelifecyclesjava;

import android.os.SystemClock;
import android.os.Bundle;
import android.widget.Chronometer;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        if (mainViewModel.getStartDate() == null) {
            long startTime = SystemClock.elapsedRealtime();
            mainViewModel.setStartDate(startTime);
            chronometer.setBase(startTime);
        } else {
            chronometer.setBase(mainViewModel.getStartDate());
        }

        chronometer.start();
    }
}
