package de.derandroidpro.tastermorse_app;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ToneGenerator toneGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC, ToneGenerator.MAX_VOLUME);

        btn = (Button) findViewById(R.id.button);
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    // Wenn Button gedrückt
                    case MotionEvent.ACTION_DOWN:{

                        toneGenerator.startTone(ToneGenerator.TONE_DTMF_D);

                        break;
                    }

                    // Wenn Button losgelassen
                    case MotionEvent.ACTION_UP:{
                        toneGenerator.stopTone();

                        break;
                    }
                }

                return false;
            }
        });
    }


}
