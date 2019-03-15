package com.thescore.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thescore.R;
import com.thescore.model.Team;
import com.thescore.presenter.TeamPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityTeam extends AppCompatActivity implements TeamViewImpl {

    @BindView(R.id.listViewTeam)
    RecyclerView mListViewTeam;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private TeamPresenter teamPresenter;
    private AdapterTeam teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(getResources().getString(R.string.teams));
        mProgressBar.setVisibility(View.VISIBLE);

        teamPresenter = new TeamPresenter(this, this);
        teamPresenter.getAllTeams();

    }

    @Override
    public void startLoadingTeams(ArrayList<Team> teamList) {

        Team.sortTeamByName(teamList);
        teamAdapter = new AdapterTeam(teamPresenter, teamList);
        mListViewTeam.setLayoutManager(new LinearLayoutManager(ActivityTeam.this, LinearLayoutManager.VERTICAL, false));
        mListViewTeam.setAdapter(teamAdapter);
    }

    @Override
    public void finishLoadingTeams() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void updateTeamList(ArrayList<Team> teamList) {
        teamAdapter.updateTeams(teamList);
    }

    @Override
    public void navigateToTeamDetail(Team team) {

        Intent intent = new Intent(ActivityTeam.this, ActivityPlayer.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("team", team);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void getError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_name:
                teamPresenter.passToUpdateAction(1);
                break;
            case R.id.sort_win:
                teamPresenter.passToUpdateAction(2);
                break;
            case R.id.sort_lose:
                teamPresenter.passToUpdateAction(3);
                break;
            default:
                teamPresenter.passToUpdateAction(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showEmptyTeamListDialog(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissProgress() {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        teamPresenter.detachView();
    }
}
