package com.tugalsan.api.file.yaml.server;

import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class TS_FileYamlUtils {

//    final private static TS_Log d = TS_Log.of(TS_FileYamlUtils.class);
    public static Yaml getDriverInstance() {
        return new Yaml();
    }

    public static Map<String, Object> testRead() {
        return new Yaml().load("""
            firstName: "John"
            lastName: "Doe"
            age: 20
            """);
    }//return {firstName=John, lastName=Doe, age=20}

    public static Customer testCustomer() {
        return new Yaml().load("""
            !!com.baeldung.snakeyaml.Customer
            firstName: "John"
            lastName: "Doe"
            age: 31
            contactDetails:
               - type: "mobile"
                 number: 123456789
               - type: "landline"
                 number: 456786868
            homeAddress:
               line: "Xyz, DEF Street"
               city: "City Y"
               state: "State Y"
               zip: 345657
            """);
    }

    public static Iterable<Customer> testCustomerAll() {
        var yaml = new Yaml(new Constructor(Customer.class));
        yaml.loadAll("""
            !!com.baeldung.snakeyaml.Customer
            firstName: "John"
            lastName: "Doe"
            age: 31
            contactDetails:
               - type: "mobile"
                 number: 123456789
               - type: "landline"
                 number: 456786868
            homeAddress:
               line: "Xyz, DEF Street"
               city: "City Y"
               state: "State Y"
               zip: 345657
            """);
    }

    public static class Customer {

        private String firstName;
        private String lastName;
        private int age;
        private List<Contact> contactDetails;
        private Address homeAddress;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<Contact> getContactDetails() {
            return contactDetails;
        }

        public void setContactDetails(List<Contact> contactDetails) {
            this.contactDetails = contactDetails;
        }

        public Address getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(Address homeAddress) {
            this.homeAddress = homeAddress;
        }

    }

    public class Contact {

        private String type;
        private int number;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

    }

    public class Address {

        private String line;
        private String city;
        private String state;
        private Integer zip;

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Integer getZip() {
            return zip;
        }

        public void setZip(Integer zip) {
            this.zip = zip;
        }

    }

}
