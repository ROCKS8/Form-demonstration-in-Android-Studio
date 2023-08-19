package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eId;
    EditText fn;
    EditText ln;
    EditText cn;
    TextView submit;
    RadioGroup gender;
    RadioButton selectedButton;
    RadioButton maleBtn, femaleBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eId = findViewById(R.id.eId);
        fn = findViewById(R.id.fn);
        ln = findViewById(R.id.ln);
        cn = findViewById(R.id.cn);
        gender = findViewById(R.id.gender);
        maleBtn = findViewById(R.id.maleBtn);
        femaleBtn = findViewById(R.id.femaleBtn);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String output;

                int selectedGenderId = gender.getCheckedRadioButtonId();

                if (eId.getText().toString().trim().length() == 0){
                    eId.setError("Please enter your Enrollment Id");
                }
                else if (fn.getText().toString().trim().length() == 0){
                    fn.setError("Please enter your First Name");
                }
                else if (ln.getText().toString().trim().length() == 0){
                    ln.setError("Please enter your Last Name");
                }
                else if (cn.getText().toString().trim().length() == 0){
                    cn.setError("Please enter your Contact Number");
                }
                else if (selectedGenderId == -1){
                    maleBtn.setError("Please enter your Gender");
                    femaleBtn.setError("Please select your Gender");
                }else{

                    selectedButton = findViewById(selectedGenderId);

                    output = "Enrollment Id: " + eId.getText().toString() + "\n";
                    output += "Name: " + fn.getText().toString() + " " + ln.getText().toString() + "\n";
                    output += "Gender: " + selectedButton.getText().toString() + "\n";
                    output += "Contact Number: " + cn.getText().toString() + "\n";

                    Toast.makeText(MainActivity.this, output, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}