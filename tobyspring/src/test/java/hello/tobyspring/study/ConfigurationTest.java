package hello.tobyspring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ConfigurationTest {

    @Test
    void configuration() {
        // 순수 자바코드라고 가정했을 떄 인스턴스가 2개 생성된다.
        Assertions.assertThat(new Common()).isSameAs(new Common()); // 다르다!

        Common common = new Common();
        Assertions.assertThat(common).isSameAs(common); // 같은 인스턴스 이므로 동일하다!

        MyConfig myConfig = new MyConfig();

        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common); // 다르다!!

        // 하지만 MyConfig를 스프링 컨테이너의 구성정보로 사용하게되면 동작 방식이 달라진다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean3 = ac.getBean(Bean1.class);
        Bean2 bean4 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean3.common).isSameAs(bean4.common); // 같다!
        /*
            동일하게 생성되는 이유는 무엇일까?
            순수 자바코드가 스프링밖에서 동작방식과 스프링 안에서 빈으로 등록되어 쓰여질때랑
            동작방식이 달라지기 때문이다.
            Configuration 이 적용되어 있으면 MyConfig 클래스가 등록될떄 프록시 Object가 생성되어
            그 Proxy가 등록된다.
         */

    }

    @Test
    void 스프링_빈으로등록될떄_프록시클래스를_사용해본다() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        // 이경우에는 스프링을 쓴건 아니지만 그 안에서 일어나는 일을 흉내내본것이다.
        Assertions.assertThat(bean1.common).isSameAs(bean2.common); // 같다!!

        // @Configuration proxyBeanMethod가 true이면 처음에 프록시 클래스로 생성하고 Bean Object로 사용하는 것이다.
        // 여러번 호출해도 딱 한개의 인스턴스만 사용하게 된다.

        // 만약 proxyBenaMethod를 false로 하게된다면 프록시 클래스로 생성하지 않게 한다.
        // 그래서 순수 자바코드로 만들어서 사용하는 것과 같은 격이 된다.

        /*
            이전에는 특별한이유가없으면 그냥 true로 두고 사용하는것을 권장하고
            false로 하면 직접 코드를 호출하는 방식이므로 버그가 생긴하도 경고인데,,
            최근에는 Bean 애노테이션이 붙은 메서드가 다른 메서드를 직접 호출하는방식이 아니고
            그 자체로 그 빈을 생성하는데 충분하다면 그냥 false로 둬도 상관없다고한다.
            예시로 SchedulingConfiguration 이 있다.
         */
    }

    // 스프링의 빈으로 등록될떄 생성되는 프록시 클래스
    static class MyConfigProxy extends MyConfig {

        private Common common;

        @Override
        Common common() {
            if(this.common == null) {
                this.common = super.common();
            }

            return this.common;
        }

    }

    @Configuration
    static class MyConfig {
        /*
            사실 순수 자바코드라고 생각하면 Common은 인스턴스가 2번 생성되고
            서로 같지 않다고 결과가 나와야 한다.
         */
        @Bean
        Common common() {
            return new Common();
        }

        /**
         * 각 빈들에 Common 인스턴스를 생성하는 메서드 빈을 주입해서 사용한다.
         * @return
         */
        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
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

    static class Common {}


}
