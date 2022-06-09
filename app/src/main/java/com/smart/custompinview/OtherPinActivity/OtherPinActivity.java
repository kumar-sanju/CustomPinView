package com.smart.custompinview.OtherPinActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.smart.custompinview.R;

public class OtherPinActivity extends AppCompatActivity {

    private EditText otpET1, otpET2, otpET3, otpET4;
    private EditText otpET11, otpET22, otpET33, otpET44, otpET55, otpET66;
    private EditText otpET111, otpET222, otpET333, otpET444;
    private EditText otpET1111, otpET2222, otpET3333, otpET4444;
    private int selectionPosition = 0;
    Button submitBtn, submitBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_pin);

        otpET1 = findViewById(R.id.otpET1);
        otpET2 = findViewById(R.id.otpET2);
        otpET3 = findViewById(R.id.otpET3);
        otpET4 = findViewById(R.id.otpET4);
        submitBtn2 = findViewById(R.id.submitBtn2);

        otpET11 = findViewById(R.id.otpET11);
        otpET22 = findViewById(R.id.otpET22);
        otpET33 = findViewById(R.id.otpET33);
        otpET44 = findViewById(R.id.otpET44);
        otpET55 = findViewById(R.id.otpET55);
        otpET66 = findViewById(R.id.otpET66);

        otpET111 = findViewById(R.id.otpET111);
        otpET222 = findViewById(R.id.otpET222);
        otpET333 = findViewById(R.id.otpET333);
        otpET444 = findViewById(R.id.otpET444);
        submitBtn = findViewById(R.id.submitBtn);

        otpET1111 = findViewById(R.id.otpET1111);
        otpET2222 = findViewById(R.id.otpET2222);
        otpET3333 = findViewById(R.id.otpET3333);
        otpET4444 = findViewById(R.id.otpET4444);

        otp();

//        this.otpET11.addTextChangedListener(new GenericTextWatcher(otpET11));
//        this.otpET22.addTextChangedListener(new GenericTextWatcher(otpET22));
//        this.otpET33.addTextChangedListener(new GenericTextWatcher(otpET33));
//        this.otpET44.addTextChangedListener(new GenericTextWatcher(otpET44));
//        this.otpET55.addTextChangedListener(new GenericTextWatcher(otpET55));
//        this.otpET66.addTextChangedListener(new GenericTextWatcher(otpET66));

        otpET111.addTextChangedListener(textWatcher);
        otpET222.addTextChangedListener(textWatcher);
        otpET333.addTextChangedListener(textWatcher);
        otpET444.addTextChangedListener(textWatcher);

        showKeyBoard(otpET111);

//        this.otpET1111.addTextChangedListener(new GenericTextWatcher(otpET1111));
//        this.otpET2222.addTextChangedListener(new GenericTextWatcher(otpET2222));
//        this.otpET3333.addTextChangedListener(new GenericTextWatcher(otpET3333));
//        this.otpET4444.addTextChangedListener(new GenericTextWatcher(otpET4444));

    }

    private void otp() {
        otpET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("sanju", "beforeTextChanged: "+ "Clicked");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                otpET1.setEnabled(true);
                otpET1.requestFocus();
//                submitBtn2.setEnabled(false);
//                submitBtn2.setBackgroundResource(R.color.purple_500);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otpET1.getText().toString().length() == 1) {
                    otpET2.requestFocus();
//                    otpET1.setEnabled(false);
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }
        });

        otpET2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("sanju", "beforeTextChanged: "+ "Clicked");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (otpET2.getText().toString().length() == 0) {
//                    otpET1.setEnabled(true);
                    otpET1.requestFocus();
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otpET2.getText().toString().length() == 1) {
                    otpET3.requestFocus();
//                    otpET2.setEnabled(false);
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }
        });

        otpET3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (otpET3.getText().toString().length() == 0) {
//                    otpET2.setEnabled(true);
                    otpET2.requestFocus();
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otpET3.getText().toString().length() == 1) {
                    otpET4.requestFocus();
//                    otpET3.setEnabled(false);
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }
        });

        otpET4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (otpET4.getText().toString().length() == 0) {
//                    otpET3.setEnabled(true);
                    otpET3.requestFocus();
//                    submitBtn2.setEnabled(false);
//                    submitBtn2.setBackgroundResource(R.color.purple_500);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otpET4.getText().toString().length() == 1) {
                    submitBtn2.setEnabled(true);
                    submitBtn2.setBackgroundResource(R.color.colorAccent);
                }
            }
        });
    }

//    public class GenericTextWatcher implements TextWatcher {
//        private View view;
//
//        GenericTextWatcher(View view) {
//            this.view = view;
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            boolean allOtherFilled = false;
//            EditText nextEdit = null;
//            EditText previousEdit = null;
//            switch (view.getId()) {
//                case R.id.otpET11:
//                    allOtherFilled = otpET22.getText().length() == 1
//                            && otpET33.getText().length() == 1
//                            && otpET44.getText().length() == 1
//                            && otpET55.getText().length() == 1
//                            && otpET66.getText().length() == 1;
//                    nextEdit = otpET22;
//                    break;
//                case R.id.otpET22:
//                    allOtherFilled = otpET11.getText().length() == 1
//                            && otpET33.getText().length() == 1
//                            && otpET44.getText().length() == 1
//                            && otpET55.getText().length() == 1
//                            && otpET66.getText().length() == 1;
//                    nextEdit = otpET33;
//                    previousEdit = otpET11;
//                    break;
//                case R.id.otpET33:
//                    allOtherFilled = otpET11.getText().length() == 1
//                            && otpET22.getText().length() == 1
//                            && otpET44.getText().length() == 1
//                            && otpET55.getText().length() == 1
//                            && otpET66.getText().length() == 1;
//                    nextEdit = otpET44;
//                    previousEdit = otpET22;
//                    break;
//                case R.id.otpET44:
//                    allOtherFilled = otpET11.getText().length() == 1
//                            && otpET22.getText().length() == 1
//                            && otpET33.getText().length() == 1
//                            && otpET55.getText().length() == 1
//                            && otpET66.getText().length() == 1;
//                    nextEdit = otpET55;
//                    previousEdit = otpET33;
//                    break;
//                case R.id.otpET55:
//                    allOtherFilled = otpET11.getText().length() == 1
//                            && otpET22.getText().length() == 1
//                            && otpET33.getText().length() == 1
//                            && otpET44.getText().length() == 1
//                            && otpET66.getText().length() == 1;
//                    nextEdit = otpET66;
//                    previousEdit = otpET44;
//                    break;
//                case R.id.otpET66:
//                    allOtherFilled = otpET11.getText().length() == 1
//                            && otpET22.getText().length() == 1
//                            && otpET33.getText().length() == 1
//                            && otpET44.getText().length() == 1
//                            && otpET55.getText().length() == 1;
//                    previousEdit = otpET55;
//                    break;
//            }
//
//            if (s.length() == 1) {
//                if (allOtherFilled) {
//                    //if next 2 edit texts are filled , enable the pay button
//                    Log.d("sanju", "Enable Button: ");
////                    enableDisableButton(continueButton, true);
////                    KeyboardUtils.hideKeyboard(LoginActivity.this, (EditText) view);
//                    Log.d("sanju", "Hide key board: ");
//                }
//            } else if (s.length() > 1) {
//                if (allOtherFilled) {
//                    //if all next edit texts are filled , enable the pay button
//                    Log.d("sanju", "Enable Button: ");
////                    enableDisableButton(continueButton, true);
////                    KeyboardUtils.hideKeyboard(LoginActivity.this, (EditText) view);
//                    Log.d("sanju", "Hide key board: ");
//
//                } else if (nextEdit != null) {
//                    if (nextEdit.getText().length() == 0) {
//                        //if next edit is not filled, move to next edit and set the second digit
//                        moveToNextEdit(nextEdit, (EditText) view);
//                    } else {
//                        //if any other edit is not filled, stay in current edit
//                        Log.d("sanju", "Disable Button: ");
////                        enableDisableButton(continueButton, false);
//                        stayOnCurrentEdit((EditText) view);
//                    }
//                }
//            } else if (s.length() < 1) {
//                if (null != previousEdit)
//                    moveToPreviousEdit(previousEdit);
////                enableDisableButton(continueButton, false);
//                Log.d("sanju", "Disable Button: ");
//            }
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//        }
//
//        private void stayOnCurrentEdit(EditText editText) {
//            editText.setText(editText.getText().toString().substring(0, 1));
//            editText.setSelection(editText.getText().length());
//        }
//
//        private void moveToPreviousEdit(EditText editText) {
//            editText.setSelection(editText.getText().length());
//            editText.requestFocus();
//        }
//
//        private void moveToNextEdit(EditText editText2, EditText editText1) {
//            editText2.setText(editText1.getText().toString().substring(1, 2));
//            editText2.requestFocus();
//            editText2.setSelection(editText2.getText().length());
//            editText1.setText(editText1.getText().toString().substring(0, 1));
//        }
//    }

