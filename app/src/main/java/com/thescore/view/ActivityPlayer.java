package com.thescore.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thescore.R;
import com.thescore.model.Player;
import com.thescore.model.Team;
import com.thescore.presenter.PlayerPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityPlayer extends AppCompatActivity implements PlayerViewImpl {


    private View mView;
    @BindView(R.id.img_team_logo)
    ImageView mImgLogo;

    @BindView(R.id.txt_team_name)
    TextView mTeamName;

    @BindView(R.id.txt_win_lose)
    TextView mWinLose;

    @BindView(R.id.list_view_players)
    RecyclerView mListViewPlayers;

    private PlayerPresenter playerPresenter;
    private AdapterPlayers adapterPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getResources().getString(R.string.team_detail));

        playerPresenter = new PlayerPresenter(this);

        Team team = getIntent().getParcelableExtra("team");

        playerPresenter.showTeamFullNameAndPoints(team);


    }

    @Override
    public void showTeamFullNameAndPoints(Team team) {

        mTeamName.setText(team.getFullName());

        String imageName = "logo_" + team.getFullName().substring(team.getFullName().lastIndexOf(" ") + 1).toLowerCase();
        int iconResource = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
        mImgLogo.setImageResource(iconResource);
        mWinLose.setText("(" + team.getWins() + " - " + team.getLosses() + ", " + (team.getWins() * 2) + " pts)");

    }

    @Override
    public void showTeamPlayers(ArrayList<Player> players) {

        adapterPlayers = new AdapterPlayers(players);
        mListViewPlayers.setLayoutManager(new LinearLayoutManager(ActivityPlayer.this, LinearLayoutManager.VERTICAL, false));
        mListViewPlayers.setAdapter(adapterPlayers);
        mListViewPlayers.setHasFixedSize(true);
        mListViewPlayers.setItemViewCacheSize(20);
        mListViewPlayers.setDrawingCacheEnabled(true);
        mListViewPlayers.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mListViewPlayers.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showEmptyWarning(String warning) {
        Toast.makeText(this, warning, Toast.LENGTH_SHORT).show();
    }
}
