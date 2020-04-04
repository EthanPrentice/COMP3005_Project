package utils.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    private final static Path basePath = Paths.get(System.getProperty("user.dir"));
    private final static Path queryPath = Paths.get(basePath.toString(), "resources", "queries");

    private final static DBConfig dbConfig = new DBConfig();

    public static Path getBasePath() {
        return basePath;
    }

    public static Path getQueryPath() {
        return queryPath;
    }

    public static DBConfig getDBConfig() {
        return dbConfig;
    }

}
