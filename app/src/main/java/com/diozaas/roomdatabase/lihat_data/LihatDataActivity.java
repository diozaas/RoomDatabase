package com.diozaas.roomdatabase.lihat_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.diozaas.roomdatabase.R;

public class LihatDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        getSupportActionBar().setTitle("Data Mahasiswa");
    }
}
