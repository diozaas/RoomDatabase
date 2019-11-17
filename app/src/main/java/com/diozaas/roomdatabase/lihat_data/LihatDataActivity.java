package com.diozaas.roomdatabase.lihat_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.diozaas.roomdatabase.R;
import com.diozaas.roomdatabase.adapter.MahasiswaAdapterr;
import com.diozaas.roomdatabase.database.AppDatabase;
import com.diozaas.roomdatabase.model.ModelMahasiswa;

import java.util.ArrayList;

public class LihatDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MahasiswaAdapterr adapterr;
    ArrayList<ModelMahasiswa> data;
    AppDatabase db;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        getSupportActionBar().setTitle("Data Mahasiswa");

        recyclerView = findViewById(R.id.recycler_mahasiswa);
        swipe = findViewById(R.id.swipe_refresh);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"db_mahasiswa").allowMainThreadQueries().build();

        getData();
    }

    void getData(){
        data = new ArrayList<>();
        data.clear();
        data.addAll(db.mahasiswaDao().getMahasiswa());
        adapterr = new MahasiswaAdapterr(getApplicationContext(), data);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapterr);

        // untuk menghentikan swipe agar tidak berputar terus
        swipe.setRefreshing(false);
    }
}
