package com.evansimpson.mobpro.ToDoList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zach on 9/11/13.
 */
public class TextAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> values;

    public TextAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_row_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.taskText);
        textView.setText(values.get(position));

        final Button button = (Button) rowView.findViewById(R.id.delBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                values.remove(position);
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
