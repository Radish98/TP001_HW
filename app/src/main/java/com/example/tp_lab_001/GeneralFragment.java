package com.example.tp_lab_001;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class GeneralFragment extends Fragment {

    RecyclerView myRecycler;
    TextView numbSet;
    Button addNumb;
    private ArrayList<String> strings;

    public interface onTouchEventListener{
        public void touchEvent(int i);
    }

    onTouchEventListener touchEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            touchEventListener = (onTouchEventListener) activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ "must implements onTouuchEventListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_general, container, false);
        strings = new ArrayList<>();

        fillList(strings);

        Log.d("test", " size " + strings.size());

        addNumb = view.findViewById(R.id.addNumb);
        myRecycler = view.findViewById(R.id.myRecycler);
//
//        setGrid(3);

        final GridLayoutManager gridManager = new GridLayoutManager(view.getContext(), 3);
        myRecycler.setLayoutManager(gridManager);


        final DataAdater mAdapter = new DataAdater(view.getContext(), strings, new DataAdater.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {

                touchEventListener.touchEvent(i);
            }
        });

        myRecycler.setAdapter(mAdapter);

        numbSet = view.findViewById(R.id.numbSet);




        addNumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newNubm = strings.size()+1;
                strings.add(Integer.toString(newNubm));
                mAdapter.notifyItemChanged(strings.size());
                Log.d("test","tag");
            }
        });


        return view;
    }

    private void fillList(List<String> string) {
        for (int i = 1; i < 1001; i++) {
            string.add(i + "");
        }

    }

}
