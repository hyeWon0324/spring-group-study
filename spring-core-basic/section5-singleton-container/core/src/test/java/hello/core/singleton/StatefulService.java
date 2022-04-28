package hello.core.singleton;

public class StatefulService {

//    private int price; //상태를 유지하는 필드 --> 이러한 필드는 존재할 필요없다.

    public int getPrice() {
        return price;
    }

    public int order (String name, int price) {
        System.out.println("name= " + name + ", price= " +price);

//        this.price = price;
     return price;
    }


}
