package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent;


import java.util.List;

public class MenuResponse {


    /**
     * data : [{"item_menu_id":60,"item_avg_time":"","item_code":"Hakka001","item_defaultprice":"120.00","item_created":"2018-08-31 16:54:12","item_most_featured":"0","item_type":"0","item_available_afternoon_to":"00:00:00","item_available_morning_to":"11:59:59","item_category_id":26,"item_country_id":"SAU","item_available_evening_from":"12:00:00","item_brand_id":50,"item_company_id":30,"item_id":4,"item_name":"Hakka Noodles","item_visiblity":"3","item_most_selling":"0","item_available_afternoon_from":"00:00:00","item_status":1,"item_available_morning_from":"00:00:00","item_available_evening_to":"23:59:59","item_prepration_cost":"30.00","item_image":"1535714652_1522045767_hqdefault.jpg","item_branchprice":"0","item_description":"dsfjhklfsdhffuewrewoi","item_calories":"","item_updated":"2018-08-31 16:54:12"}]
     * message : Success
     * status : 1
     */
    private List<DataEntity> data;
    private String message;
    private int status;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataEntity> getData() {
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
         * item_menu_id : 60
         * item_avg_time :
         * item_code : Hakka001
         * item_defaultprice : 120.00
         * item_created : 2018-08-31 16:54:12
         * item_most_featured : 0
         * item_type : 0
         * item_available_afternoon_to : 00:00:00
         * item_available_morning_to : 11:59:59
         * item_category_id : 26
         * item_country_id : SAU
         * item_available_evening_from : 12:00:00
         * item_brand_id : 50
         * item_company_id : 30
         * item_id : 4
         * item_name : Hakka Noodles
         * item_visiblity : 3
         * item_most_selling : 0
         * item_available_afternoon_from : 00:00:00
         * item_status : 1
         * item_available_morning_from : 00:00:00
         * item_available_evening_to : 23:59:59
         * item_prepration_cost : 30.00
         * item_image : 1535714652_1522045767_hqdefault.jpg
         * item_branchprice : 0
         * item_description : dsfjhklfsdhffuewrewoi
         * item_calories :
         * item_updated : 2018-08-31 16:54:12
         */
        private int item_menu_id;
        private String item_avg_time;
        private String item_code;
        private String item_defaultprice;
        private String item_created;
        private String item_most_featured;
        private String item_type;
        private String item_available_afternoon_to;
        private String item_available_morning_to;
        private int item_category_id;
        private String item_country_id;
        private String item_available_evening_from;
        private int item_brand_id;
        private int item_company_id;
        private int item_id;
        private String item_name;
        private String item_visiblity;
        private String item_most_selling;
        private String item_available_afternoon_from;
        private int item_status;
        private String item_available_morning_from;
        private String item_available_evening_to;
        private String item_prepration_cost;
        private String item_image;
        private String item_branchprice;
        private String item_description;
        private String item_calories;
        private String item_updated;

        public void setItem_menu_id(int item_menu_id) {
            this.item_menu_id = item_menu_id;
        }

        public void setItem_avg_time(String item_avg_time) {
            this.item_avg_time = item_avg_time;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public void setItem_defaultprice(String item_defaultprice) {
            this.item_defaultprice = item_defaultprice;
        }

        public void setItem_created(String item_created) {
            this.item_created = item_created;
        }

        public void setItem_most_featured(String item_most_featured) {
            this.item_most_featured = item_most_featured;
        }

        public void setItem_type(String item_type) {
            this.item_type = item_type;
        }

        public void setItem_available_afternoon_to(String item_available_afternoon_to) {
            this.item_available_afternoon_to = item_available_afternoon_to;
        }

        public void setItem_available_morning_to(String item_available_morning_to) {
            this.item_available_morning_to = item_available_morning_to;
        }

        public void setItem_category_id(int item_category_id) {
            this.item_category_id = item_category_id;
        }

        public void setItem_country_id(String item_country_id) {
            this.item_country_id = item_country_id;
        }

        public void setItem_available_evening_from(String item_available_evening_from) {
            this.item_available_evening_from = item_available_evening_from;
        }

        public void setItem_brand_id(int item_brand_id) {
            this.item_brand_id = item_brand_id;
        }

        public void setItem_company_id(int item_company_id) {
            this.item_company_id = item_company_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public void setItem_visiblity(String item_visiblity) {
            this.item_visiblity = item_visiblity;
        }

        public void setItem_most_selling(String item_most_selling) {
            this.item_most_selling = item_most_selling;
        }

        public void setItem_available_afternoon_from(String item_available_afternoon_from) {
            this.item_available_afternoon_from = item_available_afternoon_from;
        }

        public void setItem_status(int item_status) {
            this.item_status = item_status;
        }

        public void setItem_available_morning_from(String item_available_morning_from) {
            this.item_available_morning_from = item_available_morning_from;
        }

        public void setItem_available_evening_to(String item_available_evening_to) {
            this.item_available_evening_to = item_available_evening_to;
        }

        public void setItem_prepration_cost(String item_prepration_cost) {
            this.item_prepration_cost = item_prepration_cost;
        }

        public void setItem_image(String item_image) {
            this.item_image = item_image;
        }

        public void setItem_branchprice(String item_branchprice) {
            this.item_branchprice = item_branchprice;
        }

        public void setItem_description(String item_description) {
            this.item_description = item_description;
        }

        public void setItem_calories(String item_calories) {
            this.item_calories = item_calories;
        }

        public void setItem_updated(String item_updated) {
            this.item_updated = item_updated;
        }

        public int getItem_menu_id() {
            return item_menu_id;
        }

        public String getItem_avg_time() {
            return item_avg_time;
        }

        public String getItem_code() {
            return item_code;
        }

        public String getItem_defaultprice() {
            return item_defaultprice;
        }

        public String getItem_created() {
            return item_created;
        }

        public String getItem_most_featured() {
            return item_most_featured;
        }

        public String getItem_type() {
            return item_type;
        }

        public String getItem_available_afternoon_to() {
            return item_available_afternoon_to;
        }

        public String getItem_available_morning_to() {
            return item_available_morning_to;
        }

        public int getItem_category_id() {
            return item_category_id;
        }

        public String getItem_country_id() {
            return item_country_id;
        }

        public String getItem_available_evening_from() {
            return item_available_evening_from;
        }

        public int getItem_brand_id() {
            return item_brand_id;
        }

        public int getItem_company_id() {
            return item_company_id;
        }

        public int getItem_id() {
            return item_id;
        }

        public String getItem_name() {
            return item_name;
        }

        public String getItem_visiblity() {
            return item_visiblity;
        }

        public String getItem_most_selling() {
            return item_most_selling;
        }

        public String getItem_available_afternoon_from() {
            return item_available_afternoon_from;
        }

        public int getItem_status() {
            return item_status;
        }

        public String getItem_available_morning_from() {
            return item_available_morning_from;
        }

        public String getItem_available_evening_to() {
            return item_available_evening_to;
        }

        public String getItem_prepration_cost() {
            return item_prepration_cost;
        }

        public String getItem_image() {
            return item_image;
        }

        public String getItem_branchprice() {
            return item_branchprice;
        }

        public String getItem_description() {
            return item_description;
        }

        public String getItem_calories() {
            return item_calories;
        }

        public String getItem_updated() {
            return item_updated;
        }
    }
}
