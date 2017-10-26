package com.fa17.ssu385.fa_2017_h5.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecipeList {
    @SerializedName("matches")
    private ArrayList<Recipe> recipes;

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
}
