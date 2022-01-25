package Solid.logger.impl.factories;

import Solid.logger.impl.MessageLogger;
import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Factory;
import Solid.logger.interfaces.Logger;

public class LoggerFactory implements Factory<Logger> {

    AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String input) {
        String[] tokens = input.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];

        for (int i = 0; i < appenders.length; i++) {
            appenders[i] = this.appenderFactory.produce(tokens[i]);
        }
        return new MessageLogger(appenders);
    }
}
