package com.assignment.question;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private String testField;

    public DatabaseConfigurationBuilder(Builder builder) {
        this.databaseUrl = builder.databaseUrl;
        this.username = builder.username;
        this.password = builder.password;
        this.maxConnections = builder.maxConnections;
        this.enableCache = builder.enableCache;
        this.isReadOnly = builder.isReadOnly;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        public String databaseUrl;
        public String username;
        public String password;
        public int maxConnections;
        public boolean enableCache;
        public boolean isReadOnly;

        public String testField;

        public Builder databaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly) {
            this.isReadOnly = isReadOnly;
            return this;
        }

        public Builder testField(String testField) {
            this.testField = testField;
            return this;
        }

        public DatabaseConfigurationBuilder build() {
            return new DatabaseConfigurationBuilder(this);
        }
    }

    public static void main(String[] args) {
        DatabaseConfigurationBuilder databaseConfigurationBuilder1 =
                DatabaseConfigurationBuilder.getBuilder()
                        .build();

        DatabaseConfigurationBuilder databaseConfigurationBuilder2 =
                DatabaseConfigurationBuilder.getBuilder()
                        .build();

        DatabaseConfigurationBuilder databaseConfigurationBuilder3 =
                DatabaseConfigurationBuilder.getBuilder()
                        .databaseUrl("db-url")
                        .enableCache(true)
                        .build();

        DatabaseConfigurationBuilder databaseConfigurationBuilder4 =
                DatabaseConfigurationBuilder.getBuilder()
                        .databaseUrl("db-url-1")
                        .maxConnections(20)
                        .isReadOnly(true)
                        .testField("testField")
                        .build();

        System.out.println("--------------------");
    }
}