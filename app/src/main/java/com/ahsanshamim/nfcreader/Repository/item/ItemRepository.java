package com.ahsanshamim.nfcreader.Repository.item;

import com.ahsanshamim.nfcreader.Models.items.ItemResponse;
import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;
import com.ahsanshamim.nfcreader.Repository.user.UserDetailsRepository;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.item.ItemListener;
import com.ahsanshamim.nfcreader.listener.user.UserDetailsListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {

    String TAG = ItemRepository.class.getSimpleName();
    public ItemListener itemListener;

    public void getAllItems(String headerToken){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ItemResponse> call = apiInterface.getAllItems("Bearer "+headerToken);
        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                ItemResponse data = response.body();
                Logger.e(TAG + " " + data);

                if(data.getResult()!=null){
                    itemListener.onSuccessItem(data);
                }else{
                    itemListener.onFailureItem("No item found");
                }
            }
            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                itemListener.onFailureItem(t.getMessage());
            }
        });
    }
}
