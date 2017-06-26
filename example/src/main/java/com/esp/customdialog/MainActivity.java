package com.esp.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.esp.customalertdialog.CustomAlertDialog;

public class MainActivity extends AppCompatActivity {

    CustomAlertDialog customAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAlertDialog = new CustomAlertDialog.Builder(MainActivity.this, R.layout.dialog)
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
                .positiveButtonId(R.id.positive, "OK")
                .build();
        customAlertDialog.show();
    }
}
