package com.evansimpson.mobpro.lab1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

class row {
    public int button;
    public String task;
    public row(){
        super();
    }

    public row(int button, String task) {
        super();
        this.button = button;
        this.task = task;
    }
}
public class adaptor extends ArrayAdapter<row> {

    Context context;
    int layoutResourceId;
    row data[] = null;

    public adaptor(Context context, int layoutResourceId, row[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        rowHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new rowHolder();
            holder.button = (Button)row.findViewById(R.id.delBtn);
            holder.txtTitle = (TextView)row.findViewById(R.id.task);

            row.setTag(holder);
        }
        else
        {
            holder = (rowHolder)row.getTag();
        }

        row Row = data[position];
        holder.txtTitle.setText(Row.task);
        holder.button = (Button)row.findViewById(R.id.delBtn);

        holder.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Integer index = (Integer) v.getTag();
                //removeItems(v, index.intValue());
                int j = 0;
            }
        });
        return row;
    }

    static class rowHolder
    {
        Button button;
        TextView txtTitle;
    }
}