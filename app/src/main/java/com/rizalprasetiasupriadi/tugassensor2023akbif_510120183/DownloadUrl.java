package com.rizalprasetiasupriadi.tugassensor2023akbif_510120183;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//NIM     :   10120183
//NAMA    :   RIZAL PRASETIA SUPRIADI
//KELAS   :   IF-5


public class DownloadUrl {

    public String retireveUrl(String url) throws IOException{
        String urlData = "";
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            URL getUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) getUrl.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";

            while ((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }

            urlData = sb.toString();
            bufferedReader.close();
        }catch (Exception e){
            Log.d("Exception", e.toString());
        } finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }
        return urlData;
    }
}
