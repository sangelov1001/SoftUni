package Solid.logger.impl.layouts;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevelEnum reportLevelEnum) {
        return String.format(
                        "<log>%n" +
                        "       <date>%s</date>%n" +
                        "       <level>%s</level>%n" +
                        "       <message>%s</message>%n" +
                        "</log>%n", time, reportLevelEnum, message);
    }
}
