package dev.henryfebryan.androiddrinkshopserver.Retrofit;

import java.util.List;

import dev.henryfebryan.androiddrinkshopserver.Model.Category;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IDrinkShopAPI {

    @GET("getmenu.php")
    Observable<List<Category>> getMenu();
}
