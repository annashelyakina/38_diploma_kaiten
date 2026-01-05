package ru.kaiten.api;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Objects;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getUserRoleFaker(){

        return faker.job().title();
    }

//
//    public static String getDay(){
//
//        return String.format("%s", faker.number().numberBetween(1, 28));
//    }
//
//    public static String getMonth(){
//
//        return  faker.options().option("January", "February", "March", "April",
//                "May", "June", "July", "August", "September", "October", "November", "December");
//    }
//
//    public static String getYear(){
//
//        return String.format("%s", faker.number().numberBetween(1950, 2024));
//    }

}