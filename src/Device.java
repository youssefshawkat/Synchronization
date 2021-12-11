public class Device extends Thread{

    private final String name;
    private final String type;
    private final Router r;
    private int connection = 0;
    private String state = "Arrived";


    Device(String n, String t,Router r)
    {
        name = n;
        type = t;
        this.r = r;
    }
    public void setConnection(int id){

        connection = id;


    }

    public void run()
    {

        r.connect(this);


        System.out.println("Connection "+connection+" : " +name + " login");



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Connection " + connection +" :" +name + " performing online activity");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Connection " + connection +" :" +name + " logout");

        r.disconnect(this);

    }


    public String getname(){

       return name;
    }
    public void Setstate(String s){

        state = s;
    }

    public void getstate() {
        System.out.println(this.name  + " " + this.type + " " +state);
    }
}