//    public class GenericTextWatcher implements TextWatcher {
//        private View view;
//
//        GenericTextWatcher(View view) {
//            this.view = view;
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            if (s.length() > 0) {
//                if (selectionPosition == 0) {
//                    selectionPosition = 1;
//                    showKeyBoard(otpET2222);
//                }
//                else if (selectionPosition == 1) {
//                    selectionPosition = 2;
//                    showKeyBoard(otpET3333);
//                }
//                else if (selectionPosition == 2) {
//                    selectionPosition = 3;
//                    showKeyBoard(otpET4444);
//                }
//                else {
//                    submitBtn.setText("Clicked");
//                }
//            }
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//            if (arg0.length() == 0) {
//                if (selectionPosition == 3) {
//                    selectionPosition = 2;
//                    showKeyBoard(otpET3333);
//                }
//                else if (selectionPosition == 2) {
//                    selectionPosition = 1;
//                    showKeyBoard(otpET2222);
//                }
//                else if (selectionPosition == 1) {
//                    selectionPosition = 0;
//                    showKeyBoard(otpET1111);
//                }
//            }
//        }
//    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length() == 0) {
                if (selectionPosition == 3) {
                    selectionPosition = 2;
                    showKeyBoard(otpET333);
                }
                else if (selectionPosition == 2) {
                    selectionPosition = 1;
                    showKeyBoard(otpET222);
                }
                else if (selectionPosition == 1) {
                    selectionPosition = 0;
                    showKeyBoard(otpET111);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                if (selectionPosition == 0) {
                    selectionPosition = 1;
                    showKeyBoard(otpET222);
                }
                else if (selectionPosition == 1) {
                    selectionPosition = 2;
                    showKeyBoard(otpET333);
                }
                else if (selectionPosition == 2) {
                    selectionPosition = 3;
                    showKeyBoard(otpET444);
                }
                else {
                    submitBtn.setText("Clicked");
                }
            }
        }

    };

    private void showKeyBoard(EditText otpET) {
        otpET.setEnabled(true);
        otpET.requestFocus();

        InputMethodManager inputMethod = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethod.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (selectionPosition == 3) {
                selectionPosition = 2;
                showKeyBoard(otpET333);
            }
            else if (selectionPosition == 2) {
                selectionPosition = 1;
                showKeyBoard(otpET222);
            }
            else if (selectionPosition == 1) {
                selectionPosition = 0;
                showKeyBoard(otpET111);
            }
            submitBtn.setText("Submit");
            return true;
        }
        else {
            return super.onKeyUp(keyCode, event);
        }
    }

}