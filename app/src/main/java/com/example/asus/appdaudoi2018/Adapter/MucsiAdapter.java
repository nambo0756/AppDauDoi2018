package com.example.asus.appdaudoi2018.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.asus.appdaudoi2018.Model.Music;
import com.example.asus.appdaudoi2018.R;

import java.util.List;

public class MucsiAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;
    public MucsiAdapter(@NonNull Activity context, int resource, @NonNull List<Music> objects) {

        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtMa=row.findViewById(R.id.chinh);
        TextView txtTen=row.findViewById(R.id.TenBaiHat);
        TextView txtCaSi=row.findViewById(R.id.tenCaSi);
        ImageButton btnLike=row.findViewById(R.id.Thich);
        ImageButton btnDislike=row.findViewById(R.id.KhongThich);

        final Music music=this.objects.get(position);
        txtMa.setText(music.getMa());
        txtTen.setText(music.getTen());
        txtCaSi.setText(music.getCasi());
        if (music.isThich()){
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        }else{
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);

        }
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XyLyLike(music);
            }
        });
        return row;
    }

    private void XyLyLike(Music music) {
        music.setThich(true);
    }
}
