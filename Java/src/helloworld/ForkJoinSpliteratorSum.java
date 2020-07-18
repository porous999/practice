package helloworld;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSpliteratorSum extends RecursiveTask<Map<String, Object>> {

    static final int splitFactor = 4;

     static final Logger logger = Logger.getLogger(ForkJoinSpliteratorSum.class);

    private List<Integer> arrayList = null;
    private transient Spliterator<Integer> theSpliterator = null;

    public ForkJoinSpliteratorSum(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public ForkJoinSpliteratorSum(Spliterator<Integer> mySpliterator) {
        this.theSpliterator = mySpliterator;
    }

    @Override
    protected Map<String, Object> compute() {
        Map<String, Object> eachMap1;
        Map<String, Object> eachMap2;
        if (null == theSpliterator || theSpliterator.estimateSize() > splitFactor) {
            logger.info("Split zone!");
            if (theSpliterator == null) {
                logger.info("Initialize theSpliterator");
                theSpliterator = arrayList.spliterator();
            }

            ForkJoinSpliteratorSum spliteratorSum = new ForkJoinSpliteratorSum(theSpliterator.trySplit());
            ForkJoinSpliteratorSum spliteratorSum2 = new ForkJoinSpliteratorSum(theSpliterator);
            ForkJoinTask.invokeAll(spliteratorSum, spliteratorSum2);
            eachMap1 = spliteratorSum.getRawResult();
            eachMap2 = spliteratorSum2.getRawResult();
        } else {
            logger.info("Sum zone!");
            Map<String, Object> sumMap = new HashMap<>();
            theSpliterator.forEachRemaining(eachInt -> {
                // logger.info(String.format("Adding %s to %s", eachInt, sumMap.getOrDefault("sum", 0)));
                sumMap.put("sum", (int) sumMap.getOrDefault("sum", 0) + eachInt);
            });
            // logger.info(String.format("Sum map sum before return %s", sumMap.getOrDefault("sum", 0)));
            return sumMap;
        }

        return mergeResult(eachMap1, eachMap2);
    }

    private Map<String, Object> mergeResult(Map<String, Object> eachMap1, Map<String, Object> eachMap2) {
        Map<String, Object> resultMap;
        if (null == eachMap1)
            resultMap = eachMap2;
        else if(null == eachMap2)
            resultMap = eachMap1;
        else {
            // logger.info(String.format("Merging: %s and %s", eachMap1.getOrDefault("sum", 0), eachMap2.getOrDefault("sum", 0)));
            resultMap = eachMap1;
            if (eachMap2.containsKey("sum"))
                resultMap.put("sum", (int) resultMap.getOrDefault("sum", 0) + (int) eachMap2.getOrDefault("sum", 0));
        }
        return resultMap;
    }
}
