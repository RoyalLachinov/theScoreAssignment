package com.thescore.presenter;

import android.support.annotation.NonNull;

import com.thescore.api.ApiService;
import com.thescore.api.RetroClient;
import com.thescore.model.Player;
import com.thescore.model.Team;
import com.thescore.view.TeamViewImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TeamPresenterTest {

    @Mock
    private TeamViewImpl teamView;
    @Mock
    private TeamPresenter teamPresenter;
    @Mock
    RetroClient retroClient;

    private ArrayList<Team> teamList;
    private ArrayList<Player> players;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.teamPresenter = new TeamPresenter(teamView);
    }

    @After
    public void tearDown() throws Exception {
        teamPresenter = null;
    }

    @Test
    public void testEmptyListResponse() {
        teamList = new ArrayList<>();
        assertNotNull(teamList);
        players = new ArrayList<>();
        assertNotNull(players);
        Player player = new Player("Kent", "Bazemore", "G_F", 24);
        players.add(player);
        Team team = new Team(1, 20, 44, "Atalanta", players, 0);
        teamList.add(team);
        teamView.startLoadingTeams(teamList);
    }

    @Test
    public void mSortRecylerView() {
        teamList = new ArrayList<>();
        assertNotNull(teamList);
        players = new ArrayList<>();
        assertNotNull(players);
        Player player = new Player("Kent", "Bazemore", "G_F", 24);
        players.add(player);
        Team team = new Team(1, 20, 44, "Atalanta", players, 0);
        teamList.add(team);

        if (teamList.size() > 0 && teamList.size() == 1) {
            //TODO
        } else {
            //TODO
        }
    }

    @Test
    public void mShowTeamDetail() {

        Team team = new Team(1, 20, 44, "Atalanta", players, 0);
        if (team != null) {
            teamView.navigateToTeamDetail(team);
            assertTrue(true);
        } else {
            teamView.getError("Team is not available");
            assertTrue(false);
        }
    }
}