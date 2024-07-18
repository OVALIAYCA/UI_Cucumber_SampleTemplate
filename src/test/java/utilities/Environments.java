package utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Environments {
    PRODUCTION("test"),
    STAGE("stage");

    public final String name;

    Environments(String name) {
        this.name = name;
    }
}
