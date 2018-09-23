package com.example.my.testserverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

/**
 * @author caiqiao.li on 2018/9/22.
 * @Tel 13535537486
 */
public class MsgBroadReceiver extends BroadcastReceiver {
    TextView textView;
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg=intent.getStringExtra("msg");
        if(textView!=null){
            textView.setText(msg);
        }

    }

    public MsgBroadReceiver(TextView textView) {
        this.textView = textView;
    }
}
