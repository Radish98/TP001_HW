package com.example.tp_lab_001;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GeneralFragment.onTouchEventListener{


    Fragment genFrag, showFrag;
    FragmentTransaction fT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genFrag = new GeneralFragment();
        fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.generalFragment, genFrag);
        fT.commit();


    }

    @Override
    public void touchEvent(int i) {
        Toast.makeText(this,"nubmset"+i, Toast.LENGTH_SHORT).show();
        showFrag = new ShowFragment();
        fT = getSupportFragmentManager().beginTransaction();
        fT.addToBackStack(null);
        fT.replace(R.id.generalFragment, showFrag);

//            if(setNumb%2 ==0) ((TextView)showFrag.getView().findViewById(R.id.showNumb)).setTextColor(getResources().getColor(R.color.red));
//
//            else ((TextView)showFrag.getView().findViewById(R.id.showNumb)).setTextColor(getResources().getColor(R.color.blue));
        int setNumb = i+1;

        Bundle bundle = new Bundle();
        bundle.putInt("getInt", setNumb);
        showFrag.setArguments(bundle);
        fT.commit();
    }

}
