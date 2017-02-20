package com.jll.zoro.rxjava_retrofit;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;


/**
 * @Author : Zoro.
 * @Date : 2017/2/15.
 * @Describe :
 */

public class LoadDialog {
    public Dialog dialog;

    public LoadDialog(Context context) {
        this(context, null);
    }

    public LoadDialog(Context context, String message) {
        this.dialog = new Dialog(context, R.style.Dialog);
        this.dialog.setContentView(R.layout.loaddialog);
        WaveDrawable mWaveDrawable = new WaveDrawable(context, R.mipmap.ic_launcher);
        ImageView loadImage = (ImageView) dialog.findViewById(R.id.loadImage);
        loadImage.setImageDrawable(mWaveDrawable);
        mWaveDrawable.setIndeterminate(true);
//        this.dialog.setCancelable(true);
    }

    public void start() {
        this.dialog.show();
    }

    public void stop() {
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog.cancel();
        }
    }
}
