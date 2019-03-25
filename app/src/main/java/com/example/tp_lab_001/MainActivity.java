package com.example.tp_lab_001;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GeneralFragment.onTouchEventListener {


    Fragment genFrag, showFrag;
    FragmentTransaction fT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            genFrag = new GeneralFragment();
            fT = getSupportFragmentManager().beginTransaction();
            fT.add(R.id.generalFragment, genFrag);
            fT.commit();
        }
    }

    @Override
    public void touchEvent(int i) {
        showFrag = new ShowFragment();
        fT = getSupportFragmentManager().beginTransaction();
        fT.addToBackStack(null);
//        fT.remove(genFrag);
//        fT.add(R.id.generalFragment,showFrag);
        fT.replace(R.id.generalFragment, showFrag);
        int setNumb = i + 1;
        Bundle bundle = new Bundle();
        bundle.putInt("getInt", setNumb);
        showFrag.setArguments(bundle);
        fT.commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
