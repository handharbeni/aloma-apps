package com.studio.illiyin.alomagoindonesia.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studio.illiyin.alomagoindonesia.MenuTab.SignIn;
import com.studio.illiyin.alomagoindonesia.MenuTab.SignUp;
import com.studio.illiyin.alomagoindonesia.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Mindha on 19/06/2017.
 */

@SuppressLint("ValidFragment")
public class Registration extends Fragment{
    View v;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private String test;

    @SuppressLint("ValidFragment")
    public Registration(String test) {
        this.test = test;
        Log.d(TAG, "Registration: "+this.test);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dua, container, false);
        getActivity().setTitle("Registration");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) v.findViewById(R.id.containers);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return v;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    SignIn tab1 = new SignIn();
                    return tab1;
                case 1:
                    SignUp tab2 = new SignUp();
                    return tab2;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sign In";
                case 1:
                    return "Sign Up";
            }
            return null;
        }
    }


}
