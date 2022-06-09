package com.smart.custompinview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private EditText otpET1, otpET2, otpET3, otpET4;
    Button submitBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        otpET1 = findViewById(R.id.otpET1);
        otpET2 = findViewById(R.id.otpET2);
        otpET3 = findViewById(R.id.otpET3);
        otpET4 = findViewById(R.id.otpET4);
        submitBtn2 = findViewById(R.id.submitBtn2);

        OTPTextWatcher.OTPCompleteListener otpCompleteListener = new OTPTextWatcher.OTPCompleteListener() {
            @Override
            public void onOTPFilled(String otp) {
                Log.d("sanju", "onOTPFilled: "+otp);
                submitBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                Log.d("sanju", "onClick: "+ editable);
                    }
                });
            }

            @Override
            public void onOTPIncomplete() {
            }
        };

        List<EditText> otpViewList = Arrays.asList(otpET1, otpET2, otpET3, otpET4);
        for (EditText etOTP : otpViewList) {
            etOTP.addTextChangedListener(new OTPTextWatcher(etOTP, otpViewList, otpCompleteListener));
        }
    }

    public static class OTPTextWatcher implements TextWatcher {

        private EditText view;
        private List<EditText> otpDigitViews;
        private OTPCompleteListener otpListener;
        private static int lastOtpLength;

        public OTPTextWatcher(EditText otpView, List<EditText> otpDigitViews, OTPCompleteListener listener) {
            view = otpView;
            this.otpDigitViews = otpDigitViews;
            this.otpListener = listener;
        }


        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            String digit1 = otpDigitViews.get(0).getText().toString();
            String digit2 = otpDigitViews.get(1).getText().toString();
            String digit3 = otpDigitViews.get(2).getText().toString();
            String digit4 = otpDigitViews.get(3).getText().toString();
            String currentDigit = editable.toString();
            final String inputValue = digit1 + digit2 + digit3 + digit4;

            if (inputValue.length() == 4) {
                otpListener.onOTPFilled(inputValue);
            } else {

                if (currentDigit.length() >= 1
                        && view != otpDigitViews.get(3)) {
                    if (view != null)
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                } else {
                    if (currentDigit.length() <= 0 && view.getSelectionStart() <= 0) {
                        try {
                            view.focusSearch(View.FOCUS_LEFT).requestFocus();
                        } catch (NullPointerException e) {
//                            LogHelper.printErrorLog("There is no view left to current edit text");
                        }
                    }
                }

                if (OTPTextWatcher.lastOtpLength == 4) {
                    otpListener.onOTPIncomplete();
                }
            }

            OTPTextWatcher.lastOtpLength = inputValue.length();
        }

        public interface OTPCompleteListener {
            void onOTPFilled(String otp);

            void onOTPIncomplete();
        }
    }


}
