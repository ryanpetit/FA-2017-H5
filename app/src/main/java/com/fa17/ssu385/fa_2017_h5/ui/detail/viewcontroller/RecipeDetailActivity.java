package com.fa17.ssu385.fa_2017_h5.ui.detail.viewcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fa17.ssu385.fa_2017_h5.R;
import com.fa17.ssu385.fa_2017_h5.model.Recipe;

import org.parceler.Parcels;

public class RecipeDetailActivity extends AppCompatActivity {
    public static final String RECIPE_EXTRA_KEY = "recipeExtraKey";
    private ImageView recipeDetailImage;
    private TextView recipeDetailName;
    private TextView recipeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        recipeDetailImage = (ImageView) findViewById(R.id.recipe_detail_image);
        recipeDetailName = (TextView) findViewById(R.id.recipe_detail_name);
        recipeDescription = (TextView) findViewById(R.id.recipe_description);
        Recipe recipe = Parcels.unwrap(getIntent().getParcelableExtra(RECIPE_EXTRA_KEY));
        recipeDetailName.setText(recipe.getName());
        recipeDescription.setText(recipe.getDescription());
        Glide.with(this).load(recipe.getThumbnailSources().get(0)).into(recipeDetailImage);
    }
}
