package com.diozaas.roomdatabase.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.diozaas.roomdatabase.R;
import com.diozaas.roomdatabase.database.AppDatabase;
import com.diozaas.roomdatabase.model.ModelMahasiswa;
import com.diozaas.roomdatabase.tambah_data.TambahDataActivity;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaAdapterr extends RecyclerView.Adapter<MahasiswaAdapterr.MahasiswaViewHolder> {

    Context context;
    ArrayList<ModelMahasiswa> listMahasiswa;
    AppDatabase db;

    public MahasiswaAdapterr(Context context, ArrayList<ModelMahasiswa> listMahasiswa) {
        this.context = context;
        this.listMahasiswa = listMahasiswa;

        db = Room.databaseBuilder(context, AppDatabase.class,"db_mahasiswa").allowMainThreadQueries().build();
    }

    // untuk set layout
    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mahasiswa,parent,false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, final int position) {
        holder.txtNama.setText(listMahasiswa.get(position).getNama());
        holder.txtNim.setText(Integer.toString(listMahasiswa.get(position).getNim()));
        holder.txtAlamat.setText(listMahasiswa.get(position).getAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelMahasiswa modelMahasiswa = db.mahasiswaDao().detailMahasiswa(listMahasiswa.get(position).getIdMahasiswa());

                Intent intent = new Intent(context, TambahDataActivity.class);
                intent.putExtra("data", modelMahasiswa);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Yakin ingin menghapus data ?");
                alertDialog.setMessage("Hapus Data")
                        .setCancelable(false)
                        .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Proses Delete Data
                                deleteMahasiswa(i);
                            }
                        });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

//                alertDialog.create().show();
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama, txtNim, txtAlamat;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txt_nama);
            txtNim = itemView.findViewById(R.id.txt_nim);
            txtAlamat = itemView.findViewById(R.id.txt_alamat);
        }
    }

    public void deleteMahasiswa(int position){
        db.mahasiswaDao().deleteMahasiswa(listMahasiswa.get(position));
        listMahasiswa.remove(position);

        // untuk memberitahu ke layout recycler view bahwa ada data yang berubah
        notifyItemChanged(position);

        // untuk memberitahu ke layout recycler view bahwa index position berubah
        notifyItemRangeChanged(position, listMahasiswa.size());
    }


}
