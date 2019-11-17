package com.diozaas.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.diozaas.roomdatabase.model.ModelMahasiswa;

import java.util.List;

// DAO adalah Data Annotation Object
// interface hanya untuk method
@Dao
public interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(ModelMahasiswa modelMahasiswa);

}
