package cursuri.inheritange.curs150426;

public class Train extends Transport {
    public Train(int speed) {
        super(speed);
    }
    @Override
    public void move(){
        System.out.println("Trenul merge cu o viteza de " + getSpeed() );
    }
}

