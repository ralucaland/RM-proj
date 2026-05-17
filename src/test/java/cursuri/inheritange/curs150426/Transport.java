package cursuri.inheritange.curs150426;

    public class Transport {
        //protected int speed
        private int speed;
        public Transport(int speed){
            this.speed= speed;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void move() {
            System.out.println("Transportul se deplaseaza cu viteza: " + speed);
        }
    }

