package abstractionExercises.trafficLights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    // правим си метод така да сменяме цвета на светофара
    public void changeColor() {
        switch (this.color) {

            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }
    @Override
    public  String toString(){
            return  this.color.toString();
    }
}
