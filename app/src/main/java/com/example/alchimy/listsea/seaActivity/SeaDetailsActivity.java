package com.example.alchimy.listsea.seaActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alchimy.listsea.R;
import com.example.alchimy.listsea.activity.SeaActivity;
import com.example.alchimy.listsea.adapters.SeaActivityAdapter;

public class SeaDetailsActivity extends Activity {
    private TextView seaOrder;
    private TextView seaCountry;
    private TextView seaCity;
    private TextView seaHotel;
    private TextView seaPrice;
    private ImageView seaImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dominican_layout);

        seaOrder = (TextView) findViewById(R.id.seaOrder);
        seaCountry = (TextView) findViewById(R.id.seaCountry);
        seaCity = (TextView) findViewById(R.id.seaCity);
        seaHotel = (TextView) findViewById(R.id.seaHotel);
        seaPrice = (TextView) findViewById(R.id.seaPrice);
        seaImage = (ImageView) findViewById(R.id.seaIamge);

        seaOrder.setText(String.valueOf((getIntent().getIntExtra("order",0))));
        seaCountry.setText(getIntent().getStringExtra("country"));
        seaCity.setText(getIntent().getStringExtra("city"));
        seaHotel.setText(getIntent().getStringExtra("hotel"));
        seaPrice.setText(String.valueOf((getIntent().getIntExtra("price",4))));
        String imageUrl = getIntent().getStringExtra("image");

        Glide.with(this).load(imageUrl)
                .into(seaImage);

    }

    public void onBack(View v) {
        Intent intent = new Intent(this, SeaActivityAdapter.class);
        startActivity(intent);
    }

}
