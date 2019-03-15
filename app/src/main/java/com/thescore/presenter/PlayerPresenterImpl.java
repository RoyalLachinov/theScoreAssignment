package com.thescore.presenter;

import com.thescore.model.Player;
import com.thescore.model.Team;

import java.util.ArrayList;

public interface PlayerPresenterImpl {

    void showTeamFullNameAndPoints(Team team);

    void showTeamPlayers(ArrayList<Player> players);
}
