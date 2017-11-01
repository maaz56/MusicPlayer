package com.example.muaz.musicplayertraning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by muaz on 11/1/17.
 */

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioHolder> {

    private static final String TAG = "Audio Adapter";
    private Context mContext;
    private ArrayList<Audio> mAudios;
    boolean mServiceBound = false;

    public AudioAdapter(Context mContext, ArrayList<Audio> mAudios) {
        this.mContext = mContext;
        this.mAudios = mAudios;
    }


    @Override
    public AudioAdapter.AudioHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.audio_list_item, parent, false);

        AudioHolder audioHolder = new AudioHolder(view);
        return audioHolder;
    }

    @Override
    public void onBindViewHolder(AudioAdapter.AudioHolder holder, int position) {

        Audio AudioAtPosition = mAudios.get(position);

        holder.artistName.setText(AudioAtPosition.getArtist());
        holder.trackName.setText(AudioAtPosition.getTitle());
        //GlideApp.with(mContext).load(AudioAtPosition.getAlbum()).into(holder.albumArt);

        Log.d(TAG, "onBindViewHolder: "+AudioAtPosition.getAlbum());
       /* Glide.with(mContext)
                .load(AudioAtPosition.getAlbum())
                .into(holder.albumArt);
*/


    }

    @Override
    public int getItemCount() {
        return mAudios.size();
    }

    public class AudioHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView albumArt;

        public TextView trackName, artistName;
        public AudioHolder(View itemView) {
            super(itemView);
            albumArt = (ImageView) itemView.findViewById(R.id.album_art);
            trackName = (TextView) itemView.findViewById(R.id.track_name_label);
            artistName = (TextView) itemView.findViewById(R.id.artist_name_label);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }


}
