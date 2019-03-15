package com.thescore.api;

import com.thescore.model.Team;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("input.json")
    Observable<ArrayList<Team>> getAllTeams();

}
