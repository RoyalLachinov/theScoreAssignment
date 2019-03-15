package com.thescore.presenter;

import android.content.Context;

import com.thescore.model.Player;
import com.thescore.model.Team;
import com.thescore.view.PlayerViewImpl;

import java.util.ArrayList;

public class PlayerPresenter implements PlayerPresenterImpl {

    private PlayerViewImpl playerView;
    private Context context;

    public PlayerPresenter(PlayerViewImpl playerView, Context context) {
        this.playerView = playerView;
        this.context = context;
    }

    @Override
    public void showTeamDetail(Team team) {
        if (team != null) {

            playerView.showTeamName(team.getFullName());

            String points = "(" + team.getWins() + " - " + team.getLosses() + ", " + (team.getWins() * 2) + " pts)";
            playerView.showTeamPoints(points);

            String imageName = "logo_" + team.getFullName().substring(team.getFullName().lastIndexOf(" ") + 1).toLowerCase();
            int iconResource = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

            playerView.showTeamLogo(iconResource);

            if(!team.getPlayers().isEmpty() ||team.getPlayers() != null){
                playerView.showTeamPlayers(team.getPlayers());
            }else{
                playerView.showEmptyWarning("Players are on vacation");
            }
        } else {
            playerView.showEmptyWarning("Team is not available");
        }

    }
}
