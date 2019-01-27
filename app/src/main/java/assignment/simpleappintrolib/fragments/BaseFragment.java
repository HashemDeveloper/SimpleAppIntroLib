package assignment.simpleappintrolib.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import assignment.simpleappintrolib.utils.Constants;

public class BaseFragment extends Fragment {

    protected SharedPreferences globalSharedPreference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getActivity() != null){

            globalSharedPreference = getActivity().getSharedPreferences(Constants.SHARED_PREFERENCE_INFO, Context.MODE_PRIVATE);
        }
    }
}
