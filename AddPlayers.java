package com.HashMap.dto;

import java.util.HashMap;

public interface AddPlayers {

    void addPlayersToMap(HashMap<Integer,String> footballPlayers);
    void searchPlayersFromMap(HashMap<Integer,String> footballPlayers);
    void deletePlayersFromMap(HashMap<Integer,String> footballPlayers);

}
