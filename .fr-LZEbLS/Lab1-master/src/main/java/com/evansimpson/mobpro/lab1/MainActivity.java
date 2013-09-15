package com.evansimpson.mobpro.lab1;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.evansimpson.mobpro.lab1.adaptor;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    row[] listItems = new row[] {};

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<row> adapter;

     @Override

     public void onCreate(Bundle Task) {
        super.onCreate(Task);
        setContentView(R.layout.activity_main);

        //Add Button
        final Button add = (Button) findViewById(R.id.addBtn);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.text_entry);
                String value = text.getText().toString();
                if (value.length() > 0){
                    addItems(v, value);
                    text.setText("");
                }else{
                    text.setText("Type Something");
                }
            }
        });

            adaptor adapter= new adaptor(this, R.layout.listview, listItems);
        setListAdapter(adapter);
    }

    //THIS IS WRONG.
    public void addItems(View v, row shit) {
        listItems = listItems + shit;
        adapter.notifyDataSetChanged();
    }

    public void removeItems(View v, int index) {
        listItems.remove(index);
        adapter.notifyDataSetChanged();
    }
}