package Solid.logger.interfaces;

import Solid.logger.enums.ReportLevelEnum;

public interface Appender {

    void append(String time, String message, ReportLevelEnum reportLevelEnum);
    void setReportLevel(ReportLevelEnum reportLevelEnum);
}
