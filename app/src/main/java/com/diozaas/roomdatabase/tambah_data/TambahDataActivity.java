package com.diozaas.roomdatabase.tambah_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diozaas.roomdatabase.R;
import com.diozaas.roomdatabase.database.AppDatabase;
import com.diozaas.roomdatabase.model.ModelMahasiswa;

public class TambahDataActivity extends AppCompatActivity {

    EditText edtNim, edtNama, edtAlamat;
    Button btnSubmit;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        getSupportActionBar().setTitle("Tambah Data Mahasiswa");

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db_mahasiswa").build();

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtAlamat = findViewById(R.id.edt_asal);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nim = Integer.parseInt(edtNim.getText().toString());
                String nama = edtNama.getText().toString();
                String alamat = edtAlamat.getText().toString();
                ModelMahasiswa data = new ModelMahasiswa(nim, nama, alamat);

                insertMahasiswa(data);
            }
        });
    }

    public void insertMahasiswa(final ModelMahasiswa modelMahasiswa){
        new AsyncTask<Void,Void,Long>() {

            // di proses pada saat mainthread sebelum muncul aksi
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            // di proses pada Background saat telah berjalan
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.mahasiswaDao().insertMahasiswa(modelMahasiswa);
                return null;
            }

            // pada saat update data
            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            // pada saat transaksi selesai
            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                Toast.makeText(TambahDataActivity.this, "Data Berhasil di Insert", Toast.LENGTH_SHORT).show();
            }

        }.execute();
    }
}
