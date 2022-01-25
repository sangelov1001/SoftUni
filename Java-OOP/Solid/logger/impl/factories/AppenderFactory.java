package Solid.logger.impl.factories;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.impl.appenders.ConsoleAppender;
import Solid.logger.impl.appenders.FileAppender;
import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Factory;
import Solid.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split(" ");
        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;
        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (appenderType.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }
        if (tokens.length >= 3) {
            appender.setReportLevel(ReportLevelEnum.valueOf(tokens[2]));
        }
        return appender;
    }
}
