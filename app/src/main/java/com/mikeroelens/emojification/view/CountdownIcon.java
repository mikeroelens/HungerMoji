package com.mikeroelens.emojification.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.utils.Utils;

//TODO: see if we can properly make this extend RelativeLayout
//TODO: need to fix centering of view
public class CountdownIcon {
    private int count = 3;
    TextView txtCount;
    View v;
    Context mContext;

    public CountdownIcon(Context context) {
        mContext = context;
        v = LayoutInflater.from(context).inflate(R.layout.countdown_icon, null);
        txtCount = (TextView) v.findViewById(R.id.txtCount);
    }

    public Bitmap generateBitmap() {
        v.measure(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        Bitmap bitmap = Bitmap.createBitmap(Utils.dpToPixels(mContext, 32), Utils.dpToPixels(mContext, 32), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        v.draw(c);

        return bitmap;
    }

    public void decrementCount() {
        count -= 1;
        txtCount.setText(Integer.toString(count));
    }

    public int getCount() {
        return count;
    }
}
