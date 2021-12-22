package com.example.evaluadoresapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class adaptador_evaluadores extends RecyclerView.Adapter<evaluadoresviewholder>
implements View.OnClickListener{
    private Context Ctx;
    private List<c_Evaluadores> lstEvaluadores;

    //public adaptador_evaluadores(Context context, ArrayList<c_Evaluadores> datos){
    //    super(context, R.layout.activity_main, datos);
    //}
    public adaptador_evaluadores(Context mCtx, List<c_Evaluadores> usuarios) {
        this.lstEvaluadores = usuarios;
        Ctx=mCtx;
    }

    @Override
    public evaluadoresviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_itemsevaluadores, null);
        view.setOnClickListener(this);
        return new evaluadoresviewholder(view);
    }

    @Override
    public int getItemCount() {
        final int size = lstEvaluadores.size();
        return size;
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.Listener =listener;
    }

    @Override
    public void onBindViewHolder(evaluadoresviewholder holder, int position) {
        c_Evaluadores usuario = lstEvaluadores.get(position);
        holder.textViewName.setText(usuario.getNombre());
        holder.textarea.setText(usuario.getArea());
        holder.textideEvaluador.setText(usuario.getIdEv());

        Glide.with(Ctx)
                .load(usuario.getUrlImg1())
                .into(holder.imageView)
        ;//(Drawable("https://evaladmin.uteq.edu.ec/adminimg/unknown.png"));


    }
    private View.OnClickListener Listener;
    @Override
    public void onClick(View v) {
        if (Listener != null){
            Listener.onClick(v);
        }
    }
}
