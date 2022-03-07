package com.example.intent;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView TextLihatHasil;
    private EditText EditText1;
    private EditText EditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextLihatHasil= findViewById(R.id.text_Lihat_Hasil);
        EditText1 = findViewById(R.id.edit_text1);
        EditText2 = findViewById(R.id.edit_text2);

        Button buttonOpenActivity2 = findViewById(R.id.button_lihat_activity2);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View lihat) {
                if (EditText1.getText().toString().equals("")
                        || EditText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Silahkan Masukkan Bilangan", Toast.LENGTH_SHORT).show();
                } else {

                    int bilA = Integer.parseInt(EditText1.getText().toString());
                    int bilB = Integer.parseInt(EditText2.getText().toString());

                    Intent intent = new Intent(MainActivity.this, com.example.intent.Activity2.class);
                    intent.putExtra("Bilangan A", bilA);
                    intent.putExtra("Bilangan B", bilB);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int hasil = data.getIntExtra("hasil", 0);
                TextLihatHasil.setText("" + hasil);
            }
            if (resultCode == RESULT_CANCELED) {
                TextLihatHasil.setText("Tidak ada yang dipilih");
            }
        }
    }
}