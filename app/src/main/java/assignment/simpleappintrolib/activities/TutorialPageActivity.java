package assignment.simpleappintrolib.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import assignment.hashem.easyappintro.controller.TutorialPageController;
import assignment.simpleappintrolib.fragments.FragmentPageOne;
import assignment.simpleappintrolib.fragments.FragmentPageTwo;

public class TutorialPageActivity extends TutorialPageController {

    private static final FragmentPageOne fragmentPageOne = FragmentPageOne.createNewInstance();
    private static final FragmentPageTwo fragmentPageTwo = FragmentPageTwo.createNewInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this is the method we have defined in the TutorialPageController
        // this method has to be called during the life-cycle method otherwise there will be
        // no pages to show
        // Basically, what this method is doing is adding the fragment and
        // passing the fragments to the tutorial pager
        // the tutorial pager gets the list of fragments that it needed to be initialized onCreate
        // life cycle method of TutorialPageController
        // then tutorialPager passing it to itself, where the setListOfFragments adds these fragments
        // to the list and passes to getItem() method
        addFragments(fragmentPageOne);
        addFragments(fragmentPageTwo);
    }
}
