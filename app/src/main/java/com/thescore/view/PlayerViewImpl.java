package com.thescore.view;

import com.thescore.model.Player;
import com.thescore.model.Team;

import java.util.ArrayList;

public interface PlayerViewImpl {

    void showTeamLogo(int logo);

    void showTeamName(String teamName);

    void showTeamPoints(String points);

    void showTeamPlayers(ArrayList<Player>players);

    void showEmptyWarning(String warning);


}
