package com.assignment.question;

// The design pattern used here is the Prototype Pattern.
// The Prototype Pattern is a creational design pattern in software development.
// This pattern is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.

// The Configuration class implements the ClonableObject interface
public class Configuration implements ClonableObject<Configuration> {
    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;

    // Constructor for the Configuration class
    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }

    // Getters for the Configuration class attributes
    public String getThemeColor() {
        return themeColor;
    }

    public Boolean getAutoSave() {
        return autoSave;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public ConfigurationType getType() {
        return type;
    }

    // The cloneObject method is used to create a copy of the Configuration object
    @Override
    public Configuration cloneObject() {
        return new Configuration(themeColor, autoSave, language, darkMode, fontSize, fontFamily, type);
    }
}
