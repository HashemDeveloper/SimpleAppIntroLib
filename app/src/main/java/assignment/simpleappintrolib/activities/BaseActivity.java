package assignment.simpleappintrolib.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import assignment.simpleappintrolib.R;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_fragment_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_sample_main_layout_id);

        if(fragment == null){

            fragment = createFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_sample_main_layout_id, fragment)
                    .commit();
        }
    }
}
