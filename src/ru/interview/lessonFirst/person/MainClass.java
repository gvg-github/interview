package ru.interview.lessonFirst.person;

public class MainClass {
    public static void main(String[] args) {
        Writer writer = new Writer();
        PersonBuilder builder = new PersonBuilder();
        writer.createPerson(builder);
        Person person = builder.getPerson();
    }
}
