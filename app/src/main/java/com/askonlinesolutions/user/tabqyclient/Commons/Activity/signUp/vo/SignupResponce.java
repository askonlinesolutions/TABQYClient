package com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo;

public class SignupResponce {


    /**
     * data : {"customer_password":"2af54305f183778d87de0c70c591fae4","customer_email":"fghfghf","customer_phone":"7567","customer_username":"gjghj ghjghj","customer_gender":"gjghj"}
     * message : Signup Successful
     * status : 1
     */
    private DataEntity data;
    private String message;
    private int status;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public class DataEntity {
        /**
         * customer_password : 2af54305f183778d87de0c70c591fae4
         * customer_email : fghfghf
         * customer_phone : 7567
         * customer_username : gjghj ghjghj
         * customer_gender : gjghj
         */
        private String customer_password;
        private String customer_email;
        private String customer_phone;
        private String customer_username;
        private String customer_gender;

        public void setCustomer_password(String customer_password) {
            this.customer_password = customer_password;
        }

        public void setCustomer_email(String customer_email) {
            this.customer_email = customer_email;
        }

        public void setCustomer_phone(String customer_phone) {
            this.customer_phone = customer_phone;
        }

        public void setCustomer_username(String customer_username) {
            this.customer_username = customer_username;
        }

        public void setCustomer_gender(String customer_gender) {
            this.customer_gender = customer_gender;
        }

        public String getCustomer_password() {
            return customer_password;
        }

        public String getCustomer_email() {
            return customer_email;
        }

        public String getCustomer_phone() {
            return customer_phone;
        }

        public String getCustomer_username() {
            return customer_username;
        }

        public String getCustomer_gender() {
            return customer_gender;
        }
    }
}
