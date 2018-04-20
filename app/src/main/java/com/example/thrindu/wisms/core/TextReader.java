package com.example.thrindu.wisms.core;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class TextReader extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        Uri uriSMSRead = Uri.parse("content://sms/inbox");
        Cursor cur = getContentResolver().query(uriSMSRead, null, null, null, null);
        String sms = "";
        while (cur.moveToNext()) {
            sms += "From :" + cur.getString(2) + " : " + cur.getString(11) + "\n";
        }
        textView.setText(sms);
        setContentView(textView);
    }
}
