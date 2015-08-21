package test.com.daggerexample.model;

/**
 * Created by shivam on 8/21/15.
 */
public class UserDetails {

    private int id;
    private String name;
    private double income;


    public UserDetails(int id) {
        this.id = id;
    }

    public UserDetails(int id, String name, double income) {
        this.id = id;
        this.name = name;
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
