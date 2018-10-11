package ru.interview.lessonFirst.person;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String adress;
    private String phone;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, String middleName, String country, String adress, String phone, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.adress = adress;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
