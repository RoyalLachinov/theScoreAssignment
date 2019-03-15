package com.thescore.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Team implements Parcelable{

    @SerializedName("id")
    private int id;
    @SerializedName("wins")
    private int wins;
    @SerializedName("losses")
    private int losses;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("players")
    ArrayList<Player> players;
    private int logo;

    public Team(int id, int wins, int losses, String fullName, ArrayList<Player> players, int logo) {
        this.id = id;
        this.wins = wins;
        this.losses = losses;
        this.fullName = fullName;
        this.players = players;
        this.logo = logo;
    }


    protected Team(Parcel in) {
        id = in.readInt();
        wins = in.readInt();
        losses = in.readInt();
        fullName = in.readString();
        players = in.createTypedArrayList(Player.CREATOR);
        logo = in.readInt();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public static void sortTeamByName(ArrayList<Team> teams) {
        Collections.sort(teams, new Comparator<Team>() {
            public int compare(Team t1, Team t2) {
                return t1.getFullName().compareTo(t2.getFullName());
            }
        });
    }

    public static void sortTeamByWins(ArrayList<Team> teams) {
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                return t2.getWins() - t1.getWins();
            }
        });
    }

    public static void sortTeamByLosses(ArrayList<Team> teams) {
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                return t2.getLosses() - t1.getLosses();
            }
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(wins);
        dest.writeInt(losses);
        dest.writeString(fullName);
        dest.writeTypedList(players);
        dest.writeInt(logo);
    }
}
