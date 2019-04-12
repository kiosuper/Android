package com.example.bai3_tuan6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class EditFilm extends AppCompatActivity {

    private ImageView imgFilmEdit;
    private EditText name_film_en_edit;
    private EditText name_film_vn_edit;
    private RatingBar rating_star_edit;
    private Button btn_ok;
    private Button btn_cancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_film);
        setControl();
        setEvent();
    }

    public void setControl(){
        imgFilmEdit = findViewById(R.id.img_film_edit);
        name_film_en_edit = findViewById(R.id.name_film_en_edit);
        name_film_vn_edit = findViewById(R.id.name_film_vn_edit);
        rating_star_edit = findViewById(R.id.rating_star_edit);
        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
    }

    public void setEvent(){
        Intent intent_recv = this.getIntent();
        final int imgFilm = intent_recv.getIntExtra("ImgFilm",0);
        String name_film_en = intent_recv.getStringExtra("name_film_en");
        String name_film_vn = intent_recv.getStringExtra("name_film_vn");
        int rating_star = intent_recv.getIntExtra("rating_star", 0);
        imgFilmEdit.setImageResource(imgFilm);
        name_film_en_edit.setText(name_film_en);
        name_film_vn_edit.setText(name_film_vn);
        rating_star_edit.setRating(rating_star);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_trans = new Intent(EditFilm.this, MainActivity.class);
                intent_trans.putExtra("name_film_en", name_film_en_edit.getText().toString());
                intent_trans.putExtra("name_film_vn", name_film_vn_edit.getText().toString());
                intent_trans.putExtra("rating_star", (int)rating_star_edit.getRating());
                Log.d("Rating star trans", String.valueOf(rating_star_edit.getRating()));
                setResult(RESULT_OK, intent_trans);
                finish();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
