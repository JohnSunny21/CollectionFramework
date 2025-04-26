public class HashEx {

    // A simple hash program to demonstrate what a hash is.
    public static void main(String[] args) {
        System.out.println(simpleHash("ABC"));
        System.out.println(simpleHash("DFHDFH"));
    }

    public static int simpleHash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += (int) c;
        }
        return sum % 10;
    }
}
