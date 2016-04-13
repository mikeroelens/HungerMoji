package com.mikeroelens.hungermoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikeroelens.hungermoji.R;
import com.mikeroelens.hungermoji.utils.Utils;

//TODO: see if we can properly make this extend RelativeLayout
public class ScoreKeeperIcon {
    private int score = 0;
    TextView txtScore;
    TextView txtDelta;
    View v;
    Context mContext;

    public ScoreKeeperIcon(Context context) {
        mContext = context;
        v = LayoutInflater.from(context).inflate(R.layout.score_keeper_icon, null);
        txtScore = (TextView) v.findViewById(R.id.txtScore);
        txtDelta = (TextView) v.findViewById(R.id.txtDelta);
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int delta){
        score += delta;
        txtScore.setText(Integer.toString(score));
    }

    public void updateDelta(int delta){
        if (delta > 0 ) {
            txtDelta.setTextColor(mContext.getResources().getColor(R.color.green));
            txtDelta.setText("+" + delta);
        }
        else if (delta < 0) {
            txtDelta.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_light));
            txtDelta.setText(Integer.toString(delta));
        }

        txtDelta.setVisibility(View.VISIBLE);
    }


    public Bitmap generateBitmap() {
        v.measure(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        Bitmap bitmap = Bitmap.createBitmap(Utils.dpToPixels(mContext, 32), Utils.dpToPixels(mContext, 32), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        v.draw(c);

        return bitmap;
    }

    public void removeDelta() {
        txtDelta.setVisibility(View.GONE);
    }
}
