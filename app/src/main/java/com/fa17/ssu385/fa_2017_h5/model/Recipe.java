package com.fa17.ssu385.fa_2017_h5.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Recipe {
    @SerializedName("recipeName")
    private String name;

    @SerializedName("sourceDisplayName")
    private String source;

    @SerializedName("id")
    private String recipeId;

    @SerializedName("description")
    private String recipeDescription;

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

    public String getRecipeDescription(){
        return recipeDescription;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
