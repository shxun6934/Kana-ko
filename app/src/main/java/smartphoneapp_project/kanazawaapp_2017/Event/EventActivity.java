package smartphoneapp_project.kanazawaapp_2017.Event;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

        TextView mapbutton = (TextView) findViewById(R.id.back);
        TextView webbutton = (TextView) findViewById(R.id.web);
        mapbutton.setOnClickListener(this);
        webbutton.setOnClickListener(this);

        try {
            new estAsycTask().execute(new URL("http://www.utatsu-kogei.gr.jp/event.json"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    class estAsycTask extends AsyncTask<URL, Void, String> implements AdapterView.OnItemClickListener{
        @Override
        protected String doInBackground(URL... urls) {
            final StringBuilder result = new StringBuilder();
            final URL url = urls[0];

            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.setDoInput(true);
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
            ListView listView = (ListView) findViewById(R.id.listView);

            String fileText = s.toString();
            try {
                JSONObject rootObject = new JSONObject(fileText);
                eventArray = rootObject.getJSONArray("items");

                ArrayList<Event> items = new ArrayList<>();
                for (int i = 0; i < eventArray.length(); i++) {
                    JSONObject jsonobject = eventArray.getJSONObject(i);
                    items.add(new Event(jsonobject.getString("title"), "　　日程：" + jsonobject.getString("date_from") + " ~ " + jsonobject.getString("date_to"), jsonobject.getString("description")));
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
                    String url = "http://www.utatsu-kogei.gr.jp/" + jsonobject.getString("link");
                    Intent eventpage = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(eventpage);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void onClick(View v) {
        Intent map = new Intent(EventActivity.this, MapActivity.class);
        Intent homepage = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.utatsu-kogei.gr.jp/"));
        switch (v.getId()){
            case R.id.back:
                startActivity(map);
                break;

            case R.id.web:
                startActivity(homepage);
                break;
        }
    }
}

