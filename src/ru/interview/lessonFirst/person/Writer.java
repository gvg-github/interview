package ru.interview.lessonFirst.person;

public class Writer {
    public void createPerson(Builder builder){
        builder.setFirstName("Ivan");
        builder.setLastName("Ivanov");
        builder.setMiddleName("Ivanovich");
        builder.setAge(40);
        builder.setAdress("Ivanovo");
        builder.setCountry("Gonduras");
        builder.setGender("male");
        builder.setPhone("911");
    }


}
