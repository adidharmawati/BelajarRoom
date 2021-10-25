package com.adidharmawati.belajarroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adidharmawati.belajarroom.adapter.mahasiswaAdapter;
import com.adidharmawati.belajarroom.database.AppDatabase;
import com.adidharmawati.belajarroom.database.entity.mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    private Button btnTambah;
    private AppDatabase database;
    private mahasiswaAdapter mahasiswaAdapter;
    private List<mahasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = findViewById(R.id.btn_tambah);
        rvMahasiswa= findViewById(R.id.rv_mahasiswa);

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.mahasiswaDao().getAll());
        mahasiswaAdapter = new mahasiswaAdapter(getApplicationContext(), list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false);
        rvMahasiswa.setLayoutManager(layoutManager);
        rvMahasiswa.setAdapter(mahasiswaAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TambahActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.mahasiswaDao().getAll());
        mahasiswaAdapter.notifyDataSetChanged();
    }
}