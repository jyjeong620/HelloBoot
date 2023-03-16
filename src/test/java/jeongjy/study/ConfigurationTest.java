package jeongjy.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {

    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        public Common common() {
            if (this.common == null) {
                this.common = super.common();
            }
            return this.common;
        }
    }
    @Configuration
    static class MyConfig {
        @Bean
        public Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2(common());
        }

        @Bean
        public Common common() {
            return new Common();
        }
    }

    static class Bean1 {
        private final Common common;

        public Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        public Bean2(Common common) {
            this.common = common;
        }
    }
    static class Common {
    }

}