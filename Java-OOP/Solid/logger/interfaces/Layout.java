package Solid.logger.interfaces;

import Solid.logger.enums.ReportLevelEnum;

public interface Layout {

    String format(String time, String message, ReportLevelEnum reportLevelEnum);
}
