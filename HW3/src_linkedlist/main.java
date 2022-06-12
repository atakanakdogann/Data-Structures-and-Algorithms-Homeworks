import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        int selection,selection2,selection3;
        int street_size;
        int side,pos,len,hei;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Street Size");
        street_size = sc.nextInt();
        PlayGroundLinkedList pg1 = new PlayGroundLinkedList(street_size);
        
        pg1.createPlayGround();
        pg1.driverMethod();

        while(true){
            System.out.println("Please select mode:");
            System.out.println("1-Editing Mode");
            System.out.println("2-Wiewing Mode");
            System.out.println("3-Exit");
            selection = sc.nextInt();
            switch(selection){
                case 1:
                    while(true){
                        System.out.println("1-Add Building");
                        System.out.println("2-Delete Building");
                        selection2 = sc.nextInt();
                        if(selection2 == 1){
                            System.out.println("Enter Side(0 for frontside 1 for backside)");
                            side = sc.nextInt();
                            System.out.printf("Enter Position(0 to %d)\n",street_size);
                            pos = sc.nextInt();
                            System.out.println("Enter Length of Building");
                            len = sc.nextInt();
                            System.out.println("Enter Height of Building(Max 30)");
                            hei = sc.nextInt();
                            try {
                                pg1.addBuilding(side, pos, len, hei);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            
                            break;
                        }
                        else if(selection2 == 2){
                            try {
                                pg1.deleteBuilding();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            
                            break;
                        }
                    }
                    
                    break;

                case 2:
                    System.out.println("1-Display List of the Buildings");
                    System.out.println("2-Display remaining and ratio land on Street");
                    System.out.println("3-Display the Skyline Silhouette");
                    System.out.println("4-Focus Method");
                    selection3 = sc.nextInt();
                    switch(selection3){
                        case 1:
                            pg1.display_buildings();
                            break;

                        case 2:
                            pg1.statistics_of_street();
                            break;

                        case 3:
                            pg1.printPlayGround();
                            break;

                        case 4:
                            pg1.focus_method();
                            break;

                        default:
                            System.out.println("Error! Try Again");
                            break;
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Error! Try Again!");
                    break;

            }

        }
    }
    
}
