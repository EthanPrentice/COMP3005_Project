package utils.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    private final static Path basePath = Paths.get(System.getProperty("user.dir"));
    private final static Path queryPath = Paths.get(basePath.toString(), "resources", "queries");
    private final static Path updatesPath = Paths.get(basePath.toString(), "resources", "updates");
    private final static Path insertsPath = Paths.get(basePath.toString(), "resources", "inserts");
    private final static Path deletionsPath = Paths.get(basePath.toString(), "resources", "deletions");


    private final static DBConfig dbConfig = new DBConfig();

    public static Path getBasePath() {
        return basePath;
    }

    public static Path getQueryPath() {
        return queryPath;
    }

    public static Path getUpdatesPath() {
        return updatesPath;
    }

    public static Path getInsertsPath() {
        return insertsPath;
    }

    public static Path getDeletionsPath() {
        return deletionsPath;
    }

    public static DBConfig getDBConfig() {
        return dbConfig;
    }

}
