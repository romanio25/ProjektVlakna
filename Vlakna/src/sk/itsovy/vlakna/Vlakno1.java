package sk.itsovy.vlakna;

import java.util.concurrent.ThreadLocalRandom;


public class Vlakno1 implements Runnable
{

    private Data load;

    public Vlakno1(Data load)
    {
        this.load = load;
    }


    @Override

    public void run()
    {
        for (String receivedMessage = load.receive();

             !"Koniec".equals(receivedMessage);

             receivedMessage = load.receive())
        {

            System.out.println(receivedMessage);

            try
            {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 7000));

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}