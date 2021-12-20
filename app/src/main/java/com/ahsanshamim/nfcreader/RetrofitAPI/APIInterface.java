package com.ahsanshamim.nfcreader.RetrofitAPI;

import com.ahsanshamim.nfcreader.Models.IsTenantAvailable;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.SimpleLogin;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.getproductinfo;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.Models.istenant_body;
import com.ahsanshamim.nfcreader.Models.iteminfoP;
import com.ahsanshamim.nfcreader.Models.responseproduct;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {


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
