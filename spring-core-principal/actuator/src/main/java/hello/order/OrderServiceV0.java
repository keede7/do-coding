package hello.order;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV0
implements OrderService{

    

    @Override
    public void order() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public AtomicInteger getStock() {
        return null;
    }
}
