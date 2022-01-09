package com.example.a182805015;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class Bildirim_Kanali extends BroadcastReceiver{
    public static String ACTION_CLICK = "ACTION_CLICK";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equalsIgnoreCase(ACTION_CLICK)){
            Toast.makeText(context, "CLICK", Toast.LENGTH_SHORT).show();
        }
    }
}
