package com.example.appcarro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Carros> listaCarros;

    public Adapter(List<Carros> lista){
        this.listaCarros = lista;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        Carros carros = listaCarros.get(position);
        holder.carro.setText(carros.getNome());
        holder.placa.setText(carros.getPlaca());
        holder.ano.setText(carros.getAno());
        holder.valor.setText(carros.getValor());
        holder.data.setText(carros.getData());
        holder.descricao.setText(carros.getDescricao());

    }

    @Override
    public int getItemCount() {
        return listaCarros.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carro,placa,ano,valor,data,descricao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            carro = itemView.findViewById(R.id.rvNome);
            placa = itemView.findViewById(R.id.rvPlaca);
            ano = itemView.findViewById(R.id.rvAno);
            valor = itemView.findViewById(R.id.rvValor);
            data = itemView.findViewById(R.id.rvData);
            descricao = itemView.findViewById(R.id.rvDescricao);

        }
    }
}
