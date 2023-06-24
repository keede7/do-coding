package hello.order.v2;

import hello.order.OrderService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV2
implements OrderService {

    private AtomicInteger stock
            = new AtomicInteger(100);

    private final MeterRegistry meterRegistry;

    public OrderServiceV2(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    // 이미 AOP를 제공하고 있다.
    // tag, method를 모두 지정해준다.
    // class 이름, method 이름
    @Counted("my.order")
    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
    }

    @Counted("my.order")
    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {

        return stock;
    }
}
