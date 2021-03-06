package com.example.bryan.studybuddies;
import java.util.ArrayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class contact_search extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    String[] names={"Andrew","Adam","Briana","Brittney","Mike","Nick","Tana"};
    int[] images={R.drawable.face1,R.drawable.face2,R.drawable.face3,R.drawable.face4,R.drawable.face5,R.drawable.face6,R.drawable.face7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_search);
        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView) findViewById(R.id.searchView1);
        //ADAPTER
        final contactAdapter adapter=new contactAdapter(this, getContacts());
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                // TODO Auto-generated method stub
                adapter.getFilter().filter(query);
                return false;
            }
        });

        registerForContextMenu(lv);
    }
    private ArrayList<contact> getContacts()
    {
        ArrayList<contact> contacts=new ArrayList<contact>();
        contact p;
        for(int i=0;i<names.length;i++)
        {
            p=new contact(names[i], images[i]);
            contacts.add(p);
        }
        return contacts;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_search_menu, menu);
        MenuItem item1 = menu.findItem(R.id.contact_message);
        Intent intent1 = new Intent(this, ChatActivity.class);
        item1.setIntent(intent1);

    }


}