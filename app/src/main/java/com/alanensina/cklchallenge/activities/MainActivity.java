package com.alanensina.cklchallenge.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alanensina.cklchallenge.R;
import com.alanensina.cklchallenge.adapters.RecyclerViewAdapter;
import com.alanensina.cklchallenge.model.Articles;
import com.alanensina.cklchallenge.model.Tags;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://cheesecakelabs.com/challenge/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Articles> listArticles;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listArticles = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_id);
        jsonrequest();


    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for(int i = 0 ; i < response.length(); i++){

                    try {

                        jsonObject = response.getJSONObject(i);
                        Articles article = new Articles();
                        Tags tags = new Tags();

                        article.setTitle(jsonObject.getString("title"));
                        article.setWebsite(jsonObject.getString("website"));
                        article.setAuthors(jsonObject.getString("authors"));
                        article.setDate(jsonObject.getString("date"));
                        article.setContent(jsonObject.getString("content"));
                        // Need to check how to verify the object Tags
                        //article.setTags(jsonObject.getString("tags"));
                        article.setImg_url(jsonObject.getString("image_url"));

                        listArticles.add(article);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setupRecyclerView(listArticles);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setupRecyclerView(List<Articles> listArticles) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, listArticles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
}
