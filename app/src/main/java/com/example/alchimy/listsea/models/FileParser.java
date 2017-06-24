package com.example.alchimy.listsea.models;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileParser {
    private final String TAG = getClass().getSimpleName();

    public List<SeaModel> loadFile(Context context) throws IOException {
        try {
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("imagesForAplication/listHotel"));
            BufferedReader in = new BufferedReader(istream);

            StringBuilder allContentFromFile = new StringBuilder();
            String word;

            while ((word = in.readLine()) != null) {
                allContentFromFile.append(word);
            }
            in.close();
            String result = allContentFromFile.toString();

            return splitContent(result);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "loadFile: ", e);
        } catch (IOException e) {
            Log.e(TAG, "loadFile: ", e);
        }
        return null;
    }

    private List<SeaModel> splitContent(String fileContent) {
        String[] resultLines = fileContent.split(";");
        Log.d(TAG, "splitContent: " + resultLines.length);
        return splitLine(resultLines);
    }

    private List<SeaModel> splitLine(String[] separLines) {
        List<SeaModel> seaModels = new ArrayList<>();
        for (int i = 0; i < separLines.length; i++) {
            String[] split = separLines[i].split(",");
            String price = split[4].replaceAll("\\s+", "");
            String order = split[0].replaceAll("\\s+", "");


            seaModels.add(new SeaModel(split[2], split[3], split[5], Integer.parseInt(price),
                    Integer.parseInt(order), split[1]));
        }
        return seaModels;
    }
}






