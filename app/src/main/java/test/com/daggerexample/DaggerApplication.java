package test.com.daggerexample;

import android.app.Application;
import android.content.Context;

import test.com.daggerexample.daggerStuff.ApplicationComponent;
import test.com.daggerexample.daggerStuff.ApplicationModule;
import test.com.daggerexample.daggerStuff.DaggerApplicationComponent;
import test.com.daggerexample.model.UserDetails;

/**
 * Created by shivam on 8/21/15.
 */
public class DaggerApplication extends Application {

    ApplicationComponent mApplicationComponent = null;

    private UserDetails mUserDetails = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mUserDetails = new UserDetails(20);
        mUserDetails.setName("Demo");
    }

    public UserDetails getUserDetails() {
        return mUserDetails;
    }

    public static ApplicationComponent getApplicationComponent(Context context){
        return ((DaggerApplication) context.getApplicationContext()).mApplicationComponent;
    }

}
