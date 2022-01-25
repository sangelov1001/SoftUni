package Solid.logger.interfaces;

public interface Factory<Т> {

    Т produce(String input);


}
