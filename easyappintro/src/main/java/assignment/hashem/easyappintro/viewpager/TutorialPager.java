package assignment.hashem.easyappintro.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public final class TutorialPager extends FragmentStatePagerAdapter {


    private List<Fragment> listOfFragments;

    /**
     * <p>The following constructor must be called in TutorialPageController on onCreateView</p>
     * <p>Before setting up on the viewPager adapter</p>
     * @param fm
     * @param fragmentList
     */
    public TutorialPager(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.listOfFragments = fragmentList;

        // checking for nullPointerException
        if (listOfFragments != null && !listOfFragments.isEmpty()) {

            // adding the fragments while constructor is being initialized
            // at onCreateView in TutorialPageController
            // so we can get fragments by calling the getListOfFragments()
            setListOfFragments(listOfFragments);
        }
    }

    /**
     *<p>Returns lists of fragments</p>
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        return getListOfFragments().get(position);
    }

    /**
     * <p>Adding fragments dynamically</p>
     * @param listOfFragments
     */
    private void setListOfFragments(List<Fragment> listOfFragments) {

        this.listOfFragments.clear();
        this.listOfFragments.addAll(listOfFragments);
        notifyDataSetChanged();
    }

    private List<Fragment> getListOfFragments() {
        return listOfFragments;
    }

    /**
     *
     * @return number ofr fragments it's holding.
     */
    @Override
    public int getCount() {

        return getListOfFragments().size();
    }
}
