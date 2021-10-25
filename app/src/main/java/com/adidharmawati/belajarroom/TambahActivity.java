package com.adidharmawati.belajarroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adidharmawati.belajarroom.database.AppDatabase;
import com.adidharmawati.belajarroom.database.entity.mahasiswa;

public class TambahActivity extends AppCompatActivity {

    private EditText etNama, etNim;
    private Button btnSimpan;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama=findViewById(R.id.et_nama);
        etNim=findViewById(R.id.et_nim);
        btnSimpan =findViewById(R.id.btn_simpan);

        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mahasiswa mahasiswa = new mahasiswa();
//                mahasiswa.nim = Integer.parseInt(etNim.getText().toString());
//                mahasiswa.nama = etNama.getText().toString();
                database.mahasiswaDao().insertAll(Integer.parseInt(etNim.getText().toString()), etNama.getText().toString());
                finish();
            }
        });
    }
}