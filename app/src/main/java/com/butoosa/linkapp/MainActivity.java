package com.butoosa.linkapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.butoosa.linkapp.adapters.LinksAdapter;
import com.butoosa.linkapp.models.Links;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String json_url = "https://butoosa.online/androidApp/mugume.php";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Links> linkList;
    private RecyclerView recyclerView;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        linkList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);


        jsonReq();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void jsonReq() {
        request = new JsonArrayRequest(json_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject object = null;
                for (int i =0; i < response.length(); i++){
                    try {
                        object = response.getJSONObject(i);
                        Links link = new Links();
                        link.setId(object.getString("id"));
                        link.setTitle(object.getString("title"));
                        link.setLink(object.getString("link"));
                        link.setDescription(object.getString("description"));

                        linkList.add(link);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(linkList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void setUpRecyclerView(List<Links> linkList) {
        LinksAdapter viewAdapter = new LinksAdapter(this,linkList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(viewAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
