package helloworld;

public class TestInheritence {

    class A {
        int aInt;

        public A(int a) {
            this.aInt = a;
        }
    }

    class B extends A {
        public B (int newInt) {
            super(0);
            this.aInt = newInt;
        }
    }
}
