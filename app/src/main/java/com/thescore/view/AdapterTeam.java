package com.thescore.view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thescore.R;
import com.thescore.model.Team;
import com.thescore.presenter.TeamPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.ViewHolder> {

    private TeamPresenter presenter;
    private ArrayList<Team> teams;


    public AdapterTeam(TeamPresenter presenter,ArrayList<Team> teams) {
        this.presenter = presenter;
        this.teams = teams;
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void updateTeams(ArrayList<Team> teams) {
        this.teams = teams;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder contactViewHolder, final int i) {

        contactViewHolder.img_team_logo.setImageResource(teams.get(i).getLogo());
        contactViewHolder.mTextFullName.setText(teams.get(i).getFullName());
        contactViewHolder.mTextWin.setText(teams.get(i).getWins() + "");
        contactViewHolder.mTextLose.setText(teams.get(i).getLosses() + "");

        contactViewHolder.item_team_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showTeamDetail(teams.get(i));

            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_item_layout, viewGroup, false);

        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_team_layout)
        protected ConstraintLayout item_team_layout;

        @BindView(R.id.img_team_logo)
        ImageView img_team_logo;

        @BindView(R.id.txt_name)
        protected TextView mTextFullName;

        @BindView(R.id.txt_win)
        protected TextView mTextWin;

        @BindView(R.id.txt_lose)
        protected TextView mTextLose;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}


