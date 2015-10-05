package test.com.daggerexample.daggerStuff;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.com.daggerexample.DaggerApplication;
import test.com.daggerexample.model.UserDetails;

/**
 * Created by shivam on 8/21/15.
 */

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    UserDetails provideUserDetails() {
        //return already created object or create new object here.
        return ((DaggerApplication) mApplication).getUserDetails();
    }


    @Provides
    @Singleton
    DaggerApplication provideDaggerApplication() {
        return (DaggerApplication) mApplication;
    }


    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideAppSharedPreferences(){
        SharedPreferences sharedPreferences = mApplication.getSharedPreferences("dagger",
                Context.MODE_PRIVATE);
        return sharedPreferences;
    }

}
