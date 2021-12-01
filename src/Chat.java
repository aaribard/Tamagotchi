public class Chat extends Animal{
    private int a=0;
    Chat(String n)
    {
        super(n);
        super.type=1;
    }
    public void manger()
    {
        a++;
    }
    public int getA()
    {
        return a;
    }
}