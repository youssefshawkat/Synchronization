import javax.swing.*;



public class Network {




    public static void main(String[] args) {

        try{




            int Max = Integer.parseInt(JOptionPane.showInputDialog( "Please Enter The Max Number of Connections: "));
            Router r = new Router(Max);

            int D = Integer.parseInt(JOptionPane.showInputDialog("Please Enter The Number of Devices "));

            Device [] myDevices = new Device[D];

            String name,type;



            for(int i = 0 ; i < D ;i++) {


                name = JOptionPane.showInputDialog("Enter the Name of Device No. " + (i + 1));
                if(name == null){

                    System.exit(0);
                }
                type = JOptionPane.showInputDialog("Enter the Type of Device No. " + (i + 1));
                if(type == null){

                    System.exit(0);
                }

                myDevices[i] = new Device(name, type, r);

            }

            new GUI();

            for(int i = 0 ; i < D ;i++){

                myDevices[i].start();
            }










        } catch (NumberFormatException  | NullPointerException error) {

            System.exit(0);
        }


    }

}
