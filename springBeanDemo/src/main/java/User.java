import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements ApplicationContextAware {
    private String id;

    private String userName;

    private User() {
        System.out.println("11111User()");
    }

    public void userInit() {
        System.out.println("11111userInit()");

    }

    public void userDestroy() {
        System.out.println("11111destory()");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("11111setId"+id);
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("11111setUserName"+userName);
        this.userName = userName;
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
