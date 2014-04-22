package ru.sibek.carssier;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Developer on 22.04.2014.
 */
public class OrderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

public static OrderFragment newInstance(int sectionNumber) {
    OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
        }

public OrderFragment() {
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.order_layout);
    listView.setAdapter(new ArrayAdapter<String>(
            getActivity(),
            R.layout.orders_list_item,
            R.id.text_order_item,
            new String[]{
                    "ЗАО «РПЦ»\n# 666, от 21 января 2014",
                    "Честное яйцо\n# 14, от 21 января 2014",
                    "ЗАО «РПЦ»\n# 666, от 21 января 2014",
                    "Честное яйцо\n# 14, от 21 января 2014"
            }
    ));
      //  textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
        //return inflater.inflate(R.layout.fragment_order, container, false);
        return rootView;
        }

@Override
public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
        getArguments().getInt(ARG_SECTION_NUMBER));
        }
        }