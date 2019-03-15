package com.thescore.presenter;

import android.content.Context;

import com.thescore.R;
import com.thescore.api.RetroClient;
import com.thescore.model.Team;
import com.thescore.view.TeamViewImpl;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TeamPresenter implements TeamPresenterImpl {

    private Context context;
    private TeamViewImpl teamView;
    private ArrayList<Team> teamList;

    public TeamPresenter(TeamViewImpl teamView) {
        this.teamView = teamView;
    }

    public TeamPresenter(TeamViewImpl teamView, Context context) {
        this.teamView = teamView;
        this.context = context;
    }

    @Override
    public void getAllTeams() {

        RetroClient.getApiService().getAllTeams().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<Team>>() {
                    @Override
                    public void onCompleted() {
                        teamView.finishLoadingTeams();
                    }

                    @Override
                    public void onError(Throwable e) {
                        teamView.getError(e.getMessage());
                        teamView.dismissProgress();
                    }

                    @Override
                    public void onNext(ArrayList<Team> teamArrayList) {
                        teamList = new ArrayList<>();
                        if (!teamArrayList.isEmpty()) {

                            for (int i = 0; i < teamArrayList.size(); i++) {
                                String imageName = "logo_" + teamArrayList.get(i).getFullName().substring(teamArrayList.get(i).getFullName().lastIndexOf(" ") + 1).toLowerCase();
                                int iconResource = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

                                Team team = new Team(teamArrayList.get(i).getId(), teamArrayList.get(i).getWins(),
                                        teamArrayList.get(i).getLosses(), teamArrayList.get(i).getFullName(),
                                        teamArrayList.get(i).getPlayers(), iconResource);
                                teamList.add(team);
                            }

                            teamView.startLoadingTeams(teamList);
                        } else {
                            teamView.showEmptyTeamListDialog(context.getResources().getString(R.string.no_team));
                            teamView.dismissProgress();
                        }
                    }
                });
    }

    @Override
    public void passToUpdateAction(int sortMode) {
        if (sortMode == 1) {
            Team.sortTeamByName(teamList);
        } else if (sortMode == 2) {
            Team.sortTeamByWins(teamList);
        } else if (sortMode == 3) {
            Team.sortTeamByLosses(teamList);
        }
        teamView.updateTeamList(teamList);
    }

    @Override
    public void detachView() {
        teamView.dismissProgress();
    }

    @Override
    public void showTeamDetail(Team team) {
        if(team != null){
            teamView.navigateToTeamDetail(team);
        }else{
            teamView.navigateToTeamDetail(team);
        }

    }
}
