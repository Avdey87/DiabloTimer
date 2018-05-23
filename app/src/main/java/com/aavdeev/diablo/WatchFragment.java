package com.aavdeev.diablo;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WatchFragment extends Fragment implements View.OnClickListener{

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_watch, container, false);
        runTimer(layout);
        Button start = layout.findViewById(R.id.buttomStart);
        start.setOnClickListener(this);
        Button stop = layout.findViewById(R.id.buttomStop);
        stop.setOnClickListener(this);
        Button reset = layout.findViewById(R.id.buttomReset);
        reset.setOnClickListener(this);

        return layout;
    }

    public void runTimer(View view) {
        final TextView timeText = view.findViewById(R.id.textTimer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds / 3600;
                int min = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%2d:%02d:%02d", hour, min, sec);
                timeText.setText(time);
                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onCkickReset(View view) {
        running = false;
        seconds = 0;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            wasRunning = running;
            running = true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttomStart:
                onClickStart(v);
                break;
            case R.id.buttomStop:
                onClickStop(v);
                break;
            case R.id.buttomReset:
                onCkickReset(v);
                break;
        }
    }
}
