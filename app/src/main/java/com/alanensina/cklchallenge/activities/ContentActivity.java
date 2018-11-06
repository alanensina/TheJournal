package com.alanensina.cklchallenge.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alanensina.cklchallenge.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        // Hiding the default actionbar

        getSupportActionBar().hide();

        // Receiving data from the endpoint

        String title = getIntent().getExtras().getString("article_title");
        String content = getIntent().getExtras().getString("article_content");
        String date = getIntent().getExtras().getString("article_date");
        String authors = getIntent().getExtras().getString("article_authors");
        String website = getIntent().getExtras().getString("article_website");
        String imgurl = getIntent().getExtras().getString("article_img");
        // Needs verification
        // String category = getIntent().getExtras().getString("article_category");


        // Initializing the views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_title = findViewById(R.id.aa_article_title);
        TextView tv_content = findViewById(R.id.aa_content);
        TextView tv_date = findViewById(R.id.aa_article_date);
        TextView tv_authors = findViewById(R.id.aa_article_authors);
        TextView tv_website = findViewById(R.id.aa_article_website);
        ImageView tv_imgurl = findViewById(R.id.aa_thumbnail);
        // TextView tv_category = findViewById(R.id.aa_article_category);


        // Setting values to the views

        tv_title.setText(title);
        tv_content.setText(content);
        tv_date.setText(date);
        tv_authors.setText(authors);
        tv_website.setText(website);
        //tv_category.setText(category);

        collapsingToolbarLayout.setTitle(title);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable
                .loading_shape).error(R.drawable.loading_shape);

        // Setting the image using Glide
        Glide.with(this).load(imgurl).apply(requestOptions).into(tv_imgurl);

    }
}
