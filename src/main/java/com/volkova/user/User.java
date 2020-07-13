package main.java.com.volkova.user;

public class User {
    private String name;
    private int age;
    private String city;

    public User(String name, int age, String city){
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCity(){
        return city;
    }

    @Override
    public String toString(){
        return "User " + getName() + " have " + getAge() +" years old. " + "City: " +getCity();
    }
}