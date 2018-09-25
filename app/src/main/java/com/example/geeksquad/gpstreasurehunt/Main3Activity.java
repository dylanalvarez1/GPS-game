package com.example.geeksquad.gpstreasurehunt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends ClosableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);
        if(MainActivity.keyOfUnderstanding) //If you already went to toronto
        {
            MainActivity.keyOfCulture = true;
            TextView text = findViewById(R.id.response);
            text.setText("Your key of understanding has allowed you to communicate with the people of Sao Paulo. They understand the struggle of maintaining a 4.0 and gladly hand over the key of culture.");
        }
        else //if not yet been to toronto
        {
            TextView text = findViewById(R.id.response);
            text.setText("You fail to understand what anyone is trying to say to you. Maybe you should head back to UF.");
        }
    }
}
