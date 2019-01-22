package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.infoFragment;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MenuResponse;

import java.util.ArrayList;

public class InfoResponse {


    /**
     * data : {"resturantbrand_delivery_distance":"5 miles","resturantbrand_region":"ESTAUS","resturantbrand_address":"noida sec 60","resturantbrand_company_id":3,"resturantbrand_created":"2018-05-03 10:04:53","resturantbrand_lattitude":"28.605520","resturantbrand_status":"1","resturantbrand_location":"ALXHL","resturantbrand_cuisine":"0","resturantbrand_file":"","resturantbrand_type":0,"resturantbrand_country":"AUs","resturantbrand_zone":"BRISSOU","resturantbrand_email":"new56@gmail.com","resturantbrand_phoneno":"4654654","resturantbrand_delivery_avgtime":"45 minuts","resturantbrand_min_order_price":"67","resturantbrand_city":"BRIS","resturantbrand_id":4,"resturantbrand_name":"new","resturantbrand_longitude":"\t 77.372276","resturantbrand_displayname":"nwe","resturantbrand_countpos":"9","resturantbrand_countusers":"8"}
     * message : Success
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

    public class DataEntity extends ArrayList<MenuResponse.DataEntity> {
        /**
         * resturantbrand_delivery_distance : 5 miles
         * resturantbrand_region : ESTAUS
         * resturantbrand_address : noida sec 60
         * resturantbrand_company_id : 3
         * resturantbrand_created : 2018-05-03 10:04:53
         * resturantbrand_lattitude : 28.605520
         * resturantbrand_status : 1
         * resturantbrand_location : ALXHL
         * resturantbrand_cuisine : 0
         * resturantbrand_file :
         * resturantbrand_type : 0
         * resturantbrand_country : AUs
         * resturantbrand_zone : BRISSOU
         * resturantbrand_email : new56@gmail.com
         * resturantbrand_phoneno : 4654654
         * resturantbrand_delivery_avgtime : 45 minuts
         * resturantbrand_min_order_price : 67
         * resturantbrand_city : BRIS
         * resturantbrand_id : 4
         * resturantbrand_name : new
         * resturantbrand_longitude : 	 77.372276
         * resturantbrand_displayname : nwe
         * resturantbrand_countpos : 9
         * resturantbrand_countusers : 8
         */
        private String resturantbrand_delivery_distance;
        private String resturantbrand_region;
        private String resturantbrand_address;
        private int resturantbrand_company_id;
        private String resturantbrand_created;
        private String resturantbrand_lattitude;
        private String resturantbrand_status;
        private String resturantbrand_location;
        private String resturantbrand_cuisine;
        private String resturantbrand_file;
        private int resturantbrand_type;
        private String resturantbrand_country;
        private String resturantbrand_zone;
        private String resturantbrand_email;
        private String resturantbrand_phoneno;
        private String resturantbrand_delivery_avgtime;
        private String resturantbrand_min_order_price;
        private String resturantbrand_city;
        private int resturantbrand_id;
        private String resturantbrand_name;
        private String resturantbrand_longitude;
        private String resturantbrand_displayname;
        private String resturantbrand_countpos;
        private String resturantbrand_countusers;

        public void setResturantbrand_delivery_distance(String resturantbrand_delivery_distance) {
            this.resturantbrand_delivery_distance = resturantbrand_delivery_distance;
        }

        public void setResturantbrand_region(String resturantbrand_region) {
            this.resturantbrand_region = resturantbrand_region;
        }

        public void setResturantbrand_address(String resturantbrand_address) {
            this.resturantbrand_address = resturantbrand_address;
        }

        public void setResturantbrand_company_id(int resturantbrand_company_id) {
            this.resturantbrand_company_id = resturantbrand_company_id;
        }

        public void setResturantbrand_created(String resturantbrand_created) {
            this.resturantbrand_created = resturantbrand_created;
        }

        public void setResturantbrand_lattitude(String resturantbrand_lattitude) {
            this.resturantbrand_lattitude = resturantbrand_lattitude;
        }

        public void setResturantbrand_status(String resturantbrand_status) {
            this.resturantbrand_status = resturantbrand_status;
        }

        public void setResturantbrand_location(String resturantbrand_location) {
            this.resturantbrand_location = resturantbrand_location;
        }

