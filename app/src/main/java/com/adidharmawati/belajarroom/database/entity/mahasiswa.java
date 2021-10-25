package com.adidharmawati.belajarroom.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class mahasiswa {
    @PrimaryKey
    public int nim;

    public String nama;
}
