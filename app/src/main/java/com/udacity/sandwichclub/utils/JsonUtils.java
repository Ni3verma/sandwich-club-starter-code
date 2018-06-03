package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject object = new JSONObject(json);
            JSONObject name = object.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            int num = alsoKnownAs.length();
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            String place = object.getString("placeOfOrigin");
            String desc = object.getString("description");
            String imagePath = object.getString("image");

            JSONArray ingredients = object.getJSONArray("ingredients");
            int numOfIngredients = ingredients.length();
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < numOfIngredients; i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            sandwich = new Sandwich(mainName, alsoKnownAsList, place, desc, imagePath, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return sandwich;

    }
}
