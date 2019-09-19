import com.huarui.something.Car1;
import org.junit.Test;

/**
 * Created by sloan on 2019/9/11.
 */
public class CarTest {


    @Test
    public void test(){

        Car1 car1 = Car1.getInstance();
        Car1 car2 = Car1.getInstance();

        System.out.println(car1==car2);
    }

}