        public void setResturantbrand_cuisine(String resturantbrand_cuisine) {
            this.resturantbrand_cuisine = resturantbrand_cuisine;
        }

        public void setResturantbrand_file(String resturantbrand_file) {
            this.resturantbrand_file = resturantbrand_file;
        }

        public void setResturantbrand_type(int resturantbrand_type) {
            this.resturantbrand_type = resturantbrand_type;
        }

        public void setResturantbrand_country(String resturantbrand_country) {
            this.resturantbrand_country = resturantbrand_country;
        }

        public void setResturantbrand_zone(String resturantbrand_zone) {
            this.resturantbrand_zone = resturantbrand_zone;
        }

        public void setResturantbrand_email(String resturantbrand_email) {
            this.resturantbrand_email = resturantbrand_email;
        }

        public void setResturantbrand_phoneno(String resturantbrand_phoneno) {
            this.resturantbrand_phoneno = resturantbrand_phoneno;
        }

        public void setResturantbrand_delivery_avgtime(String resturantbrand_delivery_avgtime) {
            this.resturantbrand_delivery_avgtime = resturantbrand_delivery_avgtime;
        }

        public void setResturantbrand_min_order_price(String resturantbrand_min_order_price) {
            this.resturantbrand_min_order_price = resturantbrand_min_order_price;
        }

        public void setResturantbrand_city(String resturantbrand_city) {
            this.resturantbrand_city = resturantbrand_city;
        }

        public void setResturantbrand_id(int resturantbrand_id) {
            this.resturantbrand_id = resturantbrand_id;
        }

        public void setResturantbrand_name(String resturantbrand_name) {
            this.resturantbrand_name = resturantbrand_name;
        }

        public void setResturantbrand_longitude(String resturantbrand_longitude) {
            this.resturantbrand_longitude = resturantbrand_longitude;
        }

        public void setResturantbrand_displayname(String resturantbrand_displayname) {
            this.resturantbrand_displayname = resturantbrand_displayname;
        }

        public void setResturantbrand_countpos(String resturantbrand_countpos) {
            this.resturantbrand_countpos = resturantbrand_countpos;
        }

        public void setResturantbrand_countusers(String resturantbrand_countusers) {
            this.resturantbrand_countusers = resturantbrand_countusers;
        }

        public String getResturantbrand_delivery_distance() {
            return resturantbrand_delivery_distance;
        }

        public String getResturantbrand_region() {
            return resturantbrand_region;
        }

        public String getResturantbrand_address() {
            return resturantbrand_address;
        }

        public int getResturantbrand_company_id() {
            return resturantbrand_company_id;
        }

        public String getResturantbrand_created() {
            return resturantbrand_created;
        }

        public String getResturantbrand_lattitude() {
            return resturantbrand_lattitude;
        }

        public String getResturantbrand_status() {
            return resturantbrand_status;
        }

        public String getResturantbrand_location() {
            return resturantbrand_location;
        }

        public String getResturantbrand_cuisine() {
            return resturantbrand_cuisine;
        }

        public String getResturantbrand_file() {
            return resturantbrand_file;
        }

        public int getResturantbrand_type() {
            return resturantbrand_type;
        }

        public String getResturantbrand_country() {
            return resturantbrand_country;
        }

        public String getResturantbrand_zone() {
            return resturantbrand_zone;
        }

        public String getResturantbrand_email() {
            return resturantbrand_email;
        }

        public String getResturantbrand_phoneno() {
            return resturantbrand_phoneno;
        }

        public String getResturantbrand_delivery_avgtime() {
            return resturantbrand_delivery_avgtime;
        }

        public String getResturantbrand_min_order_price() {
            return resturantbrand_min_order_price;
        }

        public String getResturantbrand_city() {
            return resturantbrand_city;
        }

        public int getResturantbrand_id() {
            return resturantbrand_id;
        }

        public String getResturantbrand_name() {
            return resturantbrand_name;
        }

        public String getResturantbrand_longitude() {
            return resturantbrand_longitude;
        }

        public String getResturantbrand_displayname() {
            return resturantbrand_displayname;
        }

        public String getResturantbrand_countpos() {
            return resturantbrand_countpos;
        }

        public String getResturantbrand_countusers() {
            return resturantbrand_countusers;
        }
    }
}
