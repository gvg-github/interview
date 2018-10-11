package ru.interview.lessonFirst.person;

public class PersonBuilder implements Builder {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String adress;
    private String phone;
    private int age;
    private String gender;


    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person getPerson() {
        return new Person(firstName, lastName, middleName, country, adress, phone, age, gender);
    }
}
