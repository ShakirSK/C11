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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabActivity_4 extends Activity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_activity_2);
    /*    Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        //toolbar.setTitle("UP COMING MATCH");

        toolbar.setNavigationIcon(R.drawable.ic_left);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/


        Intent i=getIntent();

        final String first =i.getExtras().getString("first");
        final String second=i.getExtras().getString("second");

        // ArrayList for person names
       // ArrayList text1 = new ArrayList<>(Arrays.asList("INDIA","ENGLAND","SRILANKA"));
       // ArrayList text3 = new ArrayList<>(Arrays.asList("PAKISTAN","INDIA","PAKISTAN"));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       // FragmentAdapterClass customAdapter = new FragmentAdapterClass(getApplicationContext(), first,second);
       // recyclerView.setAdapter(customAdapter);


  /*      Button backButton = (Button)findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
*/
    }





}
