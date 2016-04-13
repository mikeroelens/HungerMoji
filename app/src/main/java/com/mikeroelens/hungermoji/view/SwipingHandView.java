package com.mikeroelens.hungermoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.mikeroelens.hungermoji.R;

public class SwipingHandView extends ImageView {
    private Animation animation;

    public SwipingHandView(Context context) {
        super(context);
        init(context);
    }

    public SwipingHandView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SwipingHandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setAlpha(0); //TODO: must be better way to hide image, setVisibility doesn't seem to be working
        setImageDrawable(context.getResources().getDrawable(R.drawable.hand));

        animation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.15f);
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setInterpolator(new AnticipateInterpolator(0.5f));
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setAlpha(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void show() {
        setAlpha(255);
        setAnimation(animation);
        animation.start();
    }

    public void hide() {
        animation.cancel();
    }
}
