package com.adidharmawati.belajarroom.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.adidharmawati.belajarroom.database.entity.mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<mahasiswa> getAll();

    @Query("INSERT INTO mahasiswa (nim,nama) VALUES(:nim, :nama)")
    void insertAll(int nim, String nama );

}
