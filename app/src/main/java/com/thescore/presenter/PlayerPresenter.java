package com.thescore.presenter;

import com.thescore.model.Player;
import com.thescore.model.Team;
import com.thescore.view.PlayerViewImpl;

import java.util.ArrayList;

public class PlayerPresenter implements PlayerPresenterImpl {

    private PlayerViewImpl playerView;

    public PlayerPresenter(PlayerViewImpl playerView) {
        this.playerView = playerView;
    }

    @Override
    public void showTeamFullNameAndPoints(Team team) {
        if (team != null) {
            playerView.showTeamFullNameAndPoints(team);
            showTeamPlayers(team.getPlayers());
        } else {
            playerView.showEmptyWarning("Team is not available");
        }

    }


    @Override
    public void showTeamPlayers(ArrayList<Player> players) {
        if (!players.isEmpty() || players != null) {
            playerView.showTeamPlayers(players);
        } else {
            playerView.showEmptyWarning("Team is not available");
        }
    }
}
