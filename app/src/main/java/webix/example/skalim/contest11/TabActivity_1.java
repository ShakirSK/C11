package webix.example.skalim.contest11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabActivity_1 extends Activity {

     RecyclerView recyclerView;
    @BindView(R.id.backarrow)
    ImageView backarrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_activity_1);
        ButterKnife.bind(this);
     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        toolbar.setTitle("UP COMING MATCH");*/
/*
        toolbar.setNavigationIcon(R.drawable.ic_left);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/

        // ArrayList for person names
        ArrayList text1 = new ArrayList<>(Arrays.asList("IND","AUS","BAN","PAK"));
        ArrayList text3 = new ArrayList<>(Arrays.asList("WID","ENG","ZIM","RSA"));

        int[] images1 = {R.drawable.india, R.drawable.aus, R.drawable.ban, R.drawable.pak};

        int[] images2 = {R.drawable.westind, R.drawable.eng, R.drawable.zim, R.drawable.southafr};

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        FragmentAdapterClass customAdapter = new FragmentAdapterClass(getApplicationContext(), text1,text3,images1,images2);
        recyclerView.setAdapter(customAdapter);


  /*      Button backButton = (Button)findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
*/
    }


    @OnClick({R.id.backarrow})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.backarrow:
                startActivity(new Intent(TabActivity_1.this, MainActivity.class));
                finish();
                break;

        }
    }




}
