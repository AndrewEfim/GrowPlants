package com.neversaydie.andreii.growplants.presentation.util;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class MyAdapters {

    @BindingAdapter({"app:background"})
    public static void setImageViewResource(ImageView imageView, Drawable resource) {
        imageView.setBackground(resource);
    }
}
