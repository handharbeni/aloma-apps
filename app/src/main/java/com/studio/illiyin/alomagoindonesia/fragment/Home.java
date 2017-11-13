package com.studio.illiyin.alomagoindonesia.fragment;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studio.illiyin.alomagoindonesia.MenuTab.Kabar;
import com.studio.illiyin.alomagoindonesia.MenuTab.TransferPulsa;
import com.studio.illiyin.alomagoindonesia.R;

/**
 * Created by Mindha on 19/06/2017.
 */

public class Home extends Fragment implements android.support.design.widget.TabLayout.OnTabSelectedListener {
    View v;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ActionBar actionBar;
    private TabLayout TabLayout;
    private String[] tabs = { "Transfer Pulsa", "Kabar Burung", "History"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_satu, container, false);
        // getActivity().setTitle(R.string.app_name);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_activity_main_tab);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        TabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) v.findViewById(R.id.containers);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.addOnTabSelectedListener(this);

        final int[] ICONS = new int[]{
                R.drawable.transfer,
                R.drawable.burung,
                R.drawable.history
        };

        for (int i=0; i< tabs.length ; i++) {
            TabLayout.getTabAt(i).setIcon(getResources().getDrawable(ICONS[i]));
        }

        return v;
    }
    @Override
    public void onTabSelected(Tab tab) {
        String sTitle = "AlomaGo";
        switch (tab.getPosition()){
            case 0:
                sTitle = "Transfer Pulsa";
                break;
            case 1:
                sTitle = "Kabar Burung";
                break;
            case 2:
                sTitle = "History";
                break;
        }
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(sTitle);
    }

    @Override
    public void onTabUnselected(Tab tab) {

    }

    @Override
    public void onTabReselected(Tab tab) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    TransferPulsa tab1 = new TransferPulsa();
                    return tab1;
                case 1:
                    Kabar tab2 = new Kabar();
                    return tab2;
                case 2:
                    History tab3 = new History();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return tabs[0];
                case 1:
                    return tabs[1];
                case 2:
                    return tabs[2];
                default:
                    return "Aloma Go";
            }
        }
    }
}
