package sk.itsovy.vlakna;

public class Main {


    public static void main(String[] args)
    {

        Data data = new Data();

        Thread sender = new Thread(new Vlakno1(data));

        Thread receiver = new Thread(new Vlakno2(data));

        receiver.start();

        sender.start();
    }

}
