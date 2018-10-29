package com.example.asus.appdaudoi2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.asus.appdaudoi2018.Adapter.MucsiAdapter;
import com.example.asus.appdaudoi2018.Model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvBaihat;
    ArrayList<Music>dsBaiHatGoc;
    MucsiAdapter adapterBaihatGoc;


    ListView lvBaihatYeuThich;
    ArrayList<Music>dsBaiHatYeuThich;
    ArrayAdapter<Music>adapterBaihatYeuThich;
    TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }

    private void addEvents() {
        tabHost=findViewById(R.id.tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")){
                    xuly1();
                }else if(tabId.equalsIgnoreCase("t2")){
                    xuly2();
                }
            }
        });



    }

    private void xuly1() {
    }

    private void xuly2() {
        dsBaiHatYeuThich.clear();
        for(Music music:dsBaiHatGoc){
            if(music.isThich())
                dsBaiHatYeuThich.add(music);
        }
        adapterBaihatYeuThich.notifyDataSetChanged();
        
    }

    private void addControls() {
        TabHost tabHost =findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tab1 =tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("",getResources().getDrawable(R.drawable.like));
        tabHost.addTab(tab1);


        TabHost.TabSpec tab2 =tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("",getResources().getDrawable(R.drawable.like1));
        tabHost.addTab(tab2);




        lvBaihat=findViewById(R.id.baiHatGoc);
        dsBaiHatGoc=new ArrayList<>();
        adapterBaihatGoc=new MucsiAdapter(MainActivity.this,R.layout.item,dsBaiHatGoc);
        lvBaihat.setAdapter(adapterBaihatGoc);


        lvBaihatYeuThich=findViewById(R.id.baiHatYeuThich);
        dsBaiHatYeuThich=new ArrayList<>();
        adapterBaihatYeuThich=new MucsiAdapter(MainActivity.this,R.layout.item,dsBaiHatYeuThich);
        lvBaihatYeuThich.setAdapter(adapterBaihatYeuThich);
        giaLapBaiHat();
    }

    private void giaLapBaiHat() {
        dsBaiHatGoc.add(new Music("BH1","Yêu cái cc","NAm Bò",true));
        dsBaiHatGoc.add(new Music("BH1","Yêu cái cc","NAm Bò",false));
        dsBaiHatGoc.add(new Music("BH1","Yêu cái cc","NAm Bò",false));
        dsBaiHatGoc.add(new Music("BH1","Yêu cái cc","NAm Bò",true));
        adapterBaihatGoc.notifyDataSetChanged();
    }
}
