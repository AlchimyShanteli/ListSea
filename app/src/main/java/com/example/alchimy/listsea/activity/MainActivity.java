package com.example.alchimy.listsea.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alchimy.listsea.R;
import com.example.alchimy.listsea.adapters.SeaActivityAdapter;
import com.example.alchimy.listsea.models.FileParser;
import com.example.alchimy.listsea.models.SeaModel;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    private SeaActivityAdapter seaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            seaAdapter = new SeaActivityAdapter(createSeaModelList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(seaAdapter);
    }

    private List<SeaModel> createSeaModelList() throws IOException {
        FileParser fileParser = new FileParser();
        return fileParser.loadFile(this);
    }


}
