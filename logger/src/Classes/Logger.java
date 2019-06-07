package Classes;

import Interfaces.iLogger;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements iLogger {

    @Override
    public void writeLog(String customErrorMessage, String folderName, String logName) throws IOException {

        if (folderName == null) folderName = "Logs";
        if (logName == null) logName = "log";

        Date date = new Date();
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateDayFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateTime = dateTimeFormat.format(date);
        String formattedDateDay = dateDayFormat.format(date);

        String str = customErrorMessage + "|" + formattedDateTime + '\n';
        File fileName = new File(folderName + "/"+ logName +"-"+formattedDateDay + ".csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(' ');
        writer.append(str);

        writer.close();

    }

}

