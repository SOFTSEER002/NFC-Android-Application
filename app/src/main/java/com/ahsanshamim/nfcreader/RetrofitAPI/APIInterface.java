package com.ahsanshamim.nfcreader.RetrofitAPI;

import com.ahsanshamim.nfcreader.Models.IsTenantAvailable;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.SimpleLogin;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.candidate.CandidateResponse;
import com.ahsanshamim.nfcreader.Models.encrypt.EncryptResponse;
import com.ahsanshamim.nfcreader.Models.getproductinfo;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.istenant_body;
import com.ahsanshamim.nfcreader.Models.iteminfoP;
import com.ahsanshamim.nfcreader.Models.items.ItemResponse;
import com.ahsanshamim.nfcreader.Models.responseproduct;
import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;
import com.ahsanshamim.nfcreader.Models.session.SendSessionRequest;
import com.ahsanshamim.nfcreader.Models.session.SessionRequest;
import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {




    @GET("services/app/Candidate/GetAll")
    Call<CandidateResponse> getAllCandidates(@Header("Authorization") String authorization, @Query("TenantId") int TenantId);


    @GET("services/app/Encryptionkey/GetAll")
    Call<EncryptResponse> getAllEncryptionKey(@Header("Authorization") String authorization, @Query("TenantId") int TenantId);

    @GET("services/app/Item/GetAll")
    Call<ItemResponse> getAllItems(@Header("Authorization") String authorization);


    @GET("services/app/User/GetUserForEdit")
    Call<UserDetailsResponse> getUserDetails(@Header("Authorization") String authorization, @Query("ID") int id);

    @GET("services/app/Session/GetCurrentLoginInformations")
    Call<CurrentSessionModel> checkCurrentSession(@Header("Authorization") String authorization);

    @POST("TokenAuth/Authenticate")
    Call<UserData> loginUser(@Header("Abp.TenantId") int tenanId, @Body SimpleLogin simpleLogin);

    @GET("getproducts")
    Call<getproductsInfo> getproducts();

    @GET("getproductbyid")
    Call<getproductinfo> getproductbyid(@Query("productid") String id);

    @POST("setproduct")
    Call<responseproduct> setproducts(@Body iteminfoP item);

    @POST("services/app/Account/IsTenantAvailable")
    Call<IsTenantAvailable> get_istenantavailable(@Body istenant_body tenantId);
}
