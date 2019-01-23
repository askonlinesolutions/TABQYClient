package com.askonlinesolutions.user.tabqyclient.WebServices;


import com.askonlinesolutions.user.tabqyclient.Commons.Activity.login.LoginRequest;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.login.LoginResponse;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo.SignUpRequest;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo.SignupResponce;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.detail_id.DetailResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemDetailResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.searchResturent.SearchResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.infoFragment.InfoResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MenuResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.RestroRequest;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.RestroResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.ResturentList.ResturentResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @POST("signup")
    Call<SignupResponce> doRegister(@Body SignUpRequest signUpRequest);

    @POST("login")
    Call<LoginResponse> doLogin(@Body LoginRequest loginRequest);

    @POST("resturantbymiles")
    Call<RestroResponse> doRestro(@Body RestroRequest restroRequest);

    @GET("resturantbymiles/{latitude}/{longitute}")
    Call<ResturentResponse> getResturentList(@Path("latitude") double latitude,
                                             @Path("longitute") double longitute);


//    @GET("restaurant")
//    Call<ResturentResponse> getResturentList();


    @GET(" restaurant/view/{id}")
    Call<DetailResponse> getResturentDetail(@Path("id") int id);


    @GET(" restaurant/getitembymenuid/{id}")
    Call<MenuResponse> getMenuDetail(@Path("id") int id);


    @GET("restaurant/getitemaddonbymenuid/{id}")
    Call<ItemDetailResponse> getItemDetail(@Path("id") int id);

    @GET(" restaurant/view/{id}")
    Call<InfoResponse> getInfoResturentDetail(@Path("id") int id);


    @GET(" restaurant/searchbyresturantnamenfood/{id}")
    Call<SearchResponse> getSearchResturentDetail(@Path("id") String id);


//    restaurant/view/id
    //  @FormUrlEncoded
    // @POST("login")
//    Call<LoginModal> actionLogin(@Field("email") String email,
//                                 @Field("password") String password,
//                                 @Field("device_id") String device_id);
//
//    @FormUrlEncoded
//    @POST("forgotPassword")
//    Call<ApiResponse> forgotPass(@Field("email") String email);
//
//    @FormUrlEncoded
//    @POST("changePassword")
//    Call<ApiResponse> changePassword(@Field("old_password") String old_password,
//                                     @Field("new_password") String new_password,
//                                     @Field("user_id") String user_id);
//
//    @FormUrlEncoded
//    @POST("get_completed_trip")
//    Call<ApiResponse> getCompletedTrip(@Field("driver_id") String driver_id);
//
//    @FormUrlEncoded
//    @POST("pickup_list")
//    Call<UpcomingBookingResponse> getUpcomingBooking(@Field("action") String action,
//                                                     @Field("source_stopage_id") int source_stoppage_id,
//                                                     @Field("trip_id") int trip_id);
//
//    @FormUrlEncoded
//    @POST("pickup_list")
//    Call<PickUpResponse> getUpcomingPickup(@Field("action") String action,
//                                           @Field("source_stopage_id") int source_stoppage_id,
//                                           @Field("trip_id") int trip_id);
//
//    /*@FormUrlEncoded
//    @POST("drop_list")
//    Call<DropListResponse> getUpcomingDrop(@Field("action")String action,
//                                           @Field("destination_stop_id")int destination_stop_id,
//                                           @Field("trip_id")int trip_id);*/
//
//
//    @GET("current_trip_status/{trip_id}")
//    Call<BookingStatusResponse> getTripStatus(@Query("trip_id") int trip_id);
//
//    @GET("trip_detail/{trip_id}")
//    Call<TripDetailsResponse> getTripDetails(@Query("trip_id") int trip_id);
//
//
//    @FormUrlEncoded
//    @POST("current_trip")
//    Call<TripStoppegeResponse> getTripStoppege(@Field("driver_id") int driver_id);
//
//   /*
//
//    @FormUrlEncoded
//    @POST("login.php")
//    Call<LoginResponse> actionLogin(@Field("driverId") String driverId,
//                                        @Field("password") String password);
//    @FormUrlEncoded
//    @POST("new_user_register.php")
//    Call<NewUserResponse> registerNewUser(@Field("driverid") String driverId,
//                                          @Field("IMEI") String IMEI,
//                                          @Field("TOKEN_ID") String TOKEN_ID);
//
//    @FormUrlEncoded
//    @POST("save_duty_slip.php")
//    Call<SaveResponse> saveDutySlip(@Field("dutyslipnum") String dutyslipnum,
//                                    @Field("starting_date") String starting_date,
//                                    @Field("ending_date") String ending_date,
//                                    @Field("starting_meter") String starting_meter,
//                                    @Field("reporting_meter") String reporting_meter,
//                                    @Field("starting_time") String starting_time,
//                                    @Field("reporting_time") String reporting_time,
//                                    @Field("ending_meter") String ending_meter,
//                                    @Field("ending_time") String ending_time,
//                                    @Field("meter_at_garage") String meter_at_garage,
//                                    @Field("time_at_garage") String time_at_garage,
//                                    @Field("total_meter") String total_meter,
//                                    @Field("total_time") String total_time);
//
//    @FormUrlEncoded
//    @POST("misc_charge1.php")
//    Call<SaveResponse> saveMis1(@Field("dutyslipnum") String dutyslipnum,
//                                @Field("night_halt") String night_halt,
//                                @Field("toll") String toll,
//                                @Field("parking") String parking,
//                                @Field("e_toll") String e_toll,
//                                @Field("interstate_tax") String interstate_tax,
//                                @Field("others") String others);
//
//    @FormUrlEncoded
//    @POST("misc_charge2.php")
//    Call<SaveResponse> saveMis2(@Field("dutyslipnum") String dutyslipnum,
//                                @Field("beverages_charges") String beverages_charges,
//                                @Field("entrance_charge") String entrance_charge,
//                                @Field("guide_charge") String guide_charge,
//                                @Field("driver_ta") String driver_ta);
//
//    @FormUrlEncoded
//    @POST("end_job.php")
//    Call<SaveResponse> sendFeedback(@Field("dutyslipnum") String dutyslipnum,
//                                    @Field("signature") String signature,
//                                    @Field("rating") String rating,
//                                    @Field("duty_remarks") String duty_remarks,
//                                    @Field("no_signature") String no_signature);
//
//    @FormUrlEncoded
//    @POST("job_history.php")
//    Call<OrderHistroyData> getHistory(@Field("driverId") String driverId,
//                                      @Field("limit") String limit);
//
//    @FormUrlEncoded
//    @POST("notification.php")
//    Call<NotificationData> getNotification(@Field("driverId") String driverId,
//                                           @Field("limit") String limit);
//    @FormUrlEncoded
//    @POST("notification.php")
//    Call<NotificationData> readNotification(@Field("driverId") String driverId,
//                                            @Field("limit") String limit,
//                                            @Field("notification_id") String notification_id);
//
////    @FormUrlEncoded
//    @POST("notification.php")
//    Call<NotificationData> readNotification1(@Body NotificationRequest notificationRequest);
//
//    @FormUrlEncoded
//    @POST("upload_ds_docuement.php")
//    Call<SaveResponse> deleteDoc(@Field("dutyslipnum") String dutyslipnum,
//                                 @Field("driverId") String driverId,
//                                 @Field("action") String action,
//                                 @Field("remove_id") String remove_id);
//
//    @FormUrlEncoded
//    @POST("close_ds.php")
//    Call<SaveResponse> closeDs(@Field("dutyslipnum") String dutyslipnum);
//*/
}

