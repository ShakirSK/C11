package webix.example.skalim.contest11;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

import cn.iwgang.countdownview.CountdownView;
import webix.example.skalim.contest11.Adater.ContestInnerAdapter;

public class Contest11InnerPage extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest11_inner_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("CONTESTS");
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        CountdownView mCvCountdownViewTest3 = (CountdownView)findViewById(R.id.cv_countdownViewTest3);
        long time3 = (long)9 * 60 * 60 * 1000;
        mCvCountdownViewTest3.start(time3);


        ArrayList text1 = new ArrayList<>(Arrays.asList("IND","AUS","BAN","PAK"));
        ArrayList text3 = new ArrayList<>(Arrays.asList("WID","ENG","ZIM","RSA"));

        int[] images1 = {R.drawable.india, R.drawable.aus, R.drawable.ban, R.drawable.pak};

        int[] images2 = {R.drawable.westind, R.drawable.eng, R.drawable.zim, R.drawable.southafr};

        recyclerView = (RecyclerView) findViewById(R.id.allcontest);

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(Contest11InnerPage.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        ContestInnerAdapter customAdapter = new ContestInnerAdapter(getApplicationContext(), text1,text3,images1,images2);
        recyclerView.setAdapter(customAdapter);
        /*  orderid = (TextView) findViewById(R.id.orderid);*/


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
