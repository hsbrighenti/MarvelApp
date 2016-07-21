package com.example.henriqueb.marvelapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henriqueb.marvelapp.R;
import com.example.henriqueb.marvelapp.activities.CharacterActivity;
import com.example.henriqueb.marvelapp.models.Character;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.ViewHolder> {
    private List<Character> mDataset;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CharAdapter(List<Character> characters, Context context) {
        mDataset = characters;
        this.context = context;
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
        final Character character = mDataset.get(position);

        //Img
        ImageView img = (ImageView) holder.cardView.findViewById(R.id.character_image);
        Picasso.with(context).load(character.getThumbnailUrl()).into(img);

        //Name
        TextView name = (TextView) holder.cardView.findViewById(R.id.character_name);
        name.setText(character.name);

        //Description
        TextView description = (TextView) holder.cardView.findViewById(R.id.character_description);
        description.setText(character.description);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CharacterActivity.class);
                intent.putExtra("character",character);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}