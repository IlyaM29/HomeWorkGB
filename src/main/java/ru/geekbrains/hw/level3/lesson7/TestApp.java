package ru.geekbrains.hw.level3.lesson7;

public class TestApp {

    @BeforeSuite
    public void before() {
        System.out.println("before test");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test(priority = 1)
    public void test2() {
        System.out.println("test2 (1)");
    }
    @Test(priority = 10)
    public void test3() {
        System.out.println("test3 (10)");
    }
    @Test
    public void test4() {
        System.out.println("test4");
    }

    @AfterSuite
    public void after() {
        System.out.println("after test");
    }

}
