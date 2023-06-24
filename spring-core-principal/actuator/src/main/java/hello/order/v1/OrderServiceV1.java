package hello.order.v1;

import hello.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV1
implements OrderService {

    private AtomicInteger stock
            = new AtomicInteger(100);

    private final MeterRegistry meterRegistry;

    public OrderServiceV1(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(meterRegistry)
                .increment();
    }
// 처음에는 호출이 되지 않았다면 메트릭이 조회가 되지 않으므로
    // 기본값을 먼저 넣어둔다던지 하는 방향도 있음,
    // 카운터는 _total이 자동으로 붙어서 프로메테우스에 나타난다.
    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("cancel")
                .register(meterRegistry)
                .increment();
    }

    @Override
    public AtomicInteger getStock() {

        return stock;
    }
}
