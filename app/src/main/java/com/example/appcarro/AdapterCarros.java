package com.example.appcarro;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCarros extends RecyclerView.Adapter<AdapterCarros.ViewHolder> {

    Button btnExcluir;
    @NonNull
    @Override
    public AdapterCarros.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCarros.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TextView carro,placa,ano,valor,data,descricao;

            carro = itemView.findViewById(R.id.rvNome);
            placa = itemView.findViewById(R.id.rvPlaca);
            ano = itemView.findViewById(R.id.rvAno);
            valor = itemView.findViewById(R.id.rvValor);
            data = itemView.findViewById(R.id.rvData);
            descricao = itemView.findViewById(R.id.rvDescricao);


        }
    }
}
