package net.shannanshuibei.shannanandroid;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TabViewpagerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = TabViewpagerActivity.class.getName();

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<>();

    //Tabs
    private LinearLayout mTabIndex;
    private LinearLayout mTabFilm;
    private LinearLayout mTabVideo;
    private LinearLayout mTabSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "--> onCreate");

        setContentView(R.layout.activity_tab_viewpager);

        initView();
        initEvents();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "--> onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "--> onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "--> onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "--> onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "--> onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "--> onRestart");
        super.onRestart();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.tab_viewpager);

        //Tabs
        mTabIndex = (LinearLayout) findViewById(R.id.id_tab_index);
        mTabFilm = (LinearLayout) findViewById(R.id.id_tab_film);
        mTabVideo = (LinearLayout) findViewById(R.id.id_tab_video);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View view4TabIndex = mInflater.inflate(R.layout.view_4_tab_index, null);
        View view4tabFilm = mInflater.inflate(R.layout.view_4_tab_film, null);
        View view4tabVideo = mInflater.inflate(R.layout.view_4_tab_video, null);
        View view4tabSetting = mInflater.inflate(R.layout.view_4_tab_setting, null);

        mViews.add(view4TabIndex);
        mViews.add(view4tabFilm);
        mViews.add(view4tabVideo);
        mViews.add(view4tabSetting);

        mPagerAdapter = new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initEvents() {
        mTabIndex.setOnClickListener(this);
        mTabFilm.setOnClickListener(this);
        mTabVideo.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_index:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_film:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_video:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.id_tab_setting:
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

}
