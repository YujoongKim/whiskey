package com.techelevator.dao;

import com.techelevator.model.Whiskey;

import java.util.List;

public interface WhiskeyDao {
    List<Whiskey> findAll();
    Whiskey findWhiskeyById(int id);
    void updateVolume(int id, int volume);
    Whiskey createWhiskey(Whiskey whiskey);

}
