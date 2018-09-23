package com.example.my.testserverapp;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView receive_textview;
Button start_button;

MsgBroadReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receive_textview=findViewById(R.id.receive_text);
        start_button=findViewById(R.id.start_button);
        receiver=new MsgBroadReceiver(receive_textview);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread server=new Thread(new ServerAndroid(receiver,MainActivity.this));
                server.start();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.my.testserverapp.receivemsg");

                registerReceiver(receiver,intentFilter);
            }
        });
    }
}
