package com.example.bai3_tuan6;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    ArrayList<Film> data = new ArrayList<>();
    int index=-1;
    private FilmAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    public void setControl(){
        listView1 = findViewById(R.id.list_film);
    }

    public void setEvent(){
        init();
        adapter = new FilmAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Film f = data.get(position);
                index = position;
                int img_film = f.getImg_film();
                String name_film_en = f.getName_film_en();
                String name_film_vn = f.getName_film_vn();
                int rating_star = f.getStar();
                Intent intent_trans = new Intent(MainActivity.this, EditFilm.class);
                intent_trans.putExtra("ImgFilm", img_film);
                intent_trans.putExtra("name_film_en", name_film_en);
                intent_trans.putExtra("name_film_vn", name_film_vn);
                intent_trans.putExtra("rating_star", rating_star);
                startActivityForResult(intent_trans,0);
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Delete Film");
                    alert.setMessage("Do you want to delete this film?");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(index>=0) {
                                data.remove(index);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Delete Successfully!", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(MainActivity.this, "Delete Unsuccessfully!", Toast.LENGTH_SHORT).show(); }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.create().show();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data1){
        super.onActivityResult(requestCode, resultCode, data1);
        switch (requestCode){
            case 0:
                if(resultCode == RESULT_OK) {
                    String get_name_film_en = data1.getStringExtra("name_film_en");
                    String get_name_film_vn = data1.getStringExtra("name_film_vn");
                    int get_rating_star = data1.getIntExtra("rating_star",  0);
                    data.get(index).setName_film_en(get_name_film_en);
                    data.get(index).setName_film_vn(get_name_film_vn);
                    data.get(index).setStar(get_rating_star);
                    Log.d("Rating star recv", String.valueOf(get_rating_star));
                    Toast.makeText(MainActivity.this, "Edit Successfully!",Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
        }
    }

    private void init() {
        data.add(new Film(R.drawable.wonderwoman,"Wonder Women","Nữ thần chiến binh", 4));
        data.add(new Film(R.drawable.avengersendgame, "Avengers: Endgame", "Avengers: Hồi kết", 3));
        data.add(new Film(R.drawable.aa, "Annabelle: Comes Home", "Annabelle: Về nhà", 3));
    }
}
