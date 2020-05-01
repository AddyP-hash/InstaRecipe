package com.example.instarecipe.logic;

import com.google.gson.JsonObject;

public final class DatabaseInfo {
    private JsonObject serverInfo;

    public DatabaseInfo(final com.google.gson.JsonObject serverInfo) {
        this.serverInfo = serverInfo;
    }

    public String getTitle() {
        return serverInfo.get("title").getAsString();
    }
    public String getURL() {
        return serverInfo.get("href").getAsString();
    }
    /**
     * Might need to call this as a string of arrays from the server.
     * Will update if errors in organization.
     * @return Ingredient information.
     */
    public String getIngredients() {
        return serverInfo.get("ingredients").getAsString();
    }
    public String getThumbnail() {
        return serverInfo.get("thumbnail").getAsString();
    }
}
