import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapEx {
    public static void main(String[] args) {
        WeakHashMap<String,Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);
        System.out.println(imageCache);
        System.gc();
        runTheApplication();
        System.out.println("Cache after running (some entries may be cleared): " +imageCache);
    }

    public static void loadCache(Map<String,Image> imageCache){
        String key1 = new String("img1");
        String key2 = new String("img2");
        imageCache.put(key1,new Image("Image 1"));
        imageCache.put(key2,new Image("Image 2"));
    }

    private static void runTheApplication(){
        try{
            System.out.println("Running Application...");
            Thread.sleep(10000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            System.err.println("Exception Occurred : " + ex);
        }
    }
}

class Image{
    private String name;

    public Image(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
