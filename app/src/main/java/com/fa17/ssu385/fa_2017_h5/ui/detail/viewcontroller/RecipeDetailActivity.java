package com.fa17.ssu385.fa_2017_h5.ui.detail.viewcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.fa17.ssu385.fa_2017_h5.R;
import com.fa17.ssu385.fa_2017_h5.model.Recipe;

import org.parceler.Parcels;

public class RecipeDetailActivity extends AppCompatActivity {
    public static final String RECIPE_EXTRA_KEY = "recipeExtraKey";

    private TextView recipeDetailName;
    private TextView recipeSourceDisplayName;
    private ImageView recipeDetailImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        recipeDetailName = (TextView)findViewById(R.id.recipe_detail_name);
        recipeSourceDisplayName = (TextView)findViewById(R.id.recipe_source_display_name);
        recipeDetailImage = (ImageView)findViewById(R.id.recipe_detail_image);

        Intent receiveIntent = getIntent();
        if (receiveIntent != null) {
            Recipe recipe = Parcels.unwrap(receiveIntent.getParcelableExtra(RECIPE_EXTRA_KEY));

            recipeDetailName.setText(recipe.getName());
            recipeSourceDisplayName.setText(recipe.getSource());
            Glide.with(this).load(recipe
                                        .getThumbnailSources()
                                        .get(0))
                                        .into(recipeDetailImage);
        }



    }
}
