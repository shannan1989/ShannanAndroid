package net.shannanshuibei.shannanandroid;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlipCardActivity extends AppCompatActivity {

    @BindView(R.id.main_fl_container)
    FrameLayout mFlContainer;

    @BindView(R.id.main_fl_card_front)
    FrameLayout mFlCardFront;

    @BindView(R.id.main_fl_card_back)
    FrameLayout mFlCardBack;

    private AnimatorSet mRightOutSet;
    private AnimatorSet mLeftInSet;

    private boolean mIsShowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_card);

        ButterKnife.bind(this);

        this.setAnimators();
        setCameraDistance();
    }

    /**
     * 设置动画
     */
    private void setAnimators() {
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_flip_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_flip_in);

        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

                mFlContainer.setClickable(false);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                mFlContainer.setClickable(true);
            }
        });
    }

    /**
     * 改变视角距离，贴近屏幕
     */
    private void setCameraDistance() {
        int distance = 16000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mFlCardFront.setCameraDistance(scale);
        //mFlCardBack.setCameraDistance(scale);
    }

    /**
     * 翻转卡片
     *
     * @param view View
     */
    public void flipCard(View view) {
        if (!mIsShowBack) {//正面朝上
            mRightOutSet.setTarget(mFlCardFront);
            mLeftInSet.setTarget(mFlCardBack);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = true;
        } else {//背面朝上
            mRightOutSet.setTarget(mFlCardBack);
            mLeftInSet.setTarget(mFlCardFront);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = true;
        }
    }
}
