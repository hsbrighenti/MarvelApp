package com.example.henriqueb.marvelapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.ViewHolder> {
    private List<Character> mDataset;
    Context ctxt;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CharAdapter(List<Character> characters, Context context) {
        mDataset = characters;
        ctxt = context;
    }

    @Override
    public CharAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);


        ViewHolder vh = new ViewHolder((CardView) v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //preencher item_character
        Character character = mDataset.get(position);

        //Img
        ImageView img = (ImageView) holder.cardView.findViewById(R.id.character_image);
        Picasso.with(ctxt).load(character.getThumbnailUrl()).into(img);

        //Name
        TextView name = (TextView) holder.cardView.findViewById(R.id.character_name);
        name.setText(character.name);

        //Description
        TextView description = (TextView) holder.cardView.findViewById(R.id.character_description);
        description.setText(character.description);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}