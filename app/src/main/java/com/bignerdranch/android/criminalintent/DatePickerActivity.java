package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by anastasia on 20/10/15.
 */
public class DatePickerActivity extends SingleFragmentActivity {

    private static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, Date date) {
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Date date = (Date)getIntent().getSerializableExtra(EXTRA_DATE);
        Fragment newF = DatePickerFragment.newInstance(date);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newF)
                .commit();

    }

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_DATE);
        return DatePickerFragment.newInstance(date);
    }


}
