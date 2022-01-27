package com.example.easycare;

public class doc_information {
    private String Age;
    private String Name;
    private String Qualifications;
    private String Service_taken;

    public doc_information() {
    }

    public doc_information(String age, String name, String qualifications, String service_taken) {
        Age = age;
        Name = name;
        Qualifications = qualifications;
        Service_taken = service_taken;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQualifications() {
        return Qualifications;
    }

    public void setQualifications(String qualifications) {
        Qualifications = qualifications;
    }

    public String getService_taken() {
        return Service_taken;
    }

    public void setService_taken(String service_taken) {
        Service_taken = service_taken;
    }
}
