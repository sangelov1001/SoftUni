package Solid.logger.impl;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Logger;


import java.util.Arrays;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    // правим си го с varargs защото не знаем колко аргумента ще ни се подадът
    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }


    // трябва да минем през всеки един от appender - ите ни за да изведе съотв. съобщение
    // така при log ние ще можем да минем през нашите appender-s и да им append-нем съобщението
    @Override
    public void logInfo(String time, String message) {
        log(time, message, ReportLevelEnum.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
            log(time, message, ReportLevelEnum.WARNING);
    }

    @Override
    public void logError(String time, String message) {
        log(time, message, ReportLevelEnum.ERROR);
    }

    @Override
    public void logCritical(String time, String message) {
        log(time, message, ReportLevelEnum.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        log(time, message, ReportLevelEnum.FATAL);
    }

    private void log(String time, String message, ReportLevelEnum reportLevelEnum) {
        for (Appender appender : appenders) {
            appender.append(time, message, reportLevelEnum);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Logger info");
        sb.append(System.lineSeparator());
        for (Appender appender : appenders) {
            sb.append(appender);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
