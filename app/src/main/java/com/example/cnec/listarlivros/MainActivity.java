package com.example.cnec.listarlivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListarLivros(View v){
        ConsultarServico c = new ConsultarServico();
        c.execute();
    }
}
