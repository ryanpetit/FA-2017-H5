package com.fa17.ssu385.fa_2017_h5.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
//a change so I can push git
@Parcel
public class Recipe {
    @SerializedName("recipeName")
    private String name;

    @SerializedName("sourceDisplayName")
    private String source;

    @SerializedName("id")
    private String recipeId;

    @SerializedName("ingredients")
    private ArrayList<String> ingredients;

    @SerializedName("smallImageUrls")
    private ArrayList<String> thumbnailSources;

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
