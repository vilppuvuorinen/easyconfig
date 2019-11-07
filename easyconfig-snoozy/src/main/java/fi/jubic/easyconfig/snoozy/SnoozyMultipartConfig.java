package fi.jubic.easyconfig.snoozy;

import fi.jubic.easyconfig.annotations.EasyConfigProperty;
import fi.jubic.snoozy.MultipartConfig;

public class SnoozyMultipartConfig implements MultipartConfig {
    private final String cacheLocation;
    private final long maxFileSize;
    private final long maxRequestSize;
    private final int sizeThreshold;

    public SnoozyMultipartConfig(
            @EasyConfigProperty(value = "CACHE_LOCATION", defaultValue = "") String cacheLocation,
            @EasyConfigProperty(value = "MAX_FILE_SIZE", defaultValue = "-1") long maxFileSize,
            @EasyConfigProperty(value = "MAX_REQUEST_SIZE", defaultValue = "-1") long maxRequestSize,
            @EasyConfigProperty(value = "SIZE_THRESHOLD", defaultValue = "-1") int sizeThreshold
    ) {
        this.cacheLocation = cacheLocation;

        MultipartConfig defaultConfig = new MultipartConfig() {};
        this.maxFileSize = maxFileSize != -1
                ? maxFileSize
                : defaultConfig.getMaxFileSize();
        this.maxRequestSize = maxRequestSize != -1
                ? maxRequestSize
                : defaultConfig.getMaxRequestSize();
        this.sizeThreshold = sizeThreshold != -1
                ? sizeThreshold
                : defaultConfig.getSizeThreshold();
    }

    @Override
    public String getCacheLocation() {
        return cacheLocation;
    }

    @Override
    public long getMaxFileSize() {
        return maxFileSize;
    }

    @Override
    public long getMaxRequestSize() {
        return maxRequestSize;
    }

    @Override
    public int getSizeThreshold() {
        return sizeThreshold;
    }
}