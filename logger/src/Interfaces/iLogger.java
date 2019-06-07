package Interfaces;

import java.io.IOException;
import java.util.Date;

public interface iLogger {

    void writeLog(String customErrorMessage, String folderName, String logName) throws IOException;
}
