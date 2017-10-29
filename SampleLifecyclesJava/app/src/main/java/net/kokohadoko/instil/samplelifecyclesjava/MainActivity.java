package net.kokohadoko.instil.samplelifecyclesjava;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.os.SystemClock;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Chronometer;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private final LifecycleRegistry registry = new LifecycleRegistry(this);
    private LiveDataTimerViewModel liveDataTimerViewModel;

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();

/*        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        if (mainViewModel.getStartDate() == null) {
            long startTime = SystemClock.elapsedRealtime();
            mainViewModel.setStartDate(startTime);
            chronometer.setBase(startTime);
        } else {
            chronometer.setBase(mainViewModel.getStartDate());
        }

        chronometer.start();*/
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                String newText = MainActivity.this.getResources().getString(R.string.seconds, aLong);
                ((TextView) findViewById(R.id.timer_textview)).setText(newText);
                Log.d("MainActivity", "Updating timer");
            }
        };

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
