import java.util.Random;

public class AsientoRandom {

    private final Random random;

    public AsientoRandom() {
        this.random = new Random();
    }

    public int generarAsiento() {
        return random.nextInt(10) + 1;
    }
}
