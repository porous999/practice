package helloworld.designpatterns.observer;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ObservedThreadedSum {

    private Logger logger;

    class SumTask implements Runnable {

        private final int[] numArray;
        SumMaster sumMaster;

        SumTask(int[] numArray, SumMaster sumMasterInst) {
            this.numArray = numArray;
            sumMaster = sumMasterInst;
            logger = Logger.getLogger(SumTask.class.getSimpleName());
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < numArray.length; i++) {
                //logger.debug("num array[" + i + "]= " + numArray[i]);
                sum += numArray[i];
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            logger.info(String.format("Updating sum: %d ::: Array: %s", sum, Arrays.toString(numArray)));
            sumMaster.updateSum(sum);
        }
    }

    class SumMaster {
        private final Map<String, Integer> resultMap;
        int[] numArray;

        synchronized void updateSum(int sum) {
            resultMap.put("sum", resultMap.getOrDefault("sum", 0) + sum);
            logger.info(String.format("Sum: %d ::: ResultMap.sum: %d", sum, resultMap.getOrDefault("sum", 0)));
        }

        SumMaster(Map<String, Integer> totalsMap, int[] numArray) {
            resultMap = totalsMap;
            this.numArray = numArray;
            logger = Logger.getLogger(SumMaster.class.getSimpleName());
        }
        
        void processSum(SumMaster sumMasterInst) throws InterruptedException {
            ExecutorService execs = Executors.newFixedThreadPool(3);
            int i;
            for (i = 0; i < numArray.length - 3; i += 3) {
                SumTask thisSummation = new SumTask(Arrays.copyOfRange(numArray, i, i + 3), sumMasterInst);
                execs.submit(thisSummation);
            }
            SumTask thisSummation = new SumTask(Arrays.copyOfRange(numArray, i, i+1), sumMasterInst);
            execs.submit(thisSummation);
            execs.shutdown();
            execs.awaitTermination(5, TimeUnit.MINUTES);
        }
    }
}
