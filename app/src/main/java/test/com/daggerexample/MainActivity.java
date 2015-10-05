package test.com.daggerexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import test.com.daggerexample.model.UserDetails;

public class MainActivity extends AppCompatActivity {

    private static  final  String TAG = MainActivity.class.getSimpleName();

    @Inject
    UserDetails mUserDetails;

    @Inject
    DaggerApplication mDaggerApplication;

    @Inject
    SharedPreferences mAppPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("before injecting -it must be null mDaggerApplication  is ", "" + mDaggerApplication);

        ((DaggerApplication) getApplication()).mApplicationComponent.inject(this);

        Log.d("after injecting -  DaggerApplication  is ", "" + mDaggerApplication.getUserDetails
                ().getName());

        Log.d("user id is  ", "" + mUserDetails.getId());

        if (mAppPreferences.getBoolean("first_time", true)) {
            SharedPreferences.Editor editor = mAppPreferences.edit();
            editor.putBoolean("first_time", false);
            editor.apply();
            Log.d(TAG, "This is first time");

        } else {
            Log.d(TAG, "This isn't first time");
        }


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, new GreetFragment());
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}