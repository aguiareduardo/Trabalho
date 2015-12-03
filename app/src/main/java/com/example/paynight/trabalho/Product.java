package com.example.paynight.trabalho;

import android.app.Application;

public class Product
{
        String _nome;

        public Product(String nome) {
                _nome  = nome;
        }

        String getNome()
        {
                return _nome;
        }

        void setNome(String value)
        {
                _nome = value;
        }
}
