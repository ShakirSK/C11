package webix.example.skalim.contest11;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import webix.example.skalim.contest11.Adater.MyPagerAdapter;

public class CreateTeamMainActivity extends AppCompatActivity {
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"BAT", "BOWL", "WK", "AR"};

    private final String[] mTitlfdfdes = {"sachin", "kohli", "manish", "dhoni"};

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team_main);

    initFragments();
        initViewPager();
        mImageArray = new int[]{
                R.drawable.slider4,
                R.drawable.slider2,
                R.drawable.slider3,
                R.drawable.allrounder};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTranslucentStatusBar(this)
                .setTitle("CREATE YOUR TEAM")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);

    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            Log.d("mFragments", String.valueOf(MainFragment.getInstance(title)));
            mFragments.add(MainFragment.getInstance(title));
        }
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

      /*  switch (item.getItemId()) {
            case R.id.action_about:
                IntentUtils.openUrl(this, "https://github.com/hugeterry/CoordinatorTabLayout");
                break;
            case R.id.action_about_me:
                IntentUtils.openUrl(this, "http://hugeterry.cn/about");
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
