package com.example.cnec.listarlivros;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by CNEC on 02/10/2018.
 */

public class ConsultarServico extends AsyncTask<String, Void, String> {

    private MainActivity ma;

    public ConsultarServico(MainActivity ma) {
        this.ma = ma;
    }


    @Override
    protected String doInBackground(String... objects) {

        Log.d("Livro:", objects[0]);

        System.out.println("Buscar os dados..");

        URL url;
        HttpURLConnection urlConnection = null;

        String r = new String();
        try {

            if(objects[0]!=null) {
                String nomeLivroCodificado = URLEncoder.encode(objects[0], "UTF-8");

                url = new URL("http://10.0.2.2:80//android/json1/listar_livros.php?nome=" + nomeLivroCodificado);
            } else{
                url = new URL("http://10.0.2.2:80//android/json1/listar_livros.php");
            }
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();

                r += current;

            }
        } catch (Exception e) {
            Log.d("Erro: ", e.toString());

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return r;

    }


    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);


        ma.exibirListagem(o);
    }
}
