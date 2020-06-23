package com.example.healthcare.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthcare.R;

public class MainActivity extends AppCompatActivity {

    private TextView id_countryCode;
    private EditText id_contactNumber;
    private Button id_submitButton;
    private ImageView id_cross_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        id_contactNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("Text_afterTextChanged", s.toString()+" Count : "+s.length());

                if(s.length()== 10){
                    id_contactNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tick, 0);
                }else {
                    id_contactNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }


            }
        });


        id_submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String contactNum = id_contactNumber.getText().toString();
                String country = id_countryCode.getText().toString().trim();

                if(contactNum.length() == 10){

                    Intent intent = new Intent(MainActivity.this, OtpScreenActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("country", country);
                    intent.putExtra("contactNum", contactNum);
                    startActivity(intent);

                }else if(contactNum.length() < 10){

                    id_contactNumber.requestFocus();
                    id_contactNumber.setError("Enter 10 digit contact number");

                }else if(contactNum.isEmpty()){
                    id_contactNumber.requestFocus();
                    id_contactNumber.setError("Enter contact number");
                }


            }
        });


        id_cross_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        id_countryCode   = findViewById(R.id.id_countryCode);
        id_contactNumber = findViewById(R.id.id_contactNumber);
        id_submitButton  = findViewById(R.id.id_submitButton);

        id_cross_1 = findViewById(R.id.id_cross_1);

    }
}
