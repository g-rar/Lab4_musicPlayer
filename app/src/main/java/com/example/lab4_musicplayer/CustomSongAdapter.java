package com.example.lab4_musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomSongAdapter extends BaseAdapter {
    private ArrayList<SongListItem> listData;
    private LayoutInflater layoutInflater;

    public CustomSongAdapter(Context context, ArrayList<SongListItem> listData){
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View view, ViewGroup viewGroup){
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.uSongName = view.findViewById(R.id.textView_songTitle);
            holder.uArtistName = view.findViewById(R.id.textView_artist);
            holder.uDuration = view.findViewById(R.id.textView_duration);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.uSongName.setText(listData.get(position).getSongName());
        holder.uArtistName.setText(listData.get(position).getSongArtist());
        holder.uDuration.setText(listData.get(position).getSongDuration());
        return view;
    }

    static class ViewHolder {
        TextView uSongName;
        TextView uArtistName;
        TextView uDuration;
    }
}
