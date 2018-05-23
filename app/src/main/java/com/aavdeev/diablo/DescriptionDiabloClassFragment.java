package com.aavdeev.diablo;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionDiabloClassFragment extends Fragment {

    private long nameID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            nameID = savedInstanceState.getLong("nameID");
        } else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            WatchFragment watch = new WatchFragment();
            ft.replace(R.id.containerWatch, watch);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        return inflater.inflate(R.layout.fragment_description_diablo_class, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            DiabloClass diabloClass = DiabloClass.listClass[(int) nameID];
            TextView name = view.findViewById(R.id.nameDiabloClass);
            name.setText(diabloClass.getName());
            TextView description = view.findViewById(R.id.descriptionDiabloClass);
            description.setText(diabloClass.getDescrption());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("nameID",nameID);
    }

    public void setNameID(long nameID) {
        this.nameID = nameID;
    }
}
