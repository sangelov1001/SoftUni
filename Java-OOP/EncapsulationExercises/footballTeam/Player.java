package EncapsulationExercises.footballTeam;

public class Player {
        private String name;
        private int endurance;
        private int passing;
        private int shooting;
        private int dribble;
        private int sprint;

    public Player(String name, int endurance, int passing, int shooting, int dribble, int sprint) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setDribble(dribble);
        this.setShooting(shooting);
        this.setPassing(passing);
        this.setSprint(sprint);
    }

    private void setName(String name) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("A name should not be empty.");
            }
            this.name = name;
        }

        private void setEndurance (int endurance) {
            checkIfIsInRange(endurance, "Endurance");
            this.endurance = endurance;
        }

        private void setSprint(int sprint) {
           checkIfIsInRange(sprint, "Sprint");
            this.sprint = sprint;
        }

        private  void setPassing(int pasising) {
            checkIfIsInRange(pasising, "Passing");
            this.passing = pasising;
        }

        private void setDribble(int dribble) {
            checkIfIsInRange(dribble, "Dribble");
            this.dribble = dribble;
        }

        private void setShooting(int shooting) {
            checkIfIsInRange(shooting, "Shooting");
            this.shooting = shooting;
        }

    public String getName() {
        return name;
    }

    private void checkIfIsInRange (int stat, String statName) {
                if (stat < 0 || stat > 100) {
                    throw new IllegalArgumentException(statName + "should be between 0 and 100");
                }
        }

        public double overSkillLevel() {
        return (this.endurance + this.dribble + this.passing + this.shooting + this.sprint / 5.0);
        }
}
