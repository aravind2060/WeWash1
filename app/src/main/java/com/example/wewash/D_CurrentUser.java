package com.example.wewash;

public class D_CurrentUser {

    public static String Name,Email,Password,PhoneNumber;

    public D_CurrentUser(String name, String email, String password, String phoneNumber) {
        Name = name;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
    }
    public D_CurrentUser()
    {

    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static String getPhoneNumber() {
        return PhoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
