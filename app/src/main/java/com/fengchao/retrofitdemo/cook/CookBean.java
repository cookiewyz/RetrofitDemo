package com.fengchao.retrofitdemo.cook;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wyz on 16/11/25.
 */

public class CookBean {
    @SerializedName("title")
    private String title;
    @SerializedName("imtro")
    private String imtro;
    @SerializedName("albums")
    private List<String> albums;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImtro() {
        return imtro;
    }

    public void setImtro(String imtro) {
        this.imtro = imtro;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView,String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}
