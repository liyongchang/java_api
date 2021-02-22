package order;

import order.impl.TaskServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public interface Purchase {

    public boolean purchaseRedis(String productId, Integer qty, BigDecimal price, String userId);

    void dealRedisPurchase(List<TaskServiceImpl.PurchaseRecordPo> purchaseRecordPos);
}
