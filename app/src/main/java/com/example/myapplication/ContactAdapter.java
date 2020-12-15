package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    public final LinkedList<Contact> mContacts;
    LayoutInflater mInflater;

    public ContactAdapter(Context context, LinkedList<Contact> mContacts) {
        this.mContacts = mContacts;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_layout,parent,false);
        return new ContactViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact curobj = this.mContacts.get(position);
        holder.txtName.setText(curobj.getName());
        holder.txtSdt.setText(curobj.getSdt());
    }

    @Override
    public int getItemCount() {
        return this.mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        public TextView txtName;
        public TextView txtSdt;
        public ContactAdapter mAdapter;


        public ContactViewHolder(@NonNull View itemView, ContactAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;
            this.txtName = itemView.findViewById(R.id.itxtName);
            this.txtSdt = itemView.findViewById(R.id.itxtSdt);

        }
    }
}
