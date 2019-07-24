package com.jianghoy.cybercity2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    Context context;
    List<Event> eventList;
    public EventAdapter(Context context) {
        this.context = context;
        this.eventList = DataService.getEventData();
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int i) {
        return eventList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    /**
     * @Param View view: the old view to reuse
     * @Param ViewGroup viewGroup: the parent where this view will be attached to
     * @Return gets the view that displays in listView
     */
    public View getView(int i, View view, ViewGroup viewGroup) {

        // if view haven't set up, we have to init. it.
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
            view = layoutInflater.inflate(R.layout.event_item,viewGroup,false);
        }

        // if we have view already set up, use it.
        TextView eventName = view.findViewById(R.id.event_name);
        TextView eventAddress = view.findViewById(R.id.event_address);
        TextView eventDescription = view.findViewById(R.id.event_description);

        Event event = eventList.get(i);
        eventName.setText(event.getTitle());
        eventAddress.setText(event.getAddress());
        eventDescription.setText(event.getDescription());

        return view;


    }
}
