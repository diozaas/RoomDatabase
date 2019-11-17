package com.diozaas.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.diozaas.roomdatabase.dao.MahasiswaDao;
import com.diozaas.roomdatabase.model.ModelMahasiswa;

@Database(entities = ModelMahasiswa.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();
}
