package com.codepath.apps.restclienttemplate;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class BindingAdapterUtils {
    static int radius = 30; // corner radius, higher value = more rounded
    static int margin = 10; // crop margin, set to 0 for corners with no crop
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        if(view.getId() == R.id.ivProfileImage) {
            Glide.with(view.getContext()).load(url).transform(new CircleCrop()).into(view);
        }
        if(view.getId() == R.id.ivMedia) {
            Glide.with(view.getContext()).load(url).transform(new RoundedCornersTransformation(radius, margin)).into(view);
        }
    }
}