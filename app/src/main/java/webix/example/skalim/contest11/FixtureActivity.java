package webix.example.skalim.contest11;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


public class FixtureActivity extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fixture, container, false);


        ArrayList text1 = new ArrayList<>(Arrays.asList("IND","AUS","BAN","PAK"));
        ArrayList text3 = new ArrayList<>(Arrays.asList("WID","ENG","ZIM","RSA"));

        int[] images1 = {R.drawable.india, R.drawable.aus, R.drawable.ban, R.drawable.pak};

        int[] images2 = {R.drawable.westind, R.drawable.eng, R.drawable.zim, R.drawable.southafr};

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        LiveAdapterClass customAdapter = new LiveAdapterClass(getActivity(), text1,text3,images1,images2);
        recyclerView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();

        return view;

    }
}