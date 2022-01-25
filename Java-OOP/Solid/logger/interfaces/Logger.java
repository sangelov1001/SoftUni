package Solid.logger.interfaces;

public interface Logger {

    // по един метод за всеки един от enum-ите
    void logInfo(String time, String message);
    void logWarning(String time, String message);
    void logError(String time, String message);
    void logCritical(String time, String message);
    void logFatal(String time, String message);

}
