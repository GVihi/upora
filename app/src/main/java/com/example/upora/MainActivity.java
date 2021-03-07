package com.example.upora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.Components;
import com.example.lib.RAM;

public class MainActivity extends AppCompatActivity {
    EditText etBrand;
    EditText etCapacity;
    EditText etSpeed;
    EditText etCL;
    Components NZXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBrand = findViewById(R.id.editTextBrand);
        etCapacity = findViewById(R.id.editTextCapacity);
        etSpeed = findViewById(R.id.editTextSpeed);
        etCL = findViewById(R.id.editTextCasLatency);

        NZXT = new Components("NZXT");
    }

    public void onClickAddRam(View view){
        try {
            RAM insert = new RAM(etBrand.getText().toString(), Integer.parseInt(etCapacity.getText().toString()), Integer.parseInt(etSpeed.getText().toString()), Integer.parseInt(etCL.getText().toString()));
            NZXT.addRam(insert);
            etBrand.setText("");
            etCapacity.setText("");
            etSpeed.setText("");
            etCL.setText("");
            Toast.makeText(this,"New RAM inserted",Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(this,"Check inserted values",Toast.LENGTH_LONG).show();
        }

    }

    public void onClickInfo(View view){
        System.out.println("Number of elements in ramArrayList: " + NZXT.size());
    }

    public void onClickExit(View view){
        finish();
        System.exit(0);
    }


}