package jeongjy.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

    private static final HelloRepository helloRepositoryStub = new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
    };

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);

        String ret = helloDecorator.sayHello("Test");

        assertThat(ret).isEqualTo("*Test*");
    }
}
