import java.lang.ref.WeakReference;

public class GarbageCollectorEx {
    public static void main(String[] args) {
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple","Iphone 25pro max"));
        System.out.println(phoneWeakReference.get());
        System.gc();
        try{
            Thread.sleep(5000);
        }catch (Exception ex){
            Thread.currentThread().interrupt();
            System.out.println(ex);
        }
        System.out.println(phoneWeakReference.get());
    }

}



class Phone{
    private String brand;
    private String model;

    public Phone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}