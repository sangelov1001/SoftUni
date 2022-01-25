package Solid.logger;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.impl.appenders.ConsoleAppender;
import Solid.logger.impl.MessageLogger;
import Solid.logger.impl.factories.LoggerFactory;
import Solid.logger.impl.layouts.SimpleLayout;
import Solid.logger.impl.layouts.XmlLayout;
import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Layout;
import Solid.logger.interfaces.Logger;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // този Main метод е само за последното условие на задачата.

        InputParser inputParser = new InputParser();
        Scanner scanner = new Scanner(System.in);
        LoggerFactory loggerFactory = new LoggerFactory();

        Logger logger = loggerFactory.produce(inputParser.readLoggerInfo(scanner));

        String input = scanner.nextLine();
        while(!"END".equals(input)) {
            String[] tokens = input.split("\\|");
            ReportLevelEnum reportLevelEnum = ReportLevelEnum.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];

            switch (reportLevelEnum) {
                case INFO: logger.logInfo(time, message); break;
                case WARNING: logger.logWarning(time, message); break;
                case ERROR: logger.logError(time, message); break;
                case CRITICAL: logger.logCritical(time, message); break;
                case FATAL: logger.logFatal(time, message); break;

            }

            input = scanner.nextLine();
        }

        System.out.println(logger);


    }
}
