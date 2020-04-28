package com.example.instarecipe.logic;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.instarecipe.R;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class SearchRecipe {
        private List<String> ingredients = new ArrayList<>();
        private Map<String, Integer> lookUp = new HashMap<>();
        private String recipeName;
        private Context mContext;

        public SearchRecipe(List<String> ing, Context context) {
                mContext = context;
        }

        //public String searchByIngredients(List<String> list) {
        //        return null;  no need for this for rn
        //}
        public String searchByTitle() {
                return null;
        }
        //@Override
        public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) throws IllegalArgumentException {
                inflater.inflate(R.menu.options_menu, menu);
                // Associate searchable configuration with the SearchView
                SearchManager searchManager =
                        (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
                SearchView searchView =
                        (SearchView) menu.findItem(R.id.app_bar_search).getActionView(); //might need to edit
                searchView.setSearchableInfo(
                        searchManager.getSearchableInfo(((Activity) mContext).getComponentName()));

                return true;
        }

        public String getRecipeName() {
                return recipeName;
        }
        public void setRecipeName(String s) {
                recipeName = s;
        }


}
