package dev.henryfebryan.androiddrinkshopserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import dev.henryfebryan.androiddrinkshopserver.Adapter.DrinkListAdapter;
import dev.henryfebryan.androiddrinkshopserver.Model.Drink;
import dev.henryfebryan.androiddrinkshopserver.Retrofit.IDrinkShopAPI;
import dev.henryfebryan.androiddrinkshopserver.Utils.Common;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DrinkListActivity extends AppCompatActivity {

    IDrinkShopAPI mService;
    RecyclerView recycler_drinks;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_list);

        mService = Common.getAPI();

        recycler_drinks = (RecyclerView) findViewById(R.id.recycler_drinks);
        recycler_drinks.setLayoutManager(new GridLayoutManager(this,2));
        recycler_drinks.setHasFixedSize(true);

        loadListDrink(Common.currentCategory.getID());
    }

    private void loadListDrink(String id) {
        compositeDisposable.add(
                mService.getDrink(id)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<List<Drink>>() {
                            @Override
                            public void accept(List<Drink> drinks) throws Exception {
                                displayDrinkList(drinks);
                            }
                        }));
    }

    @Override
    protected void onResume() {
        loadListDrink(Common.currentCategory.getID());
        super.onResume();
    }

    private void displayDrinkList(List<Drink> drinks) {
        DrinkListAdapter adapter = new DrinkListAdapter(this, drinks);
        recycler_drinks.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
