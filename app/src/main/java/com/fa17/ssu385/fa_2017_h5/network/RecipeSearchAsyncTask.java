package com.fa17.ssu385.fa_2017_h5.network;


import android.os.AsyncTask;

import com.fa17.ssu385.fa_2017_h5.model.RecipeList;
import com.fa17.ssu385.fa_2017_h5.util.RecipeParser;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RecipeSearchAsyncTask extends AsyncTask<String, String, RecipeList> {

    private final String baseApiUrl = "http://api.yummly.com/v1/api/recipes";
    private final String apiKey = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private final String appId = "4911b643";
    private OnRecipeFetchResponse callbackListener;

    public void setCallbackListener(OnRecipeFetchResponse callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    protected RecipeList doInBackground(String... strings) {
        String searchParams = strings[0];

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        urlBuilder.addQueryParameter("_app_key", apiKey);
        urlBuilder.addQueryParameter("_app_id", appId);
        urlBuilder.addQueryParameter("your_search_parameters", searchParams);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
            if (response != null) {
                return RecipeParser.recipeListFromJson(response.body().string()); }
        } catch (IOException e) {
            // do something with exception
        }

        return null;
    }

    @Override
    protected void onPostExecute(RecipeList recipeList) {
        super.onPostExecute(recipeList);
        callbackListener.onCallback(recipeList);
    }

    public interface OnRecipeFetchResponse {
        void onCallback(RecipeList recipeList);
    }
}
