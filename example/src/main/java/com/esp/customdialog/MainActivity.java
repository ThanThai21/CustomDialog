package com.esp.customdialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.esp.customalertdialog.CustomAlertDialog;

public class MainActivity extends AppCompatActivity {

    CustomAlertDialog customAlertDialog;
    CustomAlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new CustomAlertDialog.Builder(MainActivity.this, R.layout.dialog)
                .titleId(R.id.title_tv, "Title")
                .negativeButtonId(R.id.negative, "Cancel")
                .negativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customAlertDialog.cancel();
                    }
                })
                .positiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customAlertDialog.cancel();
                    }
                })
                .positiveButtonId(R.id.positive, "OK");
        customAlertDialog = builder.build();
        View view = builder.getView();
        TextView textView = (TextView) view.findViewById(R.id.demo);
        textView.setTextColor(Color.RED);
        customAlertDialog.show();
    }
}
