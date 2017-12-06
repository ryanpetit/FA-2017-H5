package com.fa17.ssu385.fa_2017_h5.ui.search.viewcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fa17.ssu385.fa_2017_h5.R;
import com.fa17.ssu385.fa_2017_h5.model.Recipe;
import com.fa17.ssu385.fa_2017_h5.model.RecipeList;
import com.fa17.ssu385.fa_2017_h5.network.RecipeSearchAsyncTask;
import com.fa17.ssu385.fa_2017_h5.ui.detail.viewcontroller.RecipeDetailActivity;
import com.fa17.ssu385.fa_2017_h5.ui.search.adapter.RecipeSearchAdapter;

import org.parceler.Parcels;

public class SearchActivity extends AppCompatActivity {
    private EditText searchEditText;
    private Button searchButton;
    private RecipeSearchAsyncTask task;
    private LinearLayoutManager linearLayoutManager;
    private RecipeSearchAdapter adapter;
    private RecyclerView recipeResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText)findViewById(R.id.search_edit_text);
        searchButton = (Button)findViewById(R.id.my_search_button);
        recipeResultList = (RecyclerView)findViewById(R.id.recipe_result_list);

        //Layout managers tell RecyclerViews how to display their elements
        linearLayoutManager = new LinearLayoutManager(this);

        recipeResultList.setLayoutManager(linearLayoutManager);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new RecipeSearchAsyncTask();
                task.setCallbackListener(new RecipeSearchAsyncTask.OnRecipeFetchResponse() {
                    @Override
                    public void onCallback(RecipeList recipeList) {
                        // Adapters 'adapt' data to fit in ViewHolders
                        adapter = new RecipeSearchAdapter(recipeList.getRecipes());
                        adapter.setRecipeItemClickListener(new RecipeSearchAdapter.RecipeItemClickListener(){
                            @Override
                            public void onRecipeItemClicked(Recipe selectedItem){
                                Intent navIntent = new Intent(SearchActivity.this, RecipeDetailActivity.class);
                                navIntent.putExtra(RecipeDetailActivity.RECIPE_EXTRA_KEY, Parcels.wrap(selectedItem));
                                startActivity(navIntent);
                            }
                        });
                    }
                });

                // This sets the adapter for the RecyclerView
                recipeResultList.setAdapter(adapter);
                String searchTerms = searchEditText.getText().toString();
                task.execute(searchTerms);
            }

        });

    }
}
