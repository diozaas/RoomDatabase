package com.diozaas.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.diozaas.roomdatabase.lihat_data.LihatDataActivity;
import com.diozaas.roomdatabase.tambah_data.TambahDataActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_lihat_data, btn_tambah_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lihat_data = findViewById(R.id.btn_lihat);
        btn_tambah_data = findViewById(R.id.btn_tambah);

        btn_lihat_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLihat = new Intent(MainActivity.this, LihatDataActivity.class);
                startActivity(intentLihat);
            }
        });

        btn_tambah_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenTambah = new Intent(MainActivity.this, TambahDataActivity.class);
                startActivity(intenTambah);
            }
        });
    }
}
