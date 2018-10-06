package webix.example.skalim.contest11;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SampleFragment extends Fragment {
    int p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container,
                false);
        ImageView image = (ImageView) rootView.findViewById(R.id.banner);
        return rootView;
    }
}
