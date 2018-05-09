package com.skylist.android_teste;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ModelRecycleView {

    private String nome, materia, instituicao, data, URLimage;
    private ImageView image;

    ModelRecycleView(){}

    ModelRecycleView(String nome, String materia, String instituicao, String data, String urlImage ){
        this.nome = nome;
        this.materia = materia;
        this.instituicao = instituicao;
        this.data = data;
        this.URLimage = urlImage;
    }

    ModelRecycleView( String qrCodeRes[] ){
        this.nome = qrCodeRes[0];
        this.materia = qrCodeRes[1];
        this.URLimage = qrCodeRes[2];
        this.data = qrCodeRes[3];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrlImage() {
        return URLimage;
    }

    public void setUrlImage(String URLImage) {
        this.URLimage = URLImage;
    }

}
