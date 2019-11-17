package com.diozaas.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.diozaas.roomdatabase.model.ModelMahasiswa;

import java.util.List;

// DAO adalah Data Annotation Object
// interface hanya untuk method
@Dao
public interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(ModelMahasiswa modelMahasiswa);

    @Query("SELECT * FROM tb_mahasiswa")
    List<ModelMahasiswa> getMahasiswa();

    @Update
    int updateMahasiswa(ModelMahasiswa modelMahasiswa);

    @Delete
    int deleteMahasiswa(ModelMahasiswa modelMahasiswa);

    @Query("SELECT * FROM tb_mahasiswa WHERE idMahasiswa = :id")
    ModelMahasiswa detailMahasiswa(int id);

}
