package com.adidharmawati.belajarroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adidharmawati.belajarroom.R;
import com.adidharmawati.belajarroom.database.entity.mahasiswa;

import java.util.List;

public class mahasiswaAdapter extends RecyclerView.Adapter<mahasiswaAdapter.viewAdapter>{

    private List<mahasiswa> list;
    private Context context;

    public mahasiswaAdapter(Context context, List<mahasiswa> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahasiswa, parent, false);

        return new viewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewAdapter holder, int position) {
        holder.tvNama.setText(list.get(position).nama);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewAdapter extends RecyclerView.ViewHolder{

        TextView tvNama;

        public viewAdapter(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
        }
    }
}
