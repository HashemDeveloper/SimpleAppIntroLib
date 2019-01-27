package assignment.simpleappintrolib.activities;

import android.support.v4.app.Fragment;

import assignment.simpleappintrolib.fragments.FragmentHomePage;

public class SampleActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {

        return FragmentHomePage.createNewInstance();
    }
}
