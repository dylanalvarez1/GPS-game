package com.example.geeksquad.gpstreasurehunt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends ClosableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        //This is toronto, meaning no matter what, give them the key of understanding
        MainActivity.keyOfUnderstanding = true;
        TextView text = findViewById(R.id.response);
        text.setText("Canada is filled with amazing and kind hearted people. Recognizing the situation, they give you the key of understanding. You head back to UF.");
    }
}
