package Solid.logger.impl.layouts;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

// Layout = format
    @Override
    public String format(String time, String message, ReportLevelEnum reportLevelEnum) {
        return String.format("%s - %s - %s", time, reportLevelEnum, message);
    }
}
