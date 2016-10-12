package spfworld.spfworld.custom;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by guozhengke on 2016/10/8.
 * 鱼游动动画
 */
public class FishAnimation {
    public void fish(ImageView imageView, final int mTransDuration, final int mAlphaDuration){
        AnimationSet set = new AnimationSet(false);
        set.setRepeatMode(Animation.RESTART);
        TranslateAnimation translateAnimation = new TranslateAnimation(1200,0,0,0);
        translateAnimation.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float arg0) {
                float ret = arg0 / (1.0f * mTransDuration / (mTransDuration + mAlphaDuration));
                return ret < 1 ? ret : 1;
            }
        });
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setDuration(mTransDuration + mAlphaDuration);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setDuration(mAlphaDuration);
        alphaAnimation.setStartOffset(mTransDuration);
        set.addAnimation(translateAnimation);
        set.addAnimation(alphaAnimation);
        imageView.startAnimation(set);
    }
}
