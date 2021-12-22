package EncapsulationExercises.footballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
            private String name;
            private List<Player> players;



            public Team(String name) {
                this.setName(name);
                this.players = new ArrayList<>();
            }


     private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
                return this.players.stream().mapToDouble(Player::overSkillLevel).average()
                        .orElse(0.0);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    // метод за добавяне на играч
    public void addPlayer(Player player) {
                this.players.add(player);
    }
    // за премахване на играч
    // премахваме играча чието име ни е дадено
    public void removePlayer (Player name) {
                boolean isRemoved = this.players.removeIf(player -> player.getName().equals(name));
                if (!isRemoved) {
                    throw new IllegalArgumentException(String.format("Player %s is not in %s team", name, this.name));
                }
    }
}
