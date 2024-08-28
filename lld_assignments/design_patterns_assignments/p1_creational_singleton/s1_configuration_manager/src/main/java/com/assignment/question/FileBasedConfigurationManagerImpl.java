package com.assignment.question;

//public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
//    private static FileBasedConfigurationManagerImpl fbcm = null;
//
//    private FileBasedConfigurationManagerImpl() {
//        super();
//    }
//
//    @Override
//    public String getConfiguration(String key) {
//        return properties.getProperty(key);
//    }
//
//    @Override
//    public <T> T getConfiguration(String key, Class<T> type) {
//        String value = properties.getProperty(key);
//        if (value != null) {
//            return convert(value, type);
//        }
//        return null;
//    }
//
//    @Override
//    public void setConfiguration(String key, String value) {
//        properties.setProperty(key, value);
//    }
//
//    @Override
//    public <T> void setConfiguration(String key, T value) {
//        if (value != null)
//            properties.setProperty(key, value.toString());
//        else
//            removeConfiguration(key);
//    }
//
//    @Override
//    public void removeConfiguration(String key) {
//        properties.remove(key);
//    }
//
//    @Override
//    public void clear() {
//        properties.clear();
//    }
//
//    public static FileBasedConfigurationManager getInstance() {
//        if (fbcm == null) {
//            synchronized (FileBasedConfigurationManagerImpl.class) {
//                if (fbcm == null) {
//                    fbcm = new FileBasedConfigurationManagerImpl();
//                }
//            }
//        }
//        return fbcm;
//    }
//
//    public static void resetInstance() {
//        fbcm = null;
//    }
//
//}

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl instance;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    @Override
    public String getConfiguration(String key) {
        return properties.getProperty(key);
        // TODO Auto-generated method stub

    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        if (type == null) {
            return null;
        }
        String val = getConfiguration(key);
        if (val == null) {
            return null;
        }
        return convert(val, type);

    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        setConfiguration(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        properties.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (instance == null) {
                    instance = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return instance;
        // TODO Auto-generated method stub
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        instance = null;
    }

}