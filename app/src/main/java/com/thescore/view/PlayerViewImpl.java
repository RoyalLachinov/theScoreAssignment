package com.thescore.view;

import com.thescore.model.Player;
import com.thescore.model.Team;

import java.util.ArrayList;

public interface PlayerViewImpl {

    void showTeamFullNameAndPoints(Team team);

    void showTeamPlayers(ArrayList<Player>players);

    void showEmptyWarning(String warning);


}
