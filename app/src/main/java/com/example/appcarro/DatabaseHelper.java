package com.example.appcarro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context) {
        super(context, "DBCarro.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tbUsuario(login text primary key,email text, senha text)");
        db.execSQL("create table tbCarros(id integer primary key autoincrement,nome text,placa text,ano text,valor text,compra text,descricao text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbUsuario");
        db.execSQL("drop table if exists tbCarros");
    }

    public boolean insertLogin(String login, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("login", login);
        contentValues.put("email", email);
        contentValues.put("senha", senha);

        long inserido = db.insert("tbUsuario", null, contentValues);
        if (inserido == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertCarro(String nome, String placa, String ano, String valor, String compra, String descricao) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("placa", placa);
        contentValues.put("ano", ano);
        contentValues.put("valor", valor);
        contentValues.put("compra", compra);
        contentValues.put("descricao", descricao);

        long inserido = db.insert("tbCarros", null, contentValues);
        if (inserido == 1) {
            return true;
        } else {
            return false;
        }
    }


    public boolean validarLogin(String login) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tbUsuario where login = ?", new String[]{login});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarEmail(String email) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tbUsuario where login = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }


    public boolean validarUsuario(String login, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbUsuario where login = ? and senha = ?", new String[]{login, senha});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void preencherLista(List<Carros> lista) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from tbCarros", null);
        if (cursor.moveToFirst()) {
            do {
                Carros carros = new Carros();
                carros.setNome(cursor.getString(1));
                carros.setPlaca(cursor.getString(2));
                carros.setAno(cursor.getString(3));
                carros.setValor(cursor.getString(4));
                carros.setData(cursor.getString(5));
                carros.setDescricao(cursor.getString(6));

                lista.add(carros);

            } while (cursor.moveToNext());


        }


    }


    public void deletaCarro(List<Carros> lista) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "DELETE FROM tbCarros WHERE id = ?";
        Carros carros = new Carros();
        db.execSQL(sql, new Integer[]{carros.getId()});

    }




    public void recarregarCarros(List<Carros> lista) {
        SQLiteDatabase db = this.getReadableDatabase();
        lista.clear();
        Cursor cursor = db.rawQuery("SELECT * from tbCarros", null);
        if (cursor.moveToFirst()) {
            do {
                Carros carros = new Carros();
                carros.setNome(cursor.getString(1));
                carros.setPlaca(cursor.getString(2));
                carros.setAno(cursor.getString(3));
                carros.setValor(cursor.getString(4));
                carros.setData(cursor.getString(5));
                carros.setDescricao(cursor.getString(6));

                lista.add(carros);

            } while (cursor.moveToNext());
            cursor.close();


        }


    }


}
