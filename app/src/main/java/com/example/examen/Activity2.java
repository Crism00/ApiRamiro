package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity2 extends AppCompatActivity {
    private RequestQueue cola;
    ArrayList<ganadores> listaGanadores = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        cola=SingletonRequest.getInstance(Activity2.this).getRequestQueue();
        recyclerView = findViewById(R.id.reciclador);
        pedirGanadores();
    }

    public void setAdaptador(numerosAdaptador adapter){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
    public void pedirGanadores(){
        String url="https://ramiro.uttics.com/api/ganadores";

        /*JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("Nombre", "Ramiro");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest peticion = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String >();
                headers.put("","");
                return headers;
            }
        };*/

        JsonObjectRequest pedirGanadores = new JsonObjectRequest (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                results results1 = gson.fromJson(String.valueOf(response), results.class);
                List<ganadores> ganadores1 = results1.getData();
                numerosAdaptador adapter = new numerosAdaptador((ArrayList<ganadores>) ganadores1);
                setAdaptador(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.toString());
            }
        });
        cola.add(pedirGanadores);
    }
}
