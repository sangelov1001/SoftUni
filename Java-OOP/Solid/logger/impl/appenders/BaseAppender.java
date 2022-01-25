package Solid.logger.impl.appenders;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {

    private static final ReportLevelEnum DEFAULT_REPORT_ENUM_LEVEL = ReportLevelEnum.INFO;

    Layout layout;
    private ReportLevelEnum reportLevelEnum;
    private int messagesCount;

        // единия конструктор в за default случаите а другия е за тези по условие
    public BaseAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_ENUM_LEVEL);
    }

    public BaseAppender(Layout layout, ReportLevelEnum reportLevelEnum) {
        this.layout = layout;
        this.reportLevelEnum = reportLevelEnum;
        this.messagesCount = 0;
    }

    // проверката за степента на важност на enums се прави тук за да не я пишем поотделно във FileAppender и ConsoleAppender
    public boolean canAppend(ReportLevelEnum reportLevelEnum) {
        return this.reportLevelEnum.ordinal() <= reportLevelEnum.ordinal();
    }

    public void setReportLevelEnum(ReportLevelEnum reportLevelEnum) {
        this.reportLevelEnum = reportLevelEnum;
    }

    public void increaseMessageCount() {
        this.messagesCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages append: %s",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(),
                this.reportLevelEnum, messagesCount);

    }
}
