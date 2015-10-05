# Dagger2Example

Android Dagger 2 

How to use Dagger 2 in android 

Dependency injection is a way to separate configuration process (object creation) from it's usage.


- Usage side (e.g. Activities, Fragments, Views)
 get here the object you need (simply annotating with @Inject), don't create object here

- Configuration Side
  - Easier mocking for testing and variants
  - Reduces code duplication 
  - Easy singleton management



Useful annotations in Dagger


@Module (for class )- for the classes whose methods provide dependencies

@Provides (for methods inside model class)- for the specific methods within @Module classes
	-   return already created object or create new object here.


@Component (interface )- is a collection of modules that can perform injection
Contains list of module classes and list of all classes  which are dependent on those module classes.  
Basically, it's the glue between the Module and the injection points, first by configuring what modules and other components it depends on, then by listing the explicit classes it can be used to inject.


@Inject - To request a dependency. (It can be used with a constructor argument, or a field)

@Singleton and custom scopes to define singletons within specific scopes. (you can create custom scopes like @PerApp or @PerActivity for clarity of how long a "singleton" lives for)



General Procedure .


1) Create class Module class 
e.g 

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

  
    @Provides
    @Singleton
    SharedPreferences provideAppSharedPreferences(){
        SharedPreferences sharedPreferences = mApplication.getSharedPreferences("dagger",
                Context.MODE_PRIVATE);
        return sharedPreferences;
    }

}



2) Add Component interface.
  -  add name of module classes.  
  -  inject all dependent classes.

e.g 

@Singleton
@Component( modules = ApplicationModule.class ) // name of module class which will provide dependency.
public interface ApplicationComponent {

    //inject classes which are dependent on ApplicationModule.
    void inject(MainActivity mainActivity);
    void inject(GreetFragment greetFragment);
}




3) initialize component in application class

mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();


4) In Activity or class where you want to access sharedPreferences object.

- declare object using 
@Inject SharedPreferences sharedPreferences;

5) Injection
Dependencies are used or "injected" through the "inject()" functions of component object.

e.g

 ((DaggerApplication) getApplication()).mApplicationComponent.inject(this);


