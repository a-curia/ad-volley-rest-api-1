package com.dbbyte.androidrestapi_1;

        import android.app.VoiceInteractor;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL = "https://jsonplaceholder.typicode.com/posts";
        String URL_SINGLE = "https://jsonplaceholder.typicode.com/posts/1";


        // REST API call
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Array of Documents
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("REST ERROR", error.toString());

                    }
                }
        );

        // Array of Document
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL_SINGLE,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("REST ERROR", error.toString());

                    }
                }

        );

//        requestQueue.add(objectRequest);
        requestQueue.add(arrayRequest);

    }
}
