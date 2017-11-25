package com.jaksiemasz;

import java.io.IOException;

public class Person{
    private String name;
    private String surname;
    private String mail;

    public Person(String name, String surname, String mail) throws IOException {
        this.name = isWord(name);
        this.surname = isWord(surname);
        this.mail = isMail(mail);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    private String isWord(String word) {

        try {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    continue;
                } else {
                    throw new IOException();
                }
            }
            return word;
        } catch (IOException e) {
            System.out.println("Sorry, please input only letters.");
        }
        return "";
    }

    private String isMail(String mail) {

        try {

            if (mail.contains("@")) {
                return mail;

            } else {
                throw new IOException();
            }

        } catch (IOException e) {
            System.out.println("Sorry, please input correct email adress.");
        }

        return "";
    }

    public String toString() {
        return "-------------------------------\n" + getName() + " " + getSurname() + " " + getMail() + "\n-------------------------------\n";
    }

    public void show() {
        System.out.println(toString());
    }

}
