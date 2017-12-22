package com.jaksiemasz.employee;

public abstract class AbstractEmployee implements IEmployee {

    private final String name;
    private final EEmployeeRole role;
    private final String email;
    private final String originCountry;
    private final Sex sex;
    private final String university;


    AbstractEmployee(String name, EEmployeeRole role, String email, String originCountry, Sex sex, String university) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.originCountry = originCountry;
        this.sex = sex;
        this.university = university;
    }

    AbstractEmployee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.role = builder.role;
        this.sex = builder.sex;
        this.university = builder.university;
        this.email = builder.email;
        this.originCountry = builder.originCountry;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public String getOriginCountry() {
        return originCountry;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EEmployeeRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return (name + role);
    }

    public static class EmployeeBuilder<T extends EmployeeBuilder> {

        private String name;
        private EEmployeeRole role;
        private Sex sex;
        private String university;
        private String email;
        private String originCountry;

        public T setName(String name) {
            this.name = name;
            return (T) this;
        }

        public T setRole(EEmployeeRole role) {
            this.role = role;
            return (T) this;
        }

        public T setSex(Sex sex) {
            this.sex = sex;
            return (T) this;
        }

        public T setUniversity(String university) {
            this.university = university;
            return (T) this;
        }

        public T setEmail(String email) {
            this.email = email;
            return (T) this;
        }

        public T setCountry(String country) {
            this.originCountry = country;
            return (T) this;
        }
    }
}



