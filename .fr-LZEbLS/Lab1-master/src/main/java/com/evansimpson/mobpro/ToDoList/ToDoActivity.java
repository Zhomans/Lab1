package com.evansimpson.mobpro.ToDoList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class ToDoActivity extends ListActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override

    public void onCreate(Bundle Task) {
        super.onCreate(Task);
        setContentView(R.layout.todolist);

        final Button button = (Button) findViewById(R.id.addBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.text_entry);
                String value = text.getText().toString();
                if (value.length() > 0) {
                    addItems(v, value);
                    text.setText("");
                }
            }
        });

        adapter = new TextAdapter(this, listItems);
        setListAdapter(adapter);
    }


    public void addItems(View v, String task) {
        listItems.add(task);
        adapter.notifyDataSetChanged();
    }
}