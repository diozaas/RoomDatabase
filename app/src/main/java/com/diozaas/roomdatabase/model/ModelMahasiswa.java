package com.diozaas.roomdatabase.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// implements Serializable karena pada intent untuk Detail Mahasiswa mengirimkan data seluruhnya, dalam satu paket class
@Entity(tableName = "tb_mahasiswa")
public class ModelMahasiswa implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idMahasiswa;

    @ColumnInfo(name = "nama")
    String nama;

    @ColumnInfo(name = "nim")
    int nim;

    @ColumnInfo(name = "alamat")
    String alamat;

    public ModelMahasiswa(int nim, String nama, String alamat) {
//        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
