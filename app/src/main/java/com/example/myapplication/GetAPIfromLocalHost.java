package com.example.myapplication;

import android.net.Uri;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetAPIfromLocalHost {


    public static String getListPlayer() {
        Uri duongDan = Uri.parse("http://10.0.2.2/androidAPI/public/nguoi-choi");
        try {
            URL denghiURL = new URL(duongDan.toString());
            return callAPI(denghiURL,"GET");
        } catch (MalformedURLException e) {
            return null;
        }

    }
    public static String callAPI(URL denghi, String method) {
        HttpURLConnection httpURLConnection = null;
        String result = "";
        try {
            httpURLConnection = (HttpURLConnection) denghi.openConnection();
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            result = convertISToString(inputStream);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return  result;
    }

    private static String convertISToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer builder = new StringBuffer();
        String line ;
        try
        {
            while((line=reader.readLine())!=null){
                builder.append(line+"\n");
            }
        }
        catch (IOException ex){
            return null;

        }
        if(builder.length()==0){
            return null;
        }
        return builder.toString();
    }
}
