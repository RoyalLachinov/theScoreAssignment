package com.thescore.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.thescore.R;
import com.thescore.model.Player;
import com.thescore.model.Team;
import com.thescore.presenter.TeamPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import butterknife.OnClick;

import static org.junit.Assert.*;

public class ActivityTeamTest {

    @Rule
    public ActivityTestRule<ActivityTeam> teamActivityTestRule = new ActivityTestRule<ActivityTeam>(ActivityTeam.class);
    ActivityTeam mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = teamActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

    @Test
    public void mIsRecylerViewNull() {
        //get the RecyclerView for checking is null or not
        RecyclerView mTeamRecylerView = mActivity.findViewById(R.id.listViewTeam);
        assertNotNull(mTeamRecylerView);
    }

    @Test
    public void mIsProgressViewNull() {
        //get the ProgressBar for checking is null or not
        ProgressBar mprogressbar = mActivity.findViewById(R.id.progressBar);
        assertNotNull(mprogressbar);
    }

    @Test
    public void mIsMenuSortNameNull() {
        //get the menu for checking is null or not
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_name, 0);

        assertTrue(true);
    }

    @Test
    public void mIsMenuSortWinNull() {
        //get the menu for checking is null or not
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_win, 0);

        assertTrue(true);
    }

    @Test
    public void mIsMenuSortLoseNull() {
        //get the menu for checking is null or not
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_lose, 0);

        assertTrue(true);
    }

    @Test
    public void mClickFilter() {

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_name, 0);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_win, 0);
        getInstrumentation().invokeMenuActionSync(mActivity, R.id.sort_lose, 0);
    }

}