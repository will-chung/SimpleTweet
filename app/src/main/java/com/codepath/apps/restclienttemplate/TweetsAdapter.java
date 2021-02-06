package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.databinding.ItemTweetBinding;
import com.codepath.apps.restclienttemplate.databinding.ItemTweetMediaBinding;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int NO_MEDIA = 0, MEDIA = 1;

    Context context;
    List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case NO_MEDIA:
                view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
                break;
            case MEDIA:
                view = LayoutInflater.from(context).inflate(R.layout.item_tweet_media, parent, false);
                return new ViewHolderMedia(view);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        switch(holder.getItemViewType()) {
            case NO_MEDIA:
                ((ViewHolder) holder).binding.setTweet(tweet);
                ((ViewHolder) holder).binding.executePendingBindings();
                break;
            case MEDIA:
                ((ViewHolderMedia) holder).binding.setTweet(tweet);
                ((ViewHolderMedia) holder).binding.executePendingBindings();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (tweets.get(position).mediaUrl == "") {
            return NO_MEDIA;
        } else {
            Log.i("TweetsAdapter", "mediaUrl: " + tweets.get(position).mediaUrl);
            return MEDIA;
        }
    }

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemTweetBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemTweetBinding.bind(itemView);
        }
    }

    public class ViewHolderMedia extends RecyclerView.ViewHolder {

        private ItemTweetMediaBinding binding;

        public ViewHolderMedia(@NonNull View itemView) {
            super(itemView);
            binding = ItemTweetMediaBinding.bind(itemView);
        }
    }
}
