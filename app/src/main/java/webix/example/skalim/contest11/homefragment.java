package webix.example.skalim.contest11;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class homefragment extends Fragment {
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

    public homefragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.homefragment, container, false);

        //toolbar
        toolbar = (Toolbar) view.findViewById(R.id.tool1);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new SamplePagerAdapter(getChildFragmentManager()));
        pager.getAdapter().notifyDataSetChanged();

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout)view.findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Contest11");

        //viewpager visible by this line of code
        NestedScrollView scrollView = (NestedScrollView)view.findViewById (R.id.nest_scrollview);
        scrollView.setFillViewport(true);

        viewPagertab = (ViewPager)view.findViewById(R.id.viewpagerfortabc);
        setupViewPager(viewPagertab);

        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout1);
        tabLayout.setupWithViewPager(viewPagertab);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        //adapter.addFragment(new TabActivity_1(), "LIVE");
        adapter.addFragment(new TabActivity_2(), "LIVE");
        adapter.addFragment(new TabActivity_3(), "RESULTS");


        viewPager.setAdapter(adapter);
    }

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

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}


