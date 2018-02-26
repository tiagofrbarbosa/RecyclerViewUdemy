package io.github.tiagofrbarbosa.recyclerviewudemy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.tiagofrbarbosa.recyclerviewudemy.R;
import io.github.tiagofrbarbosa.recyclerviewudemy.model.Filme;

/**
 * Created by tfbarbosa on 26/02/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.mViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new mViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {

            Filme filme = listaFilmes.get(position);
            holder.titulo.setText(filme.getTituloFilme());
            holder.ano.setText(filme.getAno());
            holder.genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public mViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tv_titulo);
            ano = itemView.findViewById(R.id.tv_ano);
            genero = itemView.findViewById(R.id.tv_genero);
        }
    }
}
