package com.aavdeev.diablo;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDiabloClassFragment extends ListFragment {

    interface ListDiabloClassListener {
        void itemClicked(long id);
    }

    private ListDiabloClassListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] classList = new String[DiabloClass.listClass.length];
        for (int i= 0; i<classList.length; i++) {
            classList[i] = DiabloClass.listClass[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, classList);

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (ListDiabloClassListener) activity;
    }
}
