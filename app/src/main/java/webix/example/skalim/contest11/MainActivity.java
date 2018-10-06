package webix.example.skalim.contest11;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import webix.example.skalim.contest11.SplashScreen;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
       {
           int currentPage = 0,i=0;
           Timer timer;
           ImageView banner;
           Toolbar toolbar;
           final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
           final long PERIOD_MS =2500; // time in milliseconds between successive task executions.


    //TabHost TabHostWindow;
    ViewPager pager,viewPager;
    RecyclerView recyclerView;
    //FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    FragmentAdapterClass fragmentAdapter ;
     ViewPager viewPagertab;
            FloatingActionButton fab;
            Animation rotation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool1);
        setSupportActionBar(toolbar);
       // ActionBar ab = getSupportActionBar();
       // ab.setDisplayHomeAsUpEnabled(true);
     /*   SplashScreen.Builder splash = new SplashScreen.Builder(this, getSupportActionBar());
        splash.perform();*/




        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Contest11");


       // final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       // getSupportActionBar().setTitle(null);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
      fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        rotation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.android_rotate_animation);
        rotation.setFillAfter(true);
        fab.startAnimation(rotation);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                   // startRotatingImage(v);
                //navigation.setVisibility(View.VISIBLE);
                        Intent intent=new Intent(getApplicationContext(),TabActivity_1.class);
                        startActivity(intent);
                        //fab.setImageResource(R.drawable.ic_remove_circle_outline_black_24dp);
                        i++;

            }
        });


       //viewpager visible by this line of code
        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.nest_scrollview);
        scrollView.setFillViewport(true);

     /*   final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

*/
        viewPagertab = (ViewPager) findViewById(R.id.viewpagerfortabc);
        setupViewPager(viewPagertab);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout1);
        tabLayout.setupWithViewPager(viewPagertab);
         }

           public void startRotatingImage(View view) {

               Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_animation);
               fab.startAnimation(startRotateAnimation);
           }

           private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                   = new BottomNavigationView.OnNavigationItemSelectedListener() {

               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment fragment;
                   switch (item.getItemId()) {
                       case R.id.navigation_home:
                           /*Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                           startActivity(intent);*/
                           return true;

                       case R.id.navigation_mycontest:

                          /* fragment = new mycontest();
                           loadFragment(fragment);*/
                           return true;

                       case R.id.navigation_me:
                           fragment = new mefragment();
                           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                           transaction.replace(R.id.layout2, fragment);

                           transaction.commit();
                           return true;

                       case R.id.navigation_more:
                           return true;
                   }
                   return false;
               }
           };
           private void loadFragment(Fragment fragment) {
               // load fragment
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
     transaction.replace(R.id.layout2, fragment);

               transaction.commit();
           }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new TabActivity_1(), "LIVE");
        adapter.addFragment(new TabActivity_2(), "LIVE");
        adapter.addFragment(new TabActivity_3(), "RESULTS");


        viewPager.setAdapter(adapter);
    }
        // for handle more than 3 item in bottom navigation
           public static class BottomNavigationViewHelper  {
               @SuppressLint("RestrictedApi")
               public static void disableShiftMode(BottomNavigationView view) {
                   BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
                   try {
                       Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                       shiftingMode.setAccessible(true);
                       shiftingMode.setBoolean(menuView, false);
                       shiftingMode.setAccessible(false);
                       for (int i = 0; i < menuView.getChildCount(); i++) {
                           BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                           //noinspection RestrictedApi
                           item.setShiftingMode(false);
                           // set once again checked value, so view will be updated
                           //noinspection RestrictedApi
                           item.setChecked(item.getItemData().isChecked());
                       }
                   } catch (NoSuchFieldException e) {
                       Log.e("BNVHelper", "Unable to get shift mode field", e);
                   } catch (IllegalAccessException e) {
                       Log.e("BNVHelper", "Unable to change value of shift mode", e);
                   }
               }
           }
//
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

 /*   @Override
    public void onBackPressed() {
            super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.contest_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //ImageView image = (ImageView) findViewById(R.id.banner);
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {

                return new SampleFragment();
            }
            if(position==1) {

                return new SampleFragmentTwo();
            }
            else
                return new SampleFragmentThree();

        }

        @Override
        public int getCount() {
            // Show  total pages.
            return 3;
        }
    }

}
