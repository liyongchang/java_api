package order.impl;

import order.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.List;

import static order.OrderConstant.PRODUCT_SCHEDULE_SET;
import static order.OrderConstant.PURCHASE_PRODUCT_LIST;

public class PurchaseImpl implements Purchase {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String sha1 = null;

    static String purchaseScript = "redis.call('sadd',KEY[1],ARGV[2]) \n"
            + "local productPurchaseList=KEYS[2]..ARGV[2] \n "
            + "local userId=ARGV[1] \n"
            + "local product='product_'..ARGV[2] \n"
            + "local qty=tonumber(ARGV[3]) \n"
            + "local stock=tonumber(redis.call('hget',product,'stock')) \n"
            + "local price=tonumber(redis.call('hget',product,'price')) \n"
            + "local purchase_date=ARGV[4] \n"
            + "if stock<qty then return 0 end \n"
            + "stock =stock-qty \n"
            + "redis.call('hset',product,'stock',tostring(stock)) \n"
            + "local sum=price*qty \n"
            + "local purchaseRecord=userId..','..qty..',' \n"
            + "..sum..','..price..','..purchase_date \n"
            + "redis.call('rpush',productPurchaseList,purchaseRecord) \n"
            + "return 1 \n";

    public static void main(String[] args) {
        System.out.println(purchaseScript);
    }

    /**
     * 当前事务挂起，开启新的事务。
     * 回滚只回滚方法内部事务，不影响全局事务。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void dealRedisPurchase(List<TaskServiceImpl.PurchaseRecordPo> purchaseRecordPos) {

    }

    @Override
    public boolean purchaseRedis(String productId, Integer qty, BigDecimal price, String userId) {
        Jedis jedis = null;
        try {
            jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
            if (sha1 == null) {
                sha1 = jedis.scriptLoad("");
            }
            //执行脚本返回
            Object res = jedis.evalsha(sha1, 2,
                    PRODUCT_SCHEDULE_SET, PURCHASE_PRODUCT_LIST, userId, productId, qty + "", System.currentTimeMillis() + "");
            Long result = (Long) res;
            return result == 1;
        } finally {
            if (jedis != null && jedis.isConnected()) {
                jedis.close();
            }
        }
    }
}
