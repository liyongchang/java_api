package order.impl;

import order.OrderConstant;
import order.Purchase;
import order.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Purchase purchase;
    private static final int one_time_size = 1000;


    @Override
    public void purchaseTask() {
        //拿到库存ids
        Set<String> productIdList = stringRedisTemplate.opsForSet().members(OrderConstant.PRODUCT_SCHEDULE_SET);
        List<PurchaseRecordPo> purchaseRecordPos = new ArrayList<>();
        for (String productIdStr : productIdList) {
            Long productId = Long.parseLong(productIdStr);
            String purchaseKey = OrderConstant.PURCHASE_PRODUCT_LIST + productId;
            BoundListOperations<String, String> ops = stringRedisTemplate.boundListOps(purchaseKey);
            long size = stringRedisTemplate.opsForList().size(purchaseKey);
            long times = size % one_time_size == 0 ? size / one_time_size : size / one_time_size + 1;
            for (int i = 0; i < times; i++) {
                List<String> prList = null;
                if (i == 0) {
                    prList = ops.range(i * one_time_size, (i + 1) * one_time_size);
                } else {
                    prList = ops.range(i * one_time_size + 1, (i + 1) * one_time_size);
                }

                for (String prStr : prList) {
                    PurchaseRecordPo purchaseRecordPo = this.createPR(productId, prStr);
                    purchaseRecordPos.add(purchaseRecordPo);
                }
                purchase.dealRedisPurchase(purchaseRecordPos);
                prList.clear();
            }
            stringRedisTemplate.delete(purchaseKey);
            stringRedisTemplate.opsForSet().remove(OrderConstant.PRODUCT_SCHEDULE_SET, productIdStr);
        }

    }

    private PurchaseRecordPo createPR(Long productId, String prStr) {
        String[] strings = prStr.split(",");
        Long userId = Long.parseLong(strings[0]);
        Double qty = Double.parseDouble(strings[1]);
        Double sum = Double.parseDouble(strings[2]);
        Double price = Double.parseDouble(strings[3]);
        Long time = Long.parseLong(strings[4]);
        return null;
    }

    public class PurchaseRecordPo {
    }
}
