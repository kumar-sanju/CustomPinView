package com.smart.custompinview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.smart.custompinview.OtherPinActivity.OtherPinActivity;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CustomPinView) findViewById(R.id.firstPinView2)).setAnimationEnable(true);
        ((CustomPinView) findViewById(R.id.secondPinView2)).setAnimationEnable(true);
        ((CheckBox) findViewById(R.id.firstPasswordHidden)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.secondPasswordHidden)).setOnCheckedChangeListener(this);


        final CustomPinView customPin = findViewById(R.id.customPin);
        customPin.requestFocus();
        InputMethodManager inputMethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethod.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        final CustomPinView customPinView = findViewById(R.id.secondPinView);
        customPinView.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
        customPinView.setTextColor(
                ResourcesCompat.getColorStateList(getResources(), R.color.text_colors, getTheme()));
        customPinView.setLineColor(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
        customPinView.setLineColor(
                ResourcesCompat.getColorStateList(getResources(), R.color.line_colors, getTheme()));
        customPinView.setItemCount(4);
        customPinView.setItemHeight(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        customPinView.setItemWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        customPinView.setItemRadius(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_radius));
        customPinView.setItemSpacing(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
        customPinView.setLineWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
        customPinView.setAnimationEnable(true);// start animation when adding text
        customPinView.setCursorVisible(false);
        customPinView.setCursorColor(
                ResourcesCompat.getColor(getResources(), R.color.line_selected, getTheme()));
        customPinView.setCursorWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
        customPinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged() called with: s = [" + s + "], start = [" + start + "], before = [" + before + "], count = [" + count + "]");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        customPinView.setItemBackgroundColor(Color.BLACK);
        customPinView.setItemBackground(getResources().getDrawable(R.drawable.item_background));
        customPinView.setItemBackgroundResources(R.drawable.item_background);
        customPinView.setHideLineWhenFilled(false);

        ((EditText) findViewById(R.id.password)).setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_second_act:
                startActivity(new Intent(this, OtherPinActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private static class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }

            @Override
            public char charAt(int index) {
                return '*'; // This is the important part
            }

            @Override
            public int length() {
                return mSource.length();
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                char[] buf = new char[end - start];

                getChars(start, end, buf, 0);
                return new String(buf);
            }

            @Override
            public String toString() {
                return subSequence(0, length()).toString();
            }

            public void getChars(int start, int end, char[] dest, int off) {
                TextUtils.getChars(this, start, end, dest, off);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.firstPasswordHidden)
            ((CustomPinView) findViewById(R.id.firstPinView2)).setPasswordHidden(isChecked);
        else
            ((CustomPinView) findViewById(R.id.secondPinView2)).setPasswordHidden(isChecked);
    }
}
