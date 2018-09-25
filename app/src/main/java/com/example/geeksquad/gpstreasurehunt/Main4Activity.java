package com.example.geeksquad.gpstreasurehunt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends ClosableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main4);
        if(MainActivity.keyOfUnderstanding && MainActivity.keyOfCulture) //If you already went to toronto and Sao Paulo
        {
            MainActivity.keyOfIntellect = true;
            TextView text = findViewById(R.id.response);
            text.setText("With complete empathic powers, you convince the people of Paris to give you their sacred key of intellect. You now have what it takes to save your grade.");
        }
        else if(MainActivity.keyOfUnderstanding && !MainActivity.keyOfCulture) //if not yet been to sao paulo
        {
            TextView text = findViewById(R.id.response);
            text.setText("You can understand the Parisians, but have difficulty convincing them to hand over their key. Maybe you should head back to UF.");
        }
        else {
            TextView text = findViewById(R.id.response);
            text.setText("You can't seem to understand French. Maybe you should head back to UF.");
        }
    }
}
