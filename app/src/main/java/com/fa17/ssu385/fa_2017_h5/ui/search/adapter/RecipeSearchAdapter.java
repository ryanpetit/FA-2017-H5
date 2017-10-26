package com.fa17.ssu385.fa_2017_h5.ui.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fa17.ssu385.fa_2017_h5.R;
import com.fa17.ssu385.fa_2017_h5.model.Recipe;
import com.fa17.ssu385.fa_2017_h5.ui.search.viewholder.RecipeItemViewHolder;

import java.util.ArrayList;

public class RecipeSearchAdapter extends RecyclerView.Adapter<RecipeItemViewHolder>{

    private ArrayList<Recipe> bindableCollection;

    public RecipeSearchAdapter(ArrayList<Recipe> collection) {
        this.bindableCollection = collection;
    }

    @Override
    public RecipeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recipe_search_item, parent, false);

        return new RecipeItemViewHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(RecipeItemViewHolder holder, int position) {
        Recipe item = bindableCollection.get(position);

        holder.bindView(item);
    }

    @Override
    public int getItemCount() {
        return this.bindableCollection.size();
    }
}
