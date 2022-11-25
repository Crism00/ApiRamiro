package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int suma=0;
    Button bt1, bt2;
    private RequestQueue cola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cola=SingletonRequest.getInstance(MainActivity.this).getRequestQueue();
        bt1=findViewById(R.id.boton1);
        bt1.setOnClickListener(this::onClick);
        bt2=findViewById(R.id.boton2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
    }

    public void pedirNumero(){

        String url="https://ramiro.uttics.com/api/numero";
        JsonObjectRequest pedirNumero = new JsonObjectRequest (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                TextView numero = (TextView) findViewById(R.id.numero);
                Gson gson = new Gson();
                numero numero1 = gson.fromJson(String.valueOf(response), numero.class);
                int a = numero1.getNumero();
                suma=suma+a;
                numero1.setSuma(suma);
                numero.setText(String.valueOf(suma));

                if(suma>21){
                    numero.setText("Has perdido");
                    suma=0;
                }
                if(suma==21){
                    numero.setText("Has ganado");
                    suma=0;
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.toString());
            }
        });
        cola.add(pedirNumero);

    }

    @Override
    public void onClick(View view) {
        pedirNumero();
    }
}