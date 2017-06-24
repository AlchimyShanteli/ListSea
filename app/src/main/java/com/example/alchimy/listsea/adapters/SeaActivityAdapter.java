package com.example.alchimy.listsea.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alchimy.listsea.R;
import com.example.alchimy.listsea.models.SeaModel;
import com.example.alchimy.listsea.seaActivity.SeaDetailsActivity;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeaActivityAdapter extends RecyclerView.Adapter<SeaActivityAdapter.SeaViewHolder> {
    private List<SeaModel> seaModelList;
    private Context context;
    private final String TAG = getClass().getSimpleName();

    public SeaActivityAdapter(List<SeaModel> seaModelList) {

        this.seaModelList = seaModelList;
    }

    @Override
    public SeaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.activity_sea, parent, false);
        return new SeaViewHolder(v);

    }


    @Override
    public void onBindViewHolder(SeaViewHolder holder, int position) {
        holder.seaCity.setText(seaModelList.get(position).getNameCity());
        holder.seaHotel.setText(seaModelList.get(position).getNameHotel());
        holder.seaPrice.setText(String.valueOf(seaModelList.get(position).getPrice()));
        holder.seaOrder.setText(String.valueOf(seaModelList.get(position).getOrder()));
        holder.seaCountry.setText(seaModelList.get(position).getNameCountry());

//        Spannable text = new SpannableString(holder.seaCountry.getText());
//        text.setSpan(new StyleSpan(Typeface.BOLD),0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        text.setSpan(new StyleSpan(Typeface.ITALIC),0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        holder.seaCountry.setText(text);

        Glide.with(context).load(seaModelList.get(position).getImageUrl())
                .dontTransform()
                .into(holder.seaImage);
    }

    @Override
    public int getItemCount() {
        return seaModelList.size();
    }

    public class SeaViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.seaCity) TextView seaCity;
        @BindView(R.id.seaHotel) TextView seaHotel;
        @BindView(R.id.seaPrice) TextView seaPrice;
        @BindView(R.id.seaIamge) ImageView seaImage;
        @BindView(R.id.seaOrder) TextView seaOrder;
        @BindView(R.id.seaCountry) TextView seaCountry;

        public SeaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SeaDetailsActivity.class);
                    intent.putExtra("order", seaModelList.get(getAdapterPosition()).getOrder());
                    intent.putExtra("city", seaModelList.get(getAdapterPosition()).getNameCity());
                    intent.putExtra("hotel", seaModelList.get(getAdapterPosition()).getNameHotel());
                    intent.putExtra("country", seaModelList.get(getAdapterPosition()).getNameCountry());
                    intent.putExtra("price", seaModelList.get(getAdapterPosition()).getPrice());
                    intent.putExtra("image", seaModelList.get(getAdapterPosition()).getImageUrl());
                    context.startActivity(intent);
                }
            });

        }
    }
}

