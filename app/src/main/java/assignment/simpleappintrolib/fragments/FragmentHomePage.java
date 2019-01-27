package assignment.simpleappintrolib.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import assignment.hashem.easyappintro.controller.TutorialPageController;
import assignment.simpleappintrolib.R;
import assignment.simpleappintrolib.activities.BaseActivity;
import assignment.simpleappintrolib.activities.TutorialPageActivity;
import assignment.simpleappintrolib.utils.Constants;

public class FragmentHomePage extends BaseFragment {

    private BaseActivity baseActivity;


    public static FragmentHomePage createNewInstance(){

        return new FragmentHomePage();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        globalSharedPreference.edit().remove(Constants.IS_APP_LAUNCHED_BEFORE).apply();
        boolean isFirstTime = Constants.isHomepageRunningFirstTime(baseActivity);

        // so here we check if this fragment/activity running for the first time
        // if true, the activity/fragment will call the TutorialPageActivity, else not.
        if(isFirstTime){

            Intent intent = new Intent(baseActivity, TutorialPageActivity.class);
            baseActivity.startActivity(intent);

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page_layout, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        baseActivity = (BaseActivity) context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        baseActivity = null;
    }
}
