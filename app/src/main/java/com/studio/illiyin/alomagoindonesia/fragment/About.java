package com.studio.illiyin.alomagoindonesia.fragment;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.studio.illiyin.alomagoindonesia.MainActivityTab;
        import com.studio.illiyin.alomagoindonesia.R;

/**
 * Created by Mindha on 16/06/2017.
 */

public class About extends Fragment{
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_about,container,false);
        getActivity().setTitle("About");
        return myView;

    }


}
