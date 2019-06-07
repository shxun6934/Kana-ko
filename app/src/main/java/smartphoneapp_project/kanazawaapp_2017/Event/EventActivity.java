package smartphoneapp_project.kanazawaapp_2017.Event;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import smartphoneapp_project.kanazawaapp_2017.MapActivity;
import smartphoneapp_project.kanazawaapp_2017.R;

public class EventActivity extends Activity implements View.OnClickListener{

    JSONArray eventArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        TextView mapbutton = findViewById(R.id.mapBack);
        TextView webbutton = findViewById(R.id.toWeb);

        mapbutton.setOnClickListener(this);
        webbutton.setOnClickListener(this);

        try {
            new getAsyncTask().execute(new URL("https://info2api.city.kanazawa.ishikawa.jp/events"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    class getAsyncTask extends AsyncTask<URL, Void, String> implements AdapterView.OnItemClickListener {
        @Override
        protected String doInBackground(URL... urls) {
            final StringBuilder result = new StringBuilder();
            final URL url = urls[0];

            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.connect();

                final int status = con.getResponseCode();
                if (status == HttpURLConnection.HTTP_OK) {
                    final InputStream in = con.getInputStream();
                     final String encoding = "UTF8";
                    final InputStreamReader inReader = new InputStreamReader(in, encoding);
                    final BufferedReader bufReader = new BufferedReader(inReader);
                    String line = null;
                    while ((line = bufReader.readLine()) != null) {
                        result.append(line);
                    }
                    bufReader.close();
                    inReader.close();
                    in.close();
                }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (ProtocolException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (con != null) {
                    con.disconnect();
                }
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ListView listView = findViewById(R.id.listView);

            try {
                JSONObject rootObject = new JSONObject(s);
                eventArray = rootObject.getJSONArray("events");

                ArrayList<Event> items = new ArrayList<>();
                for (int i = 0; i < eventArray.length(); i++) {
                    JSONObject jsonobject = eventArray.getJSONObject(i);
                    items.add(new Event(jsonobject.getString("title"), jsonobject.getString("description")));
                }

                EventAdapter adapter
                        = new EventAdapter(EventActivity.this, items);

                listView.setAdapter(adapter);
                listView.setOnItemClickListener(this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            try {
                    JSONObject jsonobject = eventArray.getJSONObject(position);
                    String url = jsonobject.getString("url");
                    Intent eventpage = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(eventpage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClick(View v) {
        Intent map = new Intent(EventActivity.this, MapActivity.class);
        Intent homepage = new Intent(Intent.ACTION_VIEW, Uri.parse("https://info2.city.kanazawa.ishikawa.jp/www/event/index"));
        switch (v.getId()){
            case R.id.mapBack:
                startActivity(map);
                break;
            case R.id.toWeb:
                startActivity(homepage);
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}