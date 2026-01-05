package ru.kaiten.api;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getUserRoleFaker(){

        return faker.job().title();
    }
}