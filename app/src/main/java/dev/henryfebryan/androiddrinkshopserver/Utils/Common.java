package dev.henryfebryan.androiddrinkshopserver.Utils;

import dev.henryfebryan.androiddrinkshopserver.Retrofit.IDrinkShopAPI;
import dev.henryfebryan.androiddrinkshopserver.Retrofit.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://10.0.2.2/drinkshop/";
    public static IDrinkShopAPI getAPI(){
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
