package assignment.hashem.easyappintro.controller;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import assignment.hashem.easyappintro.R;
import assignment.hashem.easyappintro.viewpager.TutorialPager;

public abstract class TutorialPageController extends AppCompatActivity implements
        ViewPager.OnPageChangeListener, View.OnClickListener {

    private List<Fragment> listOfFragments;
    private TutorialPager tutorialPager;
    private boolean isFinish;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppCompatButton nextBt;
    private AppCompatButton previousBt;
    private Drawable doneImage;
    private Drawable nextImage;

    public TutorialPageController(){

        this.listOfFragments = new ArrayList<>();
    }

    /**
     * <p>Call this method to add fragments</p>
     * <p>And notify Data changed otherwise viewpager adapter will not get notified</p>
     * <p>as a result view pager will always return 0, and will throw Exception</p>
     * @param fragment
     */
    public void addFragments(Fragment fragment){

        this.listOfFragments.add(fragment);
        this.tutorialPager.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_intro_page_layout);

        this.viewPager = findViewById(R.id.fragment_app_intro_view_pager_id);
        this.nextBt = findViewById(R.id.fragment_app_intro_next_bt_id);
        this.previousBt = findViewById(R.id.fragment_app_intro_previous_bt_id);
        this.tabLayout = findViewById(R.id.fragment_app_intro_tab_layout_id);

        this.doneImage = getResources().getDrawable(R.drawable.ic_done_black_24dp);
        this.doneImage.setBounds(0, 0, 60, 60);
        this.nextImage = getResources().getDrawable(R.drawable.ic_go_forward_24dp);
        this.nextImage.setBounds(0, 0, 60, 60);

        this.nextBt.setOnClickListener(this);
        this.previousBt.setOnClickListener(this);

        // initializing the TutorialPager
        this.tutorialPager = new TutorialPager(getSupportFragmentManager(), listOfFragments);

        this.viewPager.setAdapter(tutorialPager);
        this.tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(tutorialPager.getCount());

        viewPager.addOnPageChangeListener(this);

        // updating button on start.
        updateButtonStatus();
    }

    /**
     *
     * @param i position of the page
     * @param v
     * @param i1
     */
    @Override
    public void onPageScrolled(int i, float v, int i1) {

        // getting the total number of page first
        int count = this.tutorialPager.getCount();

        // and each time the page scrolls we increment the position by 1
        //so, when the position will hit the end point, the value will match with the
        // value of count, meaning this is the last page
        int incrementPositionByOne = i + 1;

        if(incrementPositionByOne == count){

            // at the end of the page
            this.isFinish = true;
            // switch image icon on nextBt from icon-forward to icon-done
            nextBt.setCompoundDrawables(doneImage, null, null, null);


            // otherwise, if position is less then count
            // switch the icon of nextBt back to it's previous state
        }else if(incrementPositionByOne < count){

            nextBt.setCompoundDrawables(nextImage, null, null, null);
            this.isFinish = false;
        }
    }

    /**
     *
     * @param i
     *<p>if the position is less then or equal to zero
     * the previousBt will not be shown
     * otherwise, it will be visible so user can
     * navigate back to previous page</p>
     */
    @Override
    public void onPageSelected(int i) {

        previousBt.setVisibility(i <= 0 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == this.previousBt.getId()){

            if(this.previousBt.getVisibility() == View.VISIBLE){

                // setting the current by the getting the current item of viewPager and
                // deducting it by 1, so it will always point to previous item/page
                if(viewPager != null)
                this.viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        }

        if(v.getId() == this.nextBt.getId()){

            // Adding one to the position of current item to point to next page/item
            if(viewPager != null)
            this.viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

            // now if there's no pages left,
            // the done button should appear
            // and the boolean state should be true
            // thereby, if user preses done, it should destroy the view
            /// and proceed to the homepage activity

            if(isFinish){

               finish();
            }
        }
    }


    /**
     * <p>Updates the button status on start</p>
     */
    private void updateButtonStatus(){

        int position = viewPager.getCurrentItem();

        if(tutorialPager != null)
        if(position == tutorialPager.getCount()){

            nextBt.setCompoundDrawables(null, null, doneImage, null);
        }

        previousBt.setVisibility(position <= 0 ? View.INVISIBLE : View.VISIBLE);
    }
}
