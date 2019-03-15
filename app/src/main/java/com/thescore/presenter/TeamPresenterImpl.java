package com.thescore.presenter;

import com.thescore.model.Team;

public interface TeamPresenterImpl {

    void getAllTeams();

    void showTeamDetail(Team team);

    void passToUpdateAction(int sortMode);

    void detachView();
}
