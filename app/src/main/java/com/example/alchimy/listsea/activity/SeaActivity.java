package com.example.alchimy.listsea.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alchimy.listsea.R;

import butterknife.BindView;

public class SeaActivity extends Activity {

    @BindView(R.id.seaCity) TextView seaCity;
    @BindView(R.id.seaHotel) TextView seaHotel;
    @BindView(R.id.seaPrice) TextView seaPrice;
    @BindView(R.id.seaIamge) ImageView seaImage;
    @BindView(R.id.seaCountry) TextView seaCountry;
    @BindView(R.id.seaOrder) TextView seaOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);
    }

}

