/**
 * Author: Sweetie77
 * Created: 2019/4/24
 */
public class DemoTest {
    static class Point<T>{
        private T x;
        private T y;

        public T getX() {
            return x;
        }

        public void setX(T x) {
            this.x = x;
        }

        public T getY() {
            return y;
        }

        public void setY(T y) {
            this.y = y;
        }
    }
    public static void main(String[] args) {
     //设置数据
     Point<String> p = new Point<String>();
     p.setX("东经80度");
     p.setY("北纬20度");
     //取出数据
        String x= p.getX();//避免了向下转型
        String y = p.getY();
        System.out.println(x);
        System.out.println(y);
    }

}
