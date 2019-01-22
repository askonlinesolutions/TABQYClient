package com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo;

public class SignUpRequest {
    private String customer_email;
    private String customer_phone;
    private String customer_password;
    private String customer_conf_password;
    private String first_name;
    String last_name;
    String gender;

    public String getCustomer_email() {
        return customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }



    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_conf_password() {
        return customer_conf_password;
    }

    public void setCustomer_conf_password(String customer_conf_password) {
        this.customer_conf_password = customer_conf_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
