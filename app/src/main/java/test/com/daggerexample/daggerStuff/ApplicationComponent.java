package test.com.daggerexample.daggerStuff;

import javax.inject.Singleton;

import dagger.Component;
import test.com.daggerexample.GreetFragment;
import test.com.daggerexample.MainActivity;
import test.com.daggerexample.model.UserDetails;

/**
 * Created by shivam on 8/21/15.
 */

@Singleton
@Component( modules = ApplicationModule.class )
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(GreetFragment greetFragment);

    UserDetails getUser();
}
