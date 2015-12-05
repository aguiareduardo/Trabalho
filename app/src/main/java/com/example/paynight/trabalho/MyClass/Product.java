package com.example.paynight.trabalho.MyClass;

import android.app.Application;

public class Product
{
        String _nome;
        String _detalhe;

        public Product(String nome, String detalhe) {
                _nome  = nome;
                _detalhe = detalhe;
        }

        public Product()
        {}

        public String getNome()
        {
                return _nome;
        }
        public void setNome(String value){_nome = value;}

    public String getDetalhe(){return _detalhe;}
    public void setDetalhe(String value){_detalhe = value;}
}
