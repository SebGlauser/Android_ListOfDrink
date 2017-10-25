package com.example.seg.listofdrink;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Drink> mArrayList;
    private DrinkAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        populateAdapter();
    }

    private void populateAdapter() {
        mArrayList = new ArrayList<>();
        mArrayList.add(new Drink("Beer la cuivree", 33.0 , 4.5 ));
        mArrayList.add(new Drink("Beer la brouette", 33.0 , 5.0 ));
        mArrayList.add(new Drink("Beer la salamandre", 33.0 , 5.5 ));
        mArrayList.add(new Drink("Beer la Torpille", 33.0 , 7.5 ));
        mArrayList.add(new Drink("Beer la meule", 33.0 , 6.0 ));
        mArrayList.add(new Drink("Beer highway to helles", 33.0 , 6.0 ));
        mArrayList.add(new Drink("Beer l'alex le rouge", 33.0 , 10.276 ));
        mArrayList.add(new Drink("Beer l'abbaye de saint bon-chien", 25.0 , 11.0 ));
        mArrayList.add(new Drink("Beer l'abbaye de saint bon-chien grand cru", 25.0 , 11.0 ));
        mArrayList.add(new Drink("Beer la saison", 25.0 , 14.0 ));
        mArrayList.add(new Drink("Beer la saison 33cl", 33.0 , 14.0 ));
        mArrayList.add(new Drink("Beer la bats", 33.0 , 6.0 ));
        mAdapter = new DrinkAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initViews(){
        mRecyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
