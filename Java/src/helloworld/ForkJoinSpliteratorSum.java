package helloworld;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSpliteratorSum extends RecursiveTask<Map<String, Object>> {

    static final int splitFactor = 50_000;

    // static final Logger logger = logger.getLogger(ForkJoinSpliteratorSum.class);

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
        Map<String, Object> eachMap1 = null;
        Map<String, Object> eachMap2 = null;
        if (null == theSpliterator) {
            // logger.info("Initializing splitter!");
            Spliterator<Integer> innerSpliterator = arrayList.spliterator();
            ForkJoinSpliteratorSum spliteratorSum = new ForkJoinSpliteratorSum(innerSpliterator.trySplit());
            ForkJoinSpliteratorSum spliteratorSum2 = new ForkJoinSpliteratorSum(innerSpliterator);
            ForkJoinTask.invokeAll(spliteratorSum, spliteratorSum2);
            eachMap1 = spliteratorSum.getRawResult();
            eachMap2 = spliteratorSum2.getRawResult();
        } else {
            // logger.info("Split is not null, so more fornication/processing!");
            if (theSpliterator.estimateSize() > splitFactor) {
                // logger.info("Split zone!");
                ForkJoinSpliteratorSum spliteratorSum = new ForkJoinSpliteratorSum(theSpliterator.trySplit());
                ForkJoinSpliteratorSum spliteratorSum2 = new ForkJoinSpliteratorSum(theSpliterator);
                ForkJoinTask.invokeAll(spliteratorSum, spliteratorSum2);
                eachMap1 = spliteratorSum.getRawResult();
                eachMap2 = spliteratorSum2.getRawResult();
            } else {
                // logger.info("Sum zone!");
                Map<String, Object> sumMap = new HashMap<>();
                theSpliterator.forEachRemaining(eachInt -> {
                    // logger.info(String.format("Adding %s to %s", eachInt, sumMap.getOrDefault("sum", 0)));
                    sumMap.put("sum", (int) sumMap.getOrDefault("sum", 0) + eachInt);
                });
                // logger.info(String.format("Sum map sum before return %s", sumMap.getOrDefault("sum", 0)));
                return sumMap;
            }
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
