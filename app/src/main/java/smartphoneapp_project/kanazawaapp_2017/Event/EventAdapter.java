package smartphoneapp_project.kanazawaapp_2017.Event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import smartphoneapp_project.kanazawaapp_2017.R;

public class EventAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Event> eventList;

    public EventAdapter(Context context, ArrayList<Event> eventList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.eventList = eventList;
    }

    @Override
    public int getCount(){
        return eventList.size();
    }

    @Override
    public Object getItem(int position){
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = layoutInflater.inflate(R.layout.event_listview_cell, parent, false);

        TextView nameView = convertView.findViewById(R.id.titleTextView);
        nameView.setText(eventList.get(position).getName());

        TextView hobbyView = convertView.findViewById(R.id.datesTextView);
        hobbyView.setText(eventList.get(position).getHobby());

        TextView detailsView = convertView.findViewById(R.id.descriptionTextView);
        detailsView.setText(eventList.get(position).getDetails());

        return convertView;
    }
}
