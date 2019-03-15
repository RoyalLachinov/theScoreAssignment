package com.thescore.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.constraint.ConstraintLayout;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.thescore.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class ActivityPlayerTest {

    @Rule
    public ActivityTestRule<ActivityPlayer> playerActivityTestRule = new ActivityTestRule<ActivityPlayer>(ActivityPlayer.class);
    ActivityPlayer mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = playerActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

    @Test
    public void mIsRecylerViewNull(){
        //get the RecyclerView for checking is null or not
        RecyclerView mPlayerRecylerView = mActivity.findViewById(R.id.list_view_players);
        assertNotNull(mPlayerRecylerView);
    }

    @Test
    public void mIsImageViewNull(){
        //get the RecyclerView for checking is null or not
        ImageView mImageView = mActivity.findViewById(R.id.img_team_logo);
        assertNotNull(mImageView);
    }

    @Test
    public void mIsTextViewNameNull(){
        //get the RecyclerView for checking is null or not
        TextView mTextView = mActivity.findViewById(R.id.txt_team_name);
        assertNotNull(mTextView);
    }

    @Test
    public void mIsTextViewPointNull(){
        //get the RecyclerView for checking is null or not
        TextView mTextView = mActivity.findViewById(R.id.txt_win_lose);
        assertNotNull(mTextView);
    }
}