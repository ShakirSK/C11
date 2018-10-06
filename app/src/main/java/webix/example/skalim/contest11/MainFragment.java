package webix.example.skalim.contest11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import webix.example.skalim.contest11.Adater.RecyclerAdapter;

/**
 * Created by hugeterry(http://hugeterry.cn)
 */
public class MainFragment extends Fragment {
    private RecyclerView mRecyclerView;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;

    public static MainFragment getInstance(String title) {
        MainFragment fra = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        Log.d("bundlefaf", String.valueOf( bundle.getString(ARG_TITLE)));
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_fragment, container, false);

        initData();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
       // mRecyclerView.setAdapter(new RecyclerAdapter(mRecyclerView.getContext(), mDatas ));
        ArrayList text1 = new ArrayList<>(Arrays.asList("sachin", "kohli", "manish", "dhoni","sachin", "kohli", "manish", "dhoni"));
        ArrayList text3 = new ArrayList<>(Arrays.asList("sachin", "kohli", "manish", "dhoni","sachin", "kohli", "manish", "dhoni"));

        int[] images1 = {R.drawable.india, R.drawable.aus, R.drawable.ban, R.drawable.pak};

        int[] images2 = {R.drawable.westind, R.drawable.eng, R.drawable.zim, R.drawable.southafr};



        RecyclerAdapter customAdapter = new RecyclerAdapter(getActivity(), text1,text3,images1,images2);
        mRecyclerView.setAdapter(customAdapter);
        return v;
    }
  //  private final String[] mTitles = {"BAT", "BOWL", "WK", "AR"};
    private void initData() {
        mDatas = new ArrayList<>();
      /*  for (int i = 'A'; i < 'z'; i++) {
            mDatas.add(mTitle + (char) i);
        }*/
        if("BAT".equals(mTitle))
        {
            String[] mTitlfdfdes = {"sachin", "kohli", "manish", "dhoni"};
            for (String title : mTitlfdfdes) {
                mDatas.add(title);
            }

        }
        else if("BOWL".equals(mTitle))
        {
            String[] mTitlfdfdes = {"sachin", "dhoni", "manish", "kohli"};
            for (String title : mTitlfdfdes) {
                mDatas.add(title);
            }
        }
        else if("WK".equals(mTitle))
        {
            String[] mTitlfdfdes = {"dhoni", "kohli", "manish", "dhoni"};
            for (String title : mTitlfdfdes) {
                mDatas.add(title);
            }
        }
        else if("AR".equals(mTitle))
        {
            String[] mTitlfdfdes = {"manish", "kohli", "sachin", "dhoni"};
            for (String title : mTitlfdfdes) {
                mDatas.add(title);
            }
        }
    }

}