package com.example.henriqueb.marvelapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.henriqueb.marvelapp.models.Character;
import com.example.henriqueb.marvelapp.R;
import com.squareup.picasso.Picasso;

public class CharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        Character character = (Character) getIntent().getSerializableExtra("character");

        TextView title = (TextView) findViewById(R.id.title);
        ImageView img = (ImageView) findViewById(R.id.image);
        TextView descr = (TextView) findViewById(R.id.description);

        title.setText(character.getName());
        descr.setText(character.getDescription());
        Picasso.with(this).load(character.getThumbnailUrl()).into(img);
    }
}
