package sk.itsovy.vlakna;

import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;



public class Vlakno2 implements Runnable {

    private Data data;

    public Vlakno2(Data data)
    {
        this.data = data;
    }

    @Override
    public void run()
    {
        String packets[] = generatorCisel();

        for(String packet : packets)
        {
            data.send(packet);

            try
            {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,7000));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String[] generatorCisel()
    {

        String[] array = new String[11];

        int[] array2 = new int[10];

        Random random = new Random();


        for(int i = 0; i<array2.length; i++)
        {
            array2[i]=i+1;

            array[i] = String.valueOf(array2[i]);
        }

        int i = 0;

        while(i != 10)
        {
            int cislo =random.nextInt(10);

            int cislo2 =random.nextInt(10);


            String temp = array[cislo];

            array[cislo] = array[cislo2];

            array[cislo2] = temp;

            i++;
        }
        array[10] = "Koniec";

        return array;
    }
}
