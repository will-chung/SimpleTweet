package com.codepath.apps.restclienttemplate;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapterUtils {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
