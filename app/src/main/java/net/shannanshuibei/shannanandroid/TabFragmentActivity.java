package net.shannanshuibei.shannanandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

public class TabFragmentActivity extends FragmentActivity implements View.OnClickListener {

    //Tabs
    private LinearLayout mTabIndex;
    private LinearLayout mTabFilm;
    private LinearLayout mTabVideo;
    private LinearLayout mTabSetting;

    private Fragment view4TabIndex;
    private Fragment view4TabFilm;
    private Fragment view4TabVideo;
    private Fragment view4TabSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment);

        initView();
        initEvents();

        setSelected(0);
    }

    private void initView() {
        //Tabs
        mTabIndex = (LinearLayout) findViewById(R.id.id_tab_index);
        mTabFilm = (LinearLayout) findViewById(R.id.id_tab_film);
        mTabVideo = (LinearLayout) findViewById(R.id.id_tab_video);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);
    }

    private void initEvents() {
        mTabIndex.setOnClickListener(this);
        mTabFilm.setOnClickListener(this);
        mTabVideo.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tab_index:
                setSelected(0);
                break;
            case R.id.id_tab_film:
                setSelected(1);
                break;
            case R.id.id_tab_video:
                setSelected(2);
                break;
            case R.id.id_tab_setting:
                setSelected(3);
                break;
            default:
                break;
        }
    }

    private void setSelected(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        hideAllFragments(fragmentTransaction);
        switch (i) {
            case 0:
                if (view4TabIndex == null) {
                    view4TabIndex = new TabIndexFragment();
                    fragmentTransaction.add(R.id.id_fragment_container, view4TabIndex);
                } else {
                    fragmentTransaction.show(view4TabIndex);
                }
                break;
            case 1:
                if (view4TabFilm == null) {
                    view4TabFilm = new TabFilmFragment();
                    fragmentTransaction.add(R.id.id_fragment_container, view4TabFilm);
                } else {
                    fragmentTransaction.show(view4TabFilm);
                }
                break;
            case 2:
                if (view4TabVideo == null) {
                    view4TabVideo = new TabVideoFragment();
                    fragmentTransaction.add(R.id.id_fragment_container, view4TabVideo);
                } else {
                    fragmentTransaction.show(view4TabVideo);
                }
                break;
            case 3:
                if (view4TabSetting == null) {
                    view4TabSetting = new TabSettingFragment();
                    fragmentTransaction.add(R.id.id_fragment_container, view4TabSetting);
                } else {
                    fragmentTransaction.show(view4TabSetting);
                }
                break;
            default:
                break;
        }

        fragmentTransaction.commit();
    }

    private void hideAllFragments(FragmentTransaction fragmentTransaction) {
        if (view4TabIndex != null) {
            fragmentTransaction.hide(view4TabIndex);
        }
        if (view4TabFilm != null) {
            fragmentTransaction.hide(view4TabFilm);
        }
        if (view4TabVideo != null) {
            fragmentTransaction.hide(view4TabVideo);
        }
        if (view4TabSetting != null) {
            fragmentTransaction.hide(view4TabSetting);
        }
    }
}
