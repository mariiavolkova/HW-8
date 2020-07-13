package main.java.com.volkova.executor;

import main.java.com.volkova.user.User;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Executor {
    public static void start(){
        List<User> usersFromUkraine = asList(
                new User("Vasia", 16, "Dnipro"),
                new User("Petya", 23, "Dnipro"),
                new User("Elena", 42, "Lutsk"),
                new User("Elena", 92, "Chernihiv"),
                new User("Sergiy", 5, "Kyiv"),
                new User("Marina", 32, "Kyiv"),
                new User("Ivan Ivanovich",69,"Lviv"));

        printUserOlder40(usersFromUkraine);
        printUserYounger50FromDnipro(usersFromUkraine, "Dnipro");
        printUserAverageAgeLviv(usersFromUkraine, "Lviv");
        printUserNotFromKyiv(usersFromUkraine, "Kyiv");
        printSortedByAgeFirst3Elements(usersFromUkraine, 3);
    }

    private static void printUserOlder40(List<User> users) {
        System.out.println("Users older than 40 is: ");
        users.stream()
                .filter(user -> user.getAge() > 40)
                .forEach(System.out::println);
    }

    private static void printUserYounger50FromDnipro(List<User> users, String city) {
        System.out.println("Users younger than 50 from Dnipro is: ");
        users.stream()
                .filter(user -> user.getAge() < 50)
                .filter(user -> user.getCity().equals(city))
                .forEach(System.out::println);
    }

    private static void printUserAverageAgeLviv(List<User> users, String city) {
        System.out.println("Average age of Users from Lviv is: ");
        System.out.println(
                users.stream()
                        .filter(user -> user.getCity().equals(city))
                        .mapToInt(User::getAge)
                        .average()
                        .getAsDouble());
    }

    private static void printUserNotFromKyiv(List<User> users, String city) {
        System.out.println("Number of users not from Kyiv: ");
        System.out.println(
                users.stream()
                        .filter(user -> !user.getCity().equals(city))
                        .count());
    }

    private static void printSortedByAgeFirst3Elements(List<User> users, int count) {
        System.out.println("3 smallest user is: ");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(count)
                .forEach(System.out::println);
    }
}
