package com.example.tp_lab_001;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class DataAdater extends RecyclerView.Adapter<DataAdater.MyViewHolder> {

    private List<String> mData;

    private LayoutInflater layoutInflater;
//    private int resource;
//    private TextView label;
    Context mContext;


    private final OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int i);
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;



        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d("test","EnterHolder");
            mTextView = itemView.findViewById(R.id.numbSet);

        }

        void bind (int i, final OnItemClickListener listener){
            String str = mData.get(i);
            if(Integer.parseInt(str)%2==0) {
                mTextView.setTextColor(mContext.getResources().getColor(R.color.red));
            }else {
                mTextView.setTextColor(mContext.getResources().getColor(R.color.blue));
            }
            Log.d("test","EnterBind"+str);
            mTextView.setText(str);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(i);
                }
            });


        }
    }

    public DataAdater (Context context, List<String> string,OnItemClickListener listener){
        this.mData = string;
        this.listener = listener;
        Log.d("test","EnterAdapter");
        this.mContext = context;
    }





    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.list_layout,viewGroup, false);
        Log.d("test","EnterCreate");
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i,listener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}


