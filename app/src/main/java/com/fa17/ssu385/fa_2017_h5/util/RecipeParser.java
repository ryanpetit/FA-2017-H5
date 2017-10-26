package com.fa17.ssu385.fa_2017_h5.util;

import com.fa17.ssu385.fa_2017_h5.model.RecipeList;
import com.google.gson.Gson;

public class RecipeParser {
    public static final RecipeList recipeListFromJson(String responseString){
        Gson gson = new Gson();
        return gson.fromJson(responseString, RecipeList.class);
    }
}
