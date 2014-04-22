package ru.sibek.carssier;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Developer on 22.04.2014.
 */
public class AdapterClass  extends ArrayAdapter<ObjectDrawerItem> {
    Context context;
    ObjectDrawerItem[] data = null;

    public AdapterClass(Context context, ObjectDrawerItem[] data) {
        super(context, R.layout.list_item, data);
        this.context = context;
        this.data= data;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItem = convertView;


       // LayoutInflater inflater = ((Activity)(context.g.getActivity()).getLayoutInflater();
        LayoutInflater inflater = LayoutInflater.from(context);
        listItem = inflater.inflate(R.layout.list_item, parent, false);
        LinearLayout layout = (LinearLayout) listItem.findViewById(R.id.linear_layout_navitem);
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.drawer_item_icon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.text1);

        ObjectDrawerItem folder = data[position];
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);
        for (short i=0;i<folder.icons.length;i++)
        {
            ImageView iv = new ImageView(context);
            //iv.setTag(folder.icons[i]);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* switch (Integer.getInteger(view.getTag().toString()))
                    {
                        case R.drawable.wait:
                        {*/
                            System.out.println("CLICK"+position);
                    Intent intent = new Intent(context, NewOrderActivity.class);
                    context.startActivity(intent);
                           /* break;
                        }
                    }*/

                }
            });
            iv.setClickable(true);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(lp);
            iv.setBackgroundColor(Color.parseColor("#fbf5f5"));
            if (i>0) iv.setPadding(15,0,0,0);
            iv.setImageResource(folder.icons[i]);
            layout.addView(iv);
        }

        return listItem;
    }
}