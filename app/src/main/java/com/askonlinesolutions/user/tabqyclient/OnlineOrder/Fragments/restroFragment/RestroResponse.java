package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment;

import java.util.List;

public class RestroResponse {


    /**
     * data : [{"distance":0.51687506156729,"resturantbrand_lattitude":"28.605520","resturantbrand_id":4,"resturantbrand_longitude":"\t 77.372276"},{"distance":0,"resturantbrand_lattitude":"28.598040","resturantbrand_id":7,"resturantbrand_longitude":"77.372192"},{"distance":1.648219670962,"resturantbrand_lattitude":"28.620764","resturantbrand_id":10,"resturantbrand_longitude":"77.363930"},{"distance":2.1191061274787,"resturantbrand_lattitude":"28.626640","resturantbrand_id":11,"resturantbrand_longitude":"77.384804"},{"distance":0.90065163920464,"resturantbrand_lattitude":"28.609810","resturantbrand_id":12,"resturantbrand_longitude":"77.378571"},{"distance":1.362386374976,"resturantbrand_lattitude":"28.612762","resturantbrand_id":13,"resturantbrand_longitude":"77.387131"}]
     * message : Successful
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
         * distance : 0.51687506156729
         * resturantbrand_lattitude : 28.605520
         * resturantbrand_id : 4
         * resturantbrand_longitude : 	 77.372276
         */
        private double distance;
        private String resturantbrand_lattitude;
        private int resturantbrand_id;
        private String resturantbrand_longitude;

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public void setResturantbrand_lattitude(String resturantbrand_lattitude) {
            this.resturantbrand_lattitude = resturantbrand_lattitude;
        }

        public void setResturantbrand_id(int resturantbrand_id) {
            this.resturantbrand_id = resturantbrand_id;
        }

        public void setResturantbrand_longitude(String resturantbrand_longitude) {
            this.resturantbrand_longitude = resturantbrand_longitude;
        }

        public double getDistance() {
            return distance;
        }

        public String getResturantbrand_lattitude() {
            return resturantbrand_lattitude;
        }

        public int getResturantbrand_id() {
            return resturantbrand_id;
        }

        public String getResturantbrand_longitude() {
            return resturantbrand_longitude;
        }
    }
}
