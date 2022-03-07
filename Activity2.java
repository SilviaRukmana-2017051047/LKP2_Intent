package com.example.intent;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setTitle("Activity A");

        Intent intent = getIntent();
        final int bilA = intent.getIntExtra("Bilangan A", 0);
        final int bilB = intent.getIntExtra("Bilangan B", 0);

        TextView textViewNumbers1 = findViewById(R.id.text_view_numbers1);
        textViewNumbers1.setText("Bilangan A : " + bilA );
        TextView textViewNumbers2 = findViewById(R.id.text_view_numbers2);
        textViewNumbers2.setText("Bilangan B : " + bilB );

        Button buttonTambah = findViewById(R.id.button_tambah);
        Button buttonKurang = findViewById(R.id.button_kurang);
        Button buttonKali = findViewById(R.id.button_kali);
        Button buttonBagi = findViewById(R.id.button_bagi);


        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = bilA + bilB;

                Intent hasilIntent = new Intent();
                hasilIntent.putExtra("hasil", hasil);

                setResult(RESULT_OK, hasilIntent);
                finish();
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = bilA - bilB;

                Intent hasilIntent = new Intent();
                hasilIntent.putExtra("hasil", hasil);

                setResult(RESULT_OK, hasilIntent);
                finish();
            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = bilA * bilB;

                Intent hasilIntent = new Intent();
                hasilIntent.putExtra("hasil", hasil);

                setResult(RESULT_OK, hasilIntent);
                finish();
            }
        });

        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = bilA / bilB;

                Intent hasilIntent = new Intent();
                hasilIntent.putExtra("hasil", hasil);

                setResult(RESULT_OK, hasilIntent);
                finish();
            }
        });
    }
}