package ch.hslu.ad.sw02;

public final class MethodInvocationMess {
    private static int taskOneCalled = 0;
    private static int taskTwoCalled = 0;
    private static int taskThreeCalled = 0;

    public static void task(final int n) {
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            for (int j = 0; j < n; j++) {
                task3(); task3();
            }
        }

        System.out.printf("task1 called %s times%n", taskOneCalled);
        System.out.printf("task2 called %s times%n", taskTwoCalled);
        System.out.printf("task3 called %s times%n", taskThreeCalled);
    }

    private static void task1() {
        taskOneCalled++;
    }

    private static void task2() {
        taskTwoCalled++;
    }

    private static void task3() {
        taskThreeCalled++;
    }
}
