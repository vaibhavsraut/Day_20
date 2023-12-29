package com.day20;


public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return firstName.matches(regex);
    }

    public boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return lastName.matches(regex);
    }

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-]{1}[a-zA-Z0-9]+)*@[a-zA-Z]+\\.[a-zA-Z]{2,}([.]{1}[a-zA-Z]{2,})*$";
        return email.matches(regex);
    }

    public boolean validateMobile(String mobile) {
        String regex = "^[0-9]{2}\\s[0-9]{10}$";
        return mobile.matches(regex);
    }

    public boolean validatePassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }
}

