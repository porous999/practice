package helloworld;

public class TryReflections {

    private final String varStr;
    private final int varInt;
    private final String SOME_CONST = "Class Const";

    public TryReflections() {
        varInt = 0;
        varStr = "Init!";
        System.out.println("Initialized with 0 params");
    }

    public TryReflections(int varInt, String varStr) {
        this.varInt = varInt;
        this.varStr = varStr;
        System.out.format("Initialized with params: %d, %s%n", varInt, varStr);
    }

    private void myPrivateMethod() {
        System.out.format("Whoa! This private method returns values: %d, %s%n", this.varInt, this.varStr);
    }

    private void myPrivateMethodWithParams(int num) {
        System.out.format("Whoa! This private method returns sum of %d + %d = %d%n", num, this.varInt, this.varInt + num);
    }
}
