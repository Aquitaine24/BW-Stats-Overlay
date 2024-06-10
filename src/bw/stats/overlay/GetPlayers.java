package bw.stats.overlay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetPlayers {
    private static String userProfile = System.getenv("USERPROFILE");
    private static String logFilePath = userProfile + "/.lunarclient/logs/game/";

    public static List<String> GetPlayers() {
        File logDir = new File(logFilePath);
        if (!logDir.exists() || !logDir.isDirectory()) {
            System.out.println("Log directory does not exist.");
            return null;
        }

        File[] logFiles = logDir.listFiles((dir, name) -> name.endsWith(".log"));
        if (logFiles == null || logFiles.length == 0) {
            System.out.println("No log files found.");
            return null;
        }

        File latestLogFile = Arrays.stream(logFiles)
                .max(Comparator.comparingLong(GetPlayers::getFileCreationTime))
                .orElse(null);

        if (latestLogFile == null) {
            System.out.println("No log files found.");
            return null;
        }

        List<String> nameList = null;
        try (BufferedReader br = new BufferedReader(new FileReader(latestLogFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ONLINE:")) {
                    nameList = processOnlineLine(line);
                    break; // Assuming we only need the first occurrence
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameList;
    }

    private static long getFileCreationTime(File file) {
        try {
            Path filePath = file.toPath();
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            return attrs.creationTime().toMillis();
        } catch (IOException e) {
            e.printStackTrace();
            return Long.MIN_VALUE;
        }
    }

    private static List<String> processOnlineLine(String line) {
        // Extract and process the substring after "ONLINE:"
        String onlineNames = line.substring(line.indexOf("ONLINE:") + 7).trim();

        // Convert the string into a list of names
        return Arrays.stream(onlineNames.split(","))
                .map(String::trim)
                .map(s -> s.replace("\n", ""))
                .collect(Collectors.toList());
    }
}
