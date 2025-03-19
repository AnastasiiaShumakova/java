package lab_1;

public class Trouble{
    private final String text;
    private final int index;

    public Trouble(String text, int index){
        this.text = text;
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }
}
