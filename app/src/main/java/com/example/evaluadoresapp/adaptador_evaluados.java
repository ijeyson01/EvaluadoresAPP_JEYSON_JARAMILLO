package com.example.evaluadoresapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adaptador_evaluados extends RecyclerView.Adapter<evaluadosviewholder>{
    private Context Ctx;
    private List<c_Evaluados> lstEvaluados;
    public adaptador_evaluados(Context mCtx, List<c_Evaluados> usuarios) {
        this.lstEvaluados = usuarios;
        Ctx=mCtx;
    }
    @Override
    public evaluadosviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_itemevaluados, null);
        //view.setOnClickListener(this);
        return new evaluadosviewholder(view);
    }

    @Override
    public void onBindViewHolder(evaluadosviewholder holder, int position) {
        c_Evaluados usuario = lstEvaluados.get(position);
        holder.nombre.setText(usuario.getNombreevaluado());
        holder.identificacion.setText(usuario.getIdevaluado());
        holder.situacion.setText(usuario.getSituacion());
        holder.genero.setText(usuario.getGenero());
        holder.cargo.setText(usuario.getCargo());
        holder.fechainicio.setText(usuario.getFechainicio());
        holder.fechafin.setText(usuario.getFechafin());

        Glide.with(Ctx)
                .load(usuario.getUrlimg1())
                .into(holder.avatarUrl);
    }

    @Override
    public int getItemCount() {
        final int size = lstEvaluados.size();
        return size;
    }
}
