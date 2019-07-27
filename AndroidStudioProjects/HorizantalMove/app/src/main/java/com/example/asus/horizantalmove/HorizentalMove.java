package com.example.asus.horizantalmove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HorizentalMove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizental_move);

      // TextView titleVeiw = (TextView) findViewById(R.id.titleWindow);
        TextView messageVeiw = (TextView) findViewById(R.id.messageWindow);

       /// titleVeiw.setText("This is tile window \n\n\n");

        StringBuilder stringBuilder = new StringBuilder();

        String message = "I Love her n......a    tooo   much \n";

        for(int i=0;i<100;i++){
            stringBuilder.append(message);
        }

        messageVeiw.setText(stringBuilder.toString());


    }
}
