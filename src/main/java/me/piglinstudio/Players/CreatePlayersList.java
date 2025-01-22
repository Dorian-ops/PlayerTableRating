package me.piglinstudio.Players;

import me.piglinstudio.Players.Models.Player;
import me.piglinstudio.Players.Models.PlayerService;

import java.util.*;

public class CreatePlayersList {
    public static List<Player> playersList = new ArrayList<>();

    public static void execute() {
        for (int i = 0; i < 15000; i++) {
            Player player = PlayerService.generatedFakerPlayer();
            playersList.add(player);
        }
        playersList.sort(Comparator.comparingInt(Player::getPoints).reversed());
    }
}
