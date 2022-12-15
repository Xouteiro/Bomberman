package feupL15G01.model.game.elements;

public class Power extends TempBlock {

    private int type;
    //type 1 -> adicionar vidas
    //type 2 -> adicionar de 100 a 500 pontos
    //type 3 -> passa pela bomba
    //type 4 -> passa pelos tempBlocks
    //type 5 -> não morre para a bomba

    public Power(int x, int y) {
        super(x, y);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
