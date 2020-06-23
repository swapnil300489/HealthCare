package com.example.healthcare.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.R;

public class OtpScreenActivity extends AppCompatActivity {

    private String country = "India", contactNum = "888888888";
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private TextView id_contactNumber_txt;
    private Button id_sendOTP_Btn;
    private ImageView id_cross_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

        init();

        editText1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText1.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        editText2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText2.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText3.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        editText3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText3.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText4.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        editText4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText4.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText5.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        editText5.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText5.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText6.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });



        id_sendOTP_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String OTP_1 = editText1.getText().toString().trim();
                String OTP_2 = editText2.getText().toString().trim();
                String OTP_3 = editText3.getText().toString().trim();
                String OTP_4 = editText4.getText().toString().trim();
                String OTP_5 = editText5.getText().toString().trim();
                String OTP_6 = editText6.getText().toString().trim();


                String OTP = OTP_1 + OTP_2 + OTP_3 + OTP_4 + OTP_5 + OTP_6;


                if (OTP.length() == 0){

                    Toast.makeText(getApplicationContext(), "Please Enter OTP", Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getApplicationContext(), "OTP Is Correct", Toast.LENGTH_LONG).show();

                }

            }
        });

        id_cross_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init() {

        editText1 = findViewById(R.id.id_otp_1);
        editText2 = findViewById(R.id.id_otp_2);
        editText3 = findViewById(R.id.id_otp_3);
        editText4 = findViewById(R.id.id_otp_4);
        editText5 = findViewById(R.id.id_otp_5);
        editText6 = findViewById(R.id.id_otp_6);
        id_contactNumber_txt = findViewById(R.id.id_contactNumber_txt);
        id_cross_2 = findViewById(R.id.id_cross_2);
        id_sendOTP_Btn = findViewById(R.id.id_sendOTP_Btn);

        country = getIntent().getStringExtra("country");
        contactNum = getIntent().getStringExtra("contactNum");

        // Comment in init()

        id_contactNumber_txt.setText(getResources().getString(R.string.OTP_text_5)+" "+country+" "+contactNum);
    }
}
