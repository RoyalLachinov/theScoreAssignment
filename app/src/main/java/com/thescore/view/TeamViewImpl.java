package com.thescore.view;

import android.support.v4.app.Fragment;

import com.thescore.model.Team;

import java.util.ArrayList;

public interface TeamViewImpl {

    void startLoadingTeams(ArrayList<Team> teamList);

    void showEmptyTeamListDialog(String message);

    void updateTeamList(ArrayList<Team> teamList);

    void navigateToTeamDetail(Team team);

    void finishLoadingTeams();

    void getError(String errorMessage);

    void dismissProgress();

}
