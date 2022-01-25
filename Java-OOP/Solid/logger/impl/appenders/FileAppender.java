package Solid.logger.impl.appenders;

import Solid.logger.enums.ReportLevelEnum;
import Solid.logger.impl.LogFile;
import Solid.logger.interfaces.File;
import Solid.logger.interfaces.Layout;

public class FileAppender extends BaseAppender {

    private File file; // this File is out class File

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
            this(layout);
            this.file = new LogFile(fileName);
    }

    @Override
    public void append(String time, String message, ReportLevelEnum reportLevelEnum) {

        if (this.canAppend(reportLevelEnum)) {
            String output = this.layout.format(time, message, reportLevelEnum);
            increaseMessageCount();
            file.append(output);
        }
    }

    @Override
    public void setReportLevel(ReportLevelEnum reportLevelEnum) {

    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
