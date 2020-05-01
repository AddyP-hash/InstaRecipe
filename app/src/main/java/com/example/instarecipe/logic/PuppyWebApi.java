package com.example.instarecipe.logic;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public final class PuppyWebApi extends Activity implements Runnable {

    private static final String TAG = "RecipePuppy";
    public static final String API = "http://www.recipepuppy.com/api/";
    private static final int BAD_REQUEST = 400;
    private static RequestQueue requestQueue;
    private static StringRequest stringRequest;
    public static final long errorNum = 999999999;

    public void setStringRequest() {
        stringRequest.setTag(TAG);
    }
    public void setRequestQueue() {
        requestQueue.add(stringRequest);
    }

    private PuppyWebApi() {  }
    public void run() { };

    @Override
    protected void onStop() {
            super.onStop();
            if (requestQueue != null) {
                requestQueue.cancelAll(TAG);
                System.out.print(errorNum);
            }
            Thread.currentThread().getUncaughtExceptionHandler().toString();
    }

    public static void startRequest(Context context, String url,
                                    Response .Listener<JsonObject> listener, Response.ErrorListener errorListener) {
        startRequest(context, url, Request.Method.GET, null, listener, errorListener);
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
    /**
     * Might delete this method I don't know yet.
     * Testing out native JSON parser.
     */
    private static void parseInfo() {
        try {
            String response = null;
            JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
            String requestID = object.getString("requestId");
            int likelihood = object.getInt("likelihood");
            JSONArray photos = object.getJSONArray("photos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
