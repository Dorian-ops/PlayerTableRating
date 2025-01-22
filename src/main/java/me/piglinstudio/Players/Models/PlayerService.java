package me.piglinstudio.Players.Models;

import java.util.Random;

import static me.piglinstudio.Main.faker;

public class PlayerService {
    public static Player generatedFakerPlayer() {
        String name = faker.funnyName().name();
        Random random = new Random();
        int randomPoint = random.nextInt(150000);

        Player player = new Player();
        player.setPlayerName(name);
        player.setPoints(randomPoint);
        return player;
    }
}
