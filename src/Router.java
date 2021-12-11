public class  Router {

    private final semaphore connections;
    private static Device [] Devices ;
    private static semaphore devices;
    private int count;
    private final int NUM_C;


    Router(int c, int d){
        NUM_C = c;
        count = d;
        connections = new semaphore(c);
        devices = new semaphore(c);
        Devices = new Device[c];


    }


    public void connect(Device d){
        devices.P();
        count--;

       if(count < NUM_C){

            d.Setstate("Arrived and Waiting");

        }

        d.getstate();
        connections.P();


        devices.V();

        for( int i = 0 ; i < Devices.length ; i++){

            if(Devices[i] == null)
            {
                Devices[i] = d;
                Devices[i].setConnection(i+1);
                System.out.println("Connection " + (i+1) +" : " + d.getname() + " Occupied");

                break;
            }
        }


    }

    public void disconnect(Device d){

        connections.V();

        for( int i = 0 ; i < Devices.length ; i++){


            if(Devices[i] == d)
            {
                Devices[i] = null;

            }
        }


    }




}
