package com.example.georgi.mehadapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgi on 11/19/14.
 */
public class IvoAdapter extends BaseAdapter {

    public void add(Contact contact) {
        contactList.add(contact);
    }

    private final static class ViewHolder {
        public TextView name;
        public TextView number;
    }

    private List<Contact> contactList = new ArrayList<Contact>() {{
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));

        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
        add(new Contact("Ivo", "8521958", -1));
    }};

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup viewGroup) {
        ////

        LinearLayout layout = null;
        if (convertView != null) {
            layout = (LinearLayout) convertView;
        } else {
            layout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.linear_layout, null, false);

            TextView name = (TextView) layout.findViewById(R.id.name);
            TextView number = (TextView) layout.findViewById(R.id.number);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = name;
            viewHolder.number = number;

            layout.setTag(viewHolder);

            layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());

                    AlertDialog dialog = builder.setTitle("Dialog").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(viewGroup.getContext(), "Yes clicked", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("No", null).create();

                    dialog.show();
                    return false;
                }   
            });
        }


        Contact contact = contactList.get(position);
        ViewHolder holder = (ViewHolder) layout.getTag();
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());


        return layout;
    }
}
