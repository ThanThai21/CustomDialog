package com.esp.customalertdialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomAlertDialog {

    AlertDialog.Builder builder;
    AlertDialog dialog;

    public CustomAlertDialog(Builder customBuilder) {
        this.builder = customBuilder.getBuilder();
        dialog = builder.create();
    }

    public void show() {
        dialog.show();
    }

    public void cancel() {
        dialog.cancel();
    }

    public static class Builder {

        AlertDialog.Builder builder;
        AlertDialog dialog;
        View view;

        private Context context;
        private int layoutResId;

        private int titleId;
        private int negativeButtonId;
        private int positiveButtonId;
        private boolean hasTitle = false;
        private boolean hasNegativeButton = false;
        private boolean hasPositiveButton = false;
        private String titleStr;
        private String negativeStr;
        private String positiveStr;
        private View.OnClickListener negativeListener = null;
        private View.OnClickListener positiveListener = null;

        public Builder(Context context, int layoutResId) {
            this.context = context;
            this.layoutResId = layoutResId;
        }

        public Builder titleId(int titleId, String titleStr) {
            hasTitle = true;
            this.titleId = titleId;
            this.titleStr = titleStr;
            return this;
        }

        public Builder negativeButtonId(int negativeButtonId, String negativeStr) {
            hasNegativeButton = true;
            this.negativeButtonId = negativeButtonId;
            this.negativeStr = negativeStr;
            return this;
        }

        public Builder positiveButtonId(int positiveButtonId, String positiveStr) {
            hasPositiveButton = true;
            this.positiveButtonId = positiveButtonId;
            this.positiveStr = positiveStr;
            return this;
        }

        public Builder negativeListener(View.OnClickListener negativeListener) {
            this.negativeListener = negativeListener;
            return this;
        }

        public Builder positiveListener(View.OnClickListener positiveListener) {
            this.positiveListener = positiveListener;
            return this;
        }

        public AlertDialog.Builder getBuilder() {
            builder = new AlertDialog.Builder(context);
            view = LayoutInflater.from(context).inflate(layoutResId, null);
            TextView title = null;
            Button negativeButton = null;
            Button positiveButton = null;
            if (hasTitle) {
                title = (TextView) view.findViewById(titleId);
                title.setText(titleStr);
            }
            if (hasNegativeButton) {
                negativeButton = (Button) view.findViewById(negativeButtonId);
                negativeButton.setText(negativeStr);
                if (negativeListener != null) {
                    negativeButton.setOnClickListener(negativeListener);
                }
            }
            if (hasPositiveButton) {
                positiveButton = (Button) view.findViewById(positiveButtonId);
                positiveButton.setText(positiveStr);
                if (positiveListener != null) {
                    positiveButton.setOnClickListener(positiveListener);
                }
            }
            builder.setView(view);

            return builder;
        }

        public View getView() {
            return view;
        }

        public CustomAlertDialog build() {
            return new CustomAlertDialog(this);
        }

    }

}
