package com.example.bikereviewer;

public class User {
        private String name;
        private String password;
        private String gender;
        private String email;

        public User() {
        }

        public User(String email, String password, String name) {
            this.email = email;
           // this.name = name;
            this.password = password;
           // this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(){
            this.email = email;
    }
    public String getEmail(){
            return email;
    }
}
