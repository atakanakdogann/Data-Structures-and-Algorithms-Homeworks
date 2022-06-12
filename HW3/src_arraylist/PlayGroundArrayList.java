import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGroundArrayList implements basicInterface{
    //PlayGround Array
    private int[][] arr;
    // Building Array. I decided maximum 10 building for street
    private ArrayList<Buildings> buildings = new ArrayList<Buildings>();
    //Size of street and static counter for buildings
    private int street_size;
    private static int buildingCount = 0;
    //Empty no parameter constructor
    public PlayGroundArrayList(){

    }
    //User selected size for street
    public PlayGroundArrayList(int str_sz){
        street_size = str_sz;
    }
    //These are color codes for Sky Silhouette
    public static final String ANSI_BG_WHITE  = "\u001B[47m";
    public static final String ANSI_RESET  = "\u001B[0m";

    //Print Sky Silhouette of Street 
    public void printPlayGround(){

        //For Loop to Print Buildings
        for(int i = 0;i < 30; i++){
            for(int j = 0;j < street_size; j++){
                if(arr[i][j] == 1 || arr[i][j] == 3){
                    System.out.printf(ANSI_BG_WHITE + "  " + ANSI_RESET);
                }
                else
                    System.out.printf("  ");
            }
            System.out.printf("\n");
        }
        //For Loop to Print Basement
        for(int i = 0;i < street_size; i++){
            System.out.printf(ANSI_BG_WHITE + "  " + ANSI_RESET);

        }
        System.out.printf("\n");
    }

    public void createPlayGround(){
        //Creates array according to street size
        arr = new int[32][street_size];
        //50 and 51 is basement for 2 sides of road
        //I presented basement in int array with '2'
        for(int i = 30;i < 32 ;i++){
            for(int j = 0;j < street_size;j++){
                arr[i][j] = 2;
            }
        }

    }
    public void driverMethod(){
        //ADD HOUSE
        buildings.add(new House());
        buildings.get(buildingCount).setSide(0);    buildings.get(buildingCount).setPosition(6);
        buildings.get(buildingCount).setLength(12); buildings.get(buildingCount).setHeight(24);
        buildings.get(buildingCount).setOwner("Oguzhan Akdogan");    buildings.get(buildingCount).setColor("Green"); buildings.get(buildingCount).setRoomNumber(3);
        //Fills PlayGround Array
        for(int i = 30 - buildings.get(buildingCount).getHeight(); i < 30; i++){
            for(int j = buildings.get(buildingCount).getPosition()-(buildings.get(buildingCount).getLength()/2); j < buildings.get(buildingCount).getPosition()+(buildings.get(buildingCount).getLength()/2); j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 3;
                }
                else
                    arr[i][j] = 1;
            }
        }
        //Fills Basement with 1
        for(int i = 0; i < 20;i++){
            arr[30][i] = 1;
        }
        buildingCount++;
        //ADD OFFICE
        buildings.add(new Office());
        buildings.get(buildingCount).setSide(1);    buildings.get(buildingCount).setPosition(15);
        buildings.get(buildingCount).setLength(12); buildings.get(buildingCount).setHeight(10);
        buildings.get(buildingCount).setOwner("Michael Scott");    buildings.get(buildingCount).setJobType("Paper Company");
        for(int i = 30 - buildings.get(buildingCount).getHeight(); i < 30; i++){
            for(int j = buildings.get(buildingCount).getPosition()-(buildings.get(buildingCount).getLength()/2); j < buildings.get(buildingCount).getPosition()+(buildings.get(buildingCount).getLength()/2); j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 3;
                }
                else
                    arr[i][j] = 1;
            }
        }
        for(int i = 5; i < 25;i++){
            arr[31][i] = 1;
        }
        buildingCount++;
        //ADD MARKET
        buildings.add(new Market());
        buildings.get(buildingCount).setSide(0);    buildings.get(buildingCount).setPosition(24);
        buildings.get(buildingCount).setLength(14); buildings.get(buildingCount).setHeight(9);
        buildings.get(buildingCount).setOwner("A101");    buildings.get(buildingCount).setJobTimes("08.30", "22.00");
        for(int i = 30 - buildings.get(buildingCount).getHeight(); i < 30; i++){
            for(int j = buildings.get(buildingCount).getPosition()-(buildings.get(buildingCount).getLength()/2); j < buildings.get(buildingCount).getPosition()+(buildings.get(buildingCount).getLength()/2); j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 3;
                }
                else
                    arr[i][j] = 1;
            }
        }
        for(int i = 25; i < 37;i++){
            arr[30][i] = 1;
        }
        buildingCount++;
        //Printed Street
        printPlayGround();
        //I listed buildings and their properties
        display_buildings();
        //Remaining or ratio or .. some statistics asked in the PDF
        statistics_of_street();

    }
    public void addBuilding(int side,int pos,int len,int hei)throws Exception{
        //Scan utility
        Scanner sc = new Scanner(System.in);
        //Temp variables for Scanning
        String tempStr,tempStr2;
        int temp;

        //Checks playground(30 or 31 acc. to side) if used or unused
        //pos-(len/2) and pos+(len/2) because in My Program position meaning middle point of Building
        //in 30 and 31. index of arra, free means 2. If there is any 1,placement becomes illegal
        if(pos>=street_size){
            throw new IOException("Pos must be smaller or equal than "+street_size);
        }else if(pos+(len/2)>street_size){
            throw new IOException("Pos+ Length/2 must be smaller or equal than "+street_size);
        }else if((pos-len/2)<0){
            throw new IOException("Pos+ Length/2 must be greater or equal than 0 ");
        }else{
            for(int i = pos-(len/2); i < pos+(len/2);i++){
                if(arr[30+side][i] == 1){
                    System.out.println("Placement is illegal!");
                    return;
                }
            }
            //Fills PlayGround Array
            for(int i = 30-hei; i < 30; i++){
                for(int j = pos-(len/2); j < pos+(len/2); j++){
                    if(arr[i][j] == 1){
                        arr[i][j] = 3;
                    }
                    else
                        arr[i][j] = 1;
                }
            }
            //Fills Basement
            for(int i = pos-(len/2); i < pos+(len/2);i++){
                arr[30+side][i] = 1;
            }
            //Setting up properties
            while(true){
                System.out.println("Please enter Type of Building");
                tempStr = sc.nextLine();
                if(tempStr.equalsIgnoreCase("House")){
                    buildings.add(new House());
                    System.out.println("Please enter Owner of House");
                    tempStr = sc.nextLine();
                    buildings.get(buildingCount).setOwner(tempStr);
                    System.out.println("Please enter Color of House");
                    tempStr = sc.nextLine();
                    buildings.get(buildingCount).setColor(tempStr);
                    System.out.println("Please enter Room Number of House");
                    temp = sc.nextInt();
                    buildings.get(buildingCount).setRoomNumber(temp);
                    break;
                }
                else if(tempStr.equalsIgnoreCase("Office")){
                    buildings.add(new Office());
                    System.out.println("Please enter Owner of Office");
                    tempStr = sc.nextLine();
                    buildings.get(buildingCount).setOwner(tempStr);
                    System.out.println("Please enter Job Type of Office");
                    tempStr = sc.nextLine();
                    buildings.get(buildingCount).setJobType(tempStr);
                    break;
                }
                else if(tempStr.equalsIgnoreCase("Market")){
                    buildings.add(new Market());
                    System.out.println("Please enter Owner of Market");
                    tempStr = sc.nextLine();
                    buildings.get(buildingCount).setOwner(tempStr);
                    System.out.println("Please enter Openning time of Market");
                    tempStr = sc.nextLine();
                    System.out.println("Please enter Closing time of Market");
                    tempStr2 = sc.nextLine();
                    buildings.get(buildingCount).setJobTimes(tempStr, tempStr2);
                    break;
                }
            }
            buildings.get(buildingCount).setSide(side);
            buildings.get(buildingCount).setPosition(pos);
            buildings.get(buildingCount).setLength(len);
            buildings.get(buildingCount).setHeight(hei);
            buildingCount++;
        }


    }

    public void deleteBuilding()throws Exception{
        Scanner sc = new Scanner(System.in);
        //First I listed Buildings and Scan for selection
        if(buildings.length<=0){
            throw new Exception("You cannot delete antything there is no building in street");
        }
        for(int i = 0; i < buildingCount; i++){
            System.out.printf("%d-) %s\n",i, buildings.get(i).getClass());
            System.out.println(buildings.get(i).toString());
        }
        System.out.println("Select which building you want to delete");
        int temp = sc.nextInt();
        //Deleting building
        if(temp<0){
            throw new IOException("You need to enter greater or equal than 0");
        }
        if(temp>=buildings.length){
            throw new NullPointerException("Out of index bound");
        }
        
        boolean flag =false;
        for(int i=0;i<buildings.length;++i){
            if(buildings.get(i).equals(buildings.get(temp))){
                 flag=true;
                 break;
            }
        }
        //Cleans from map
        for(int i = 30 - buildings.get(temp).getHeight(); i < 30; i++){
            for(int j = buildings.get(temp).getPosition()-(buildings.get(temp).getLength()/2);j < buildings.get(temp).getPosition()+(buildings.get(temp).getLength()/2);j++){
                if(arr[i][j] == 3){
                    arr[i][j] = 1;
                }
                else if(arr[i][j] == 1){
                    arr[i][j] = 0;
                    arr[30+buildings.get(temp).getSide()][j] = 2;
                }

                
            }
        }
        //Cleans from building array
        for(int i = temp; i < buildingCount-1; i++){
            buildings.add(i,buildings.get(i+1));
        }
        buildingCount--;
    }

    public void statistics_of_street(){
        //Some counters
        int side0_counter = 0,side1_counter = 0;
        int occupy_counter = 0;
        for(int i = 0; i < street_size; i++){
            if(arr[30][i] == 2){
                side0_counter++;
            }
            else
                occupy_counter++;
        }
        for(int i = 0; i < street_size; i++){
            if(arr[31][i] == 2){
                side1_counter++;
            }
            else
                occupy_counter++;
        }
        //Printings
        System.out.printf("There is %d and ratio of %d remaining lands on street frontside\n", side0_counter,100*side0_counter/street_size);
        System.out.printf("There is %d and ratio of %d remaining lands on street backside\n", side1_counter,100*side1_counter/street_size);
        System.out.printf("Total length occupied by the buildings is %d\n",occupy_counter);
    }

    public void display_buildings(){
        //List Buildings and their properties
        System.out.println("----List Of the Buildings----");
        for(int i = 0; i < buildingCount; i++){
            System.out.printf("%d-) %s\n",i, buildings.get(i).getClass());
            System.out.println(buildings.get(i).toString());
        }
    }

    public void focus_method(){
        //Wants selection from user and goes to selection getFocus method
        Scanner sc = new Scanner(System.in);
        int selected;
        System.out.println("Please enter the Number of Building");
        System.out.printf("0-)PlayGround\n");
        for(int i = 0;i < buildingCount; i++){
            System.out.printf("%d-)",i+1);
            System.out.println(buildings.get(i).toString());
        }
        selected  = sc.nextInt();
        if(selected == 0){
            System.out.printf("There is %d Unit in the PlayGround",street_size);
        }
        else {
            System.out.printf("%s\n", buildings.get(selected-1).getFocus());
        }
    }
    @Override
    public boolean equals(Object anObject) {    
        if (this == anObject) {    
            return true;    
        }    
        else
            return false;
    }
}