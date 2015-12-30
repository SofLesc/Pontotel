package estagio.pontotel;

/**
 * Created by Sofía on 29/12/2015.
 */

import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ConsumerAdapter extends ArrayAdapter<Consumer> {

    public ConsumerAdapter(Context context, ArrayList<Consumer> consumers) {
        super(context, 0, consumers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the jsonData item
        Consumer consumer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.adapter_consumer_item, parent, false);
        }
        // Populate the jsonData into the template view using the jsonData object
        TextView tvId = (TextView) view.findViewById(R.id.tvId);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvPwd = (TextView) view.findViewById(R.id.tvPwd);
        tvId.setText("ID: " + consumer.getId());
        tvName.setText("Name: " + consumer.getName());
        tvPwd.setText("Pwd: " + consumer.getPwd());

        return view;
    }

}

