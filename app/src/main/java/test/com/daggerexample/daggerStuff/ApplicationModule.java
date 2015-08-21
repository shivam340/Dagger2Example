package test.com.daggerexample.daggerStuff;

import android.app.Application;

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

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides @Singleton
    UserDetails provideUserDetails(){
        return ((DaggerApplication) mApplication).getUserDetails();
    }

}
