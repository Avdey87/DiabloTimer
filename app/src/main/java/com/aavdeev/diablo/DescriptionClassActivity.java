package com.aavdeev.diablo;

import android.app.Activity;
import android.os.Bundle;

public class DescriptionClassActivity extends Activity {

    public static final String NAME_KEY_ID = "nameID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_class);

        int nameID = (int) getIntent().getExtras().get(NAME_KEY_ID);
        DescriptionDiabloClassFragment description = (DescriptionDiabloClassFragment) getFragmentManager().findFragmentById(R.id.activityDescription);
        description.setNameID(nameID);
    }
}
