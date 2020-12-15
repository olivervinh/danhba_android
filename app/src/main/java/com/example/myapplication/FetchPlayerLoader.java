package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FetchPlayerLoader extends AsyncTaskLoader<List<NguoiChoi>> {
    public FetchPlayerLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<NguoiChoi> loadInBackground() {
        String response = GetAPIfromLocalHost.getListPlayer();
        List <NguoiChoi>list =  new ArrayList<>();
        try{
            JSONObject dataJsonObject =  new JSONObject(response);
            JSONArray player = dataJsonObject.getJSONArray("data");
            for(int i=0;i<player.length();i++){
                JSONObject item= player.getJSONObject(i);
                String ten = item.getString("ten_dang_nhap");
                int diem = item.getInt("diem_cao_nhat");
                NguoiChoi nguoiChoi = new NguoiChoi(ten,diem);
                list.add(nguoiChoi);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
