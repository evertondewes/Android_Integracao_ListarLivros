package com.example.cnec.listarlivros;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListarLivros(View v){

        ConsultarServico c = new ConsultarServico(this);

        EditText et = findViewById(R.id.tvNomeLivro);

        c.execute(et.getText().toString());
    }
    public void exibirListagem(String o) {
        try {
            JSONArray jsonArray = new JSONArray(o);
            TableLayout tl = findViewById(R.id.tl);
            tl.removeAllViews();

            TextView twId = new TextView(this);
            twId.setText("Id");
            twId.setTextSize(30);

            TextView twNome = new TextView(this);
            twNome.setText("Ano");
            twNome.setTextSize(30);

            TextView twAno = new TextView(this);
            twAno.setText("Nome");
            twAno.setTextSize(30);

            TableRow tr = new TableRow(this);

            tr.addView(twId);
            tr.addView(twAno);
            tr.addView(twNome);
            tl.addView(tr);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject JSONLivro = jsonArray.getJSONObject(i);

                twId = new TextView(this);
                twId.setText(JSONLivro.get("id").toString());
                twId.setTextSize(30);

                twNome = new TextView(this);
                twNome.setText(JSONLivro.get("nome").toString());
                twNome.setTextSize(30);

                twAno = new TextView(this);
                twAno.setText(JSONLivro.get("ano").toString());
                twAno.setTextSize(30);

                tr = new TableRow(this);

                tr.addView(twId);
                tr.addView(twAno);
                tr.addView(twNome);
                tl.addView(tr);
//                Log.d("Nome:", JSONLivro.get("nome").toString());
//                Log.d("Ano:", JSONLivro.get("ano").toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
