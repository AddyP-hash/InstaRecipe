package com.example.instarecipe.logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public final class PuppyWebApi {

    private static final String TAG = "RecipePuppy";
    private static final String API = "http://www.recipepuppy.com/api/";
    private static final int BAD_REQUEST = 400;
    private static RequestQueue requestQueue;
    private static StringRequest stringRequest;

    public void setStringRequest() {
        stringRequest.setTag(TAG);
    }
    public void setRequestQueue() {
        requestQueue.add(stringRequest);
    }

    private PuppyWebApi() {  }

    public static void startRequest(Context context, String url,
                                    Response .Listener<JsonObject> listener, Response.ErrorListener errorListener) {
        startRequest(context, url, listener, errorListener);
    }

    public static void startRequest(Context c, String url, int method, JsonElement body,
                                    final Response.Listener<JsonObject> listener, Response.ErrorListener errorListener) throws IllegalArgumentException {
        if (requestQueue == null) {
            Log.v(TAG, "Request Created");
            requestQueue = Volley.newRequestQueue(c.getApplicationContext());
        }
        Response.Listener<String> serverRL = stringResponse -> {
            if (stringResponse == null || stringResponse.isEmpty()) {
                Log.v(TAG, "Empty response from " + url);
                listener.onResponse(null);
            } else {
                Log.v(TAG, "Given response from " + url);
                listener.onResponse(JsonParser.parseString(stringResponse).getAsJsonObject());
            }
        };
        Response.ErrorListener serverEL = error -> {
            if (error.networkResponse != null && error.networkResponse.data != null
                && error.networkResponse.statusCode == BAD_REQUEST) {
                String data = new String(error.networkResponse.data);
                try {
                    JsonObject err = JsonParser.parseString(data).getAsJsonObject();
                    Log.v(TAG, "Application error from " + url);
                    //errorListener.onErrorResponse(new VolleyError(err.get("err").getAsString());
                } catch (Exception err) {
                    Log.e(TAG, "400 error by " + url);
                    errorListener.onErrorResponse(error);
                }
            } else {
                Log.v(TAG, "Volley error by " + url);
                errorListener.onErrorResponse(error);
            }
        };
    }
}
