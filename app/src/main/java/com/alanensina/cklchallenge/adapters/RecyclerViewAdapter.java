package com.alanensina.cklchallenge.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alanensina.cklchallenge.R;
import com.alanensina.cklchallenge.activities.ContentActivity;
import com.alanensina.cklchallenge.model.Articles;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Articles> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Articles> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R
                .drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.articles, viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, ContentActivity.class);
                i.putExtra("article_title", mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("article_authors", mData.get(viewHolder.getAdapterPosition()).getAuthors
                        ());
                i.putExtra("article_content", mData.get(viewHolder.getAdapterPosition()).getContent
                        ());
                i.putExtra("article_date", mData.get(viewHolder.getAdapterPosition()).getDate());
                i.putExtra("article_img", mData.get(viewHolder.getAdapterPosition()).getImg_url());
                i.putExtra("article_website", mData.get(viewHolder.getAdapterPosition()).getWebsite
                        ());

                /* Needs verification
                i.putExtra("article_category", mData.get(viewHolder.getAdapterPosition()).getTags

                        ());
                */

                mContext.startActivity(i);






            }
        });






        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_website.setText(mData.get(position).getWebsite());
        holder.tv_authors.setText(mData.get(position).getAuthors());
        holder.tv_date.setText(mData.get(position).getDate());

        // Probably here will get some error because category is a reference from Tags
        //holder.tv_category.setText(mData.get(position).getTags().get(position).getLabel());

        //Loading the image from internet
        Glide.with(mContext).load(mData.get(position).getImg_url()).apply(option).into(holder
                .img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_authors, tv_website, tv_date;
        ImageView img_thumbnail;
        //TextView tv_category;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.article_title);
            tv_authors = itemView.findViewById(R.id.article_authors);
            tv_website = itemView.findViewById(R.id.article_website);
           // tv_category = itemView.findViewById(R.id.article_category);
            tv_date = itemView.findViewById(R.id.article_date);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
