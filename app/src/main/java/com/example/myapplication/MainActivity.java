package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Contact;
import com.example.myapplication.ContactAdapter;
import com.example.myapplication.R;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Contact> mContacts;
    RecyclerView rycContacts;
    ContactAdapter conAdp;
    FetchPlayerLoader fetchPlayerLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContacts = new LinkedList<Contact>();

        for(int i = 1 ; i<=10; i++){
            Contact x = new Contact();
            x.setName("Name"+i);
            x.setSdt("00000000"+i);
            this.mContacts.add(x);
        }

        rycContacts = findViewById(R.id.recyler);
        conAdp = new ContactAdapter(this,mContacts);
        rycContacts.setAdapter(conAdp);

        rycContacts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void AddContact(View view) {
        TextView name = findViewById(R.id.etxtName);
        TextView sdt = findViewById(R.id.etxtSdt);
        Contact x = new Contact();
        x.setName(name.getText().toString());
        x.setSdt(sdt.getText().toString());
        this.mContacts.addFirst(x);
        conAdp.notifyItemInserted(0);
        rycContacts.smoothScrollToPosition(0);
    }
}