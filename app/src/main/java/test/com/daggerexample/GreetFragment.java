package test.com.daggerexample;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * Created by shivam on 10/5/15.
 */
public class GreetFragment extends Fragment {

    @Inject
    SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_greet, container, false);

        TextView textView = (TextView) view.findViewById(R.id.greet_message);

        DaggerApplication.getApplicationComponent(getActivity()).inject(this);
        if(mSharedPreferences.getBoolean("first_time", true)){
            textView.setText("Welcome.");
        }else {
            textView.setText("Welcome Again.");
        }

        return view;
    }
}
