import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        double M = scanner.nextDouble();

        int seed = K;
        Random random = new Random();
        boolean check = true;

        while (check) {
            for (int i = 0; i < N; i++) {
                if (random.nextGaussian() > M) {
                    seed++;
                    random = new Random(seed);
                    break;
                }
                if (i == N - 1) {
                    check = false;
                }
            }
        }

        System.out.println(seed);

    }
}