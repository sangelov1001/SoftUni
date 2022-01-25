package Solid.logger.impl.appenders;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.impl.appenders.BaseAppender;
import Solid.logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    // трябва ни конструктор който да приема layout-a
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevelEnum reportLevelEnum) {
        if (this.canAppend(reportLevelEnum)) {
            String formattedMessage = this.layout.format(time, message, reportLevelEnum);
            increaseMessageCount();
            System.out.println(formattedMessage);
        }
    }

    @Override
    public void setReportLevel(ReportLevelEnum reportLevelEnum) {

    }
}
