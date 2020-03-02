package HelloWorld;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by tanmays on 25/2/20.
 */
public class TryGuavaCache {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TryGuavaCache.class.getSimpleName());
        Cache<String, String> myCache = CacheBuilder.newBuilder()
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        logger.info("RemovalNotification: " + removalNotification.wasEvicted());
                        logger.info("RemovalNotification: 1: " + removalNotification.getKey() + " " + removalNotification.getValue());
                    }
                })
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .build();
        myCache.put("some_key", "some_value");
        logger.info("Invalidating an absent key!");
        myCache.invalidate("no_key");
        boolean exit = false;
        int count = 1;
        while (!exit) {
            if (count > 10)
                myCache.invalidate("some_key");

            String valueStr = myCache.getIfPresent("some_key");
            if (null == valueStr) {
                logger.info("Value absent!!");
                exit = true;
            } else
                logger.info("Value exists - " + count++ + " - " + valueStr);
        }
    }
}
