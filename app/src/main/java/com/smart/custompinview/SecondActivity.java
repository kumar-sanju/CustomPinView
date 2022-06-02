package com.smart.custompinview;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((CustomPinView) findViewById(R.id.firstPinView)).setAnimationEnable(true);
        ((CustomPinView) findViewById(R.id.secondPinView)).setAnimationEnable(true);
        ((CheckBox) findViewById(R.id.firstPasswordHidden)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.secondPasswordHidden)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.firstPasswordHidden)
            ((CustomPinView) findViewById(R.id.firstPinView)).setPasswordHidden(isChecked);
        else
            ((CustomPinView) findViewById(R.id.secondPinView)).setPasswordHidden(isChecked);
    }
}
