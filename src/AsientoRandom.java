import java.util.Random;

public class AsientoRandom {

    private Random random;

    public AsientoRandom() {
        this.random = new Random();
    }

    public int generarAsiento() {
        return random.nextInt(10) + 1;
    }
}