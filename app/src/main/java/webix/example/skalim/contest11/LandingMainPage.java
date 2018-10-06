package webix.example.skalim.contest11;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.lang.reflect.Field;

public class LandingMainPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private TextView mTextMessage;
    //TabHost TabHostWindow;
    ViewPager pager,viewPager;
    RecyclerView recyclerView;
    //FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    FragmentAdapterClass fragmentAdapter ;
    ViewPager viewPagertab;
    FloatingActionButton fab;
    Animation rotation;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_main_page);

        //loading the default fragment
        loadFragment(new homefragment());


        //fab and viewpager banner
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        rotation = AnimationUtils.loadAnimation(LandingMainPage.this, R.anim.android_rotate_animation);
        rotation.setFillAfter(true);
        fab.startAnimation(rotation);


        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // startRotatingImage(v);
                //navigation.setVisibility(View.VISIBLE);
                Intent intent=new Intent(getApplicationContext(),TabActivity_1.class);
                startActivity(intent);
                //fab.setImageResource(R.drawable.ic_remove_circle_outline_black_24dp);
            }
        });



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {

            case R.id.navigation_home:
                fragment = new homefragment();
                break;

            case R.id.navigation_mycontest:
                fragment = new mycontest();
                break;

            case R.id.navigation_me:
                fragment = new mefragment();
                break;

            case R.id.navigation_more:
                fragment = new moreFragment();
                break;

        }

        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


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

    @Override
    public void onBackPressed() {
        if(loadFragment(new homefragment()))
        {
            finish();
        }
        else
        {
            loadFragment(new homefragment());
        }
      /*  if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }*/
    }
}
