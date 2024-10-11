package org.example;


import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */


public class App
{


    public static void main( String[] args ) throws SQLException {

        TruckSrevice truckSrevice=new TruckSrevice();


        Scanner scanner=new Scanner(System.in);

        while (true) {

            System.out.println("choose the Operation:");

            System.out.println(" 1 . Add truck ...");
            System.out.println(" 2 . get truck byId ...");
            System.out.println(" 3 . get Update truck data...");
            System.out.println(" 4 . display all trucks...");
            System.out.println("5 . delete Truck...");
            System.out.println("6 . Exit...");


            int choose1 = scanner.nextInt();

            switch (choose1) {
                case 1: {

                    System.out.println("Enter the truck name :");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter the model :");
                    String model = scanner.nextLine();
                    System.out.println("Enter the driver_name :");
                    String driver_name = scanner.nextLine();
                    System.out.println("Enter the Capacity of truck :");
                    int capacity = scanner.nextInt();


                    Truck truck1 = new Truck(name, model, driver_name, capacity);
                    truckSrevice.addTruck(truck1);
                    System.out.println("Successfully insert truck...");
                }
                break;
                case 2: {
                    System.out.println("Enter the Id to get truck :");
                    int id = scanner.nextInt();

                    Truck getTruckById = truckSrevice.getTruckById(id);
                    System.out.println("Truck Data" + getTruckById);
                }
                break;

                case 3: {
                    System.out.println("Enter the id you want to update data : ");
                    int id = scanner.nextInt();

                    Truck truck1 = truckSrevice.getTruckById(id);
                    System.out.println("choose the fild you want to change :");
                    System.out.println("1 . name");
                    System.out.println("2 . model");
                    System.out.println("3 . driver_name");
                    System.out.println("4 . capacity");

                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("Enter the name :");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            truck1.setName(name);
                            truckSrevice.updateTruck(truck1);
                            System.out.println("Update name Successfully...");
                            break;

                        case 2:
                            System.out.println("Enter the model :");
                            scanner.nextLine();
                            String model = scanner.nextLine();
                            truck1.setModel(model);
                            truckSrevice.updateTruck(truck1);
                            System.out.println("Update model Successfully...");
                            break;

                        case 3:
                            System.out.println("Enter the driver_name :");
                            scanner.nextLine();
                            String driver_name = scanner.nextLine();
                            truck1.setDriver_name(driver_name);
                            truckSrevice.updateTruck(truck1);
                            System.out.println("Update driver_name Successfully...");
                            break;

                        case 4:

                            System.out.println("Enter the capacity :");

                            int capacity = scanner.nextInt();
                            truck1.setCapacity(capacity);
                            truckSrevice.updateTruck(truck1);
                            System.out.println("Update capacity Successfully...");
                            break;

                    }


                }

                    break;

                case 4: {
                    List<Truck> alltrucks = truckSrevice.getAlltrucks();

                    System.out.println("all trucks :");
                    for (Truck truck1 : alltrucks) {
                        System.out.println(truck1);
                    }
                }
                break;
                case 5:
                {
                    System.out.println("Enter the Id you want to delete truck :");

                    int id=scanner.nextInt();
                    truckSrevice.deleteTruck(id);

                    break;

                }



                case 6:
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid operations");
            }

        }


    }
}
