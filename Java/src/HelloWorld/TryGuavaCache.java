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
        Cache<String, Integer> myCache = CacheBuilder.newBuilder()
                .removalListener(new RemovalListener<String, Integer>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Integer> removalNotification) {
                        logger.info("RemovalNotification: " + removalNotification.wasEvicted());
                        logger.info("RemovalNotification: 1: " + removalNotification.getKey() + " " + removalNotification.getValue());
                    }
                })
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build();
        myCache.put("key1", 1);
        boolean exit = false;
        while (!exit) {
            Integer valueInt = myCache.getIfPresent("key1");
            if (null == valueInt) {
                logger.info("Value absent!!");
                exit = true;
            } else
                logger.info("Value exists - " + valueInt);
        }
    }
}
