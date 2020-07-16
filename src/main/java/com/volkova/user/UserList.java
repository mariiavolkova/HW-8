package main.java.com.volkova.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class UserList {
    final static String city1 = "Dnipro";
    final static String city2 = "Lviv";
    final static String city3 = "Kyiv";

    final static int count = 3;
    final static int midAge = 40;
    final static int highAge = 50;

    public static void UserImpl(){

    List<User> list = new ArrayList<>();
            list.add(new User("Vasia", 16, "Dnipro"));
            list.add(new User("Petya", 23, "Dnipro"));
            list.add(new User("Elena", 42, "Lutsk"));
            list.add(new User("Elena", 92, "Chernihiv"));
            list.add(new User("Sergiy", 5, "Kyiv"));
            list.add(new User("Marina", 32, "Kyiv"));
            list.add(new User("Ivan Ivanovich",69,"Lviv"));

        System.out.println("This is a list of User older than " +midAge);
        printUserOlderAge(list);

        System.out.println("This is a list of User from " +city1 +" older than " +highAge);
        printUserYoungerAgeFromCity(list, city1);

        System.out.println("This is the average age of User from " +city2);
        printUserAverageAgeFromCity(list, city2);

        System.out.println("This is a list of User not from Kyiv "+city3);
        printUserNotFromCity(list, city3);

        System.out.println("This is a list of a " +count+ " smallest User");
        printSortedByAge(list, count);
    }

    public static void printUserOlderAge(List<User> users) {
        System.out.println("User older than " +midAge);
        users.stream()
                .filter(user -> user.getAge() > midAge)
                .forEach(System.out::println);
    }

    public static void printUserYoungerAgeFromCity(List<User> users, String city1) {
        System.out.println("Users younger tnan " +highAge+ " from "+city1);
        users.stream()
                .filter(user -> user.getAge() < highAge)
                .filter(user -> user.getCity().equals(city1))
                .forEach(System.out::println);
    }

    public static void printUserAverageAgeFromCity(List<User> users, String city2) {
        System.out.println("Average age of Users from "+city2+" :");
        System.out.println(
                users.stream()
                        .filter(user -> user.getCity().equals(city2))
                        .mapToInt(User::getAge)
                        .average()
                        .getAsDouble());
    }

    public static void printUserNotFromCity(List<User> users, String city3) {
        System.out.println("Number of users not from "+ city3);
        System.out.println(
                users.stream()
                        .filter(user -> !user.getCity().equals(city3))
                        .count());
    }

    public static void printSortedByAge(List<User> users, int count){
        System.out.println(count+ " smallest user is: ");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(count)
                .forEach(System.out::println);
    }
}