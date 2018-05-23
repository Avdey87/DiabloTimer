package com.aavdeev.diablo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements ListDiabloClassFragment.ListDiabloClassListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View container = findViewById(R.id.containerDescription);
        if (container != null) {
            DescriptionDiabloClassFragment description = new DescriptionDiabloClassFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            description.setNameID(id);
            ft.replace(R.id.containerDescription, description);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
}
