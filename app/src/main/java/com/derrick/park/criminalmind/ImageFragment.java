package com.derrick.park.criminalmind;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by madoka on 2017/07/12.
 */

public class ImageFragment extends DialogFragment {
    public static final String EXTRA_IMAGE_PATH ="path";

    public static ImageFragment createInstance(String imagePath){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_IMAGE_PATH, imagePath);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE,0);

        return fragment;
    }

    private ImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,  Bundle savedInstanceState) {
        mImageView = new ImageView(getActivity());
        String path = (String)getArguments().getSerializable(EXTRA_IMAGE_PATH);
        Bitmap image = PictureUtils.getScaleBitmap(path, getActivity());

        mImageView.setImageBitmap(image);

        return mImageView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PictureUtils.cleanImageView(mImageView);
    }
}
