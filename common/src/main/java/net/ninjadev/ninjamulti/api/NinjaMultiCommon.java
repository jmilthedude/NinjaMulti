package net.ninjadev.ninjamulti.api;

public class NinjaMultiCommon {
    public static void init() {
        Constants.LOG.info("NinjaMulti API initialized on {}", Services.PLATFORM.getPlatformName());
    }
}
