package com.thescore.view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thescore.R;
import com.thescore.model.Player;
import com.thescore.model.Team;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPlayers extends RecyclerView.Adapter<AdapterPlayers.ViewHolder> {

    private ArrayList<Player> players;

    public AdapterPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    @Override
    public void onBindViewHolder(AdapterPlayers.ViewHolder contactViewHolder, final int i) {

        contactViewHolder.mTextPlayerName.setText(players.get(i).getFirstName() + " " + players.get(i).getLastName());
        contactViewHolder.mPlayerNo.setText(players.get(i).getNumber() + "");
        contactViewHolder.mPlayerPosition.setText(players.get(i).getPosition());

    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public AdapterPlayers.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_item_layout, viewGroup, false);

        return new AdapterPlayers.ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.txt_name)
        protected TextView mTextPlayerName;

        @BindView(R.id.txt_no)
        protected TextView mPlayerNo;

        @BindView(R.id.txt_positon)
        protected TextView mPlayerPosition;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}


