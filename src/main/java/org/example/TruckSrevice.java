package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckSrevice {



    public void addTruck(Truck truck){

        String quary="insert into truck (name,model,capacity,driver_name) values(?,?,?,?)";

        try {

            Connection connection=ConnectionDemo.getconnection();

            PreparedStatement pstmt=connection.prepareStatement(quary);
            pstmt.setString(1,truck.getName());
            pstmt.setString(2,truck.getModel());
            pstmt.setInt(3,truck.getCapacity());
            pstmt.setString(4,truck.getDriver_name());

            int i = pstmt.executeUpdate();
            System.out.println("row affected = "+i);

        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public  Truck getTruckById(int id){

        String quary="select * from truck where id= ?";

        Truck  truck=new Truck();

        try {

            Connection connection=ConnectionDemo.getconnection();

            PreparedStatement pstmt=connection.prepareStatement(quary);

            pstmt.setInt(1,id);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));



            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  truck;


    }

    public void updateTruck(Truck truck) throws SQLException {

        String quary="update truck set name=?,model=?,capacity=?,driver_name=? where id=?";

        Connection connection=ConnectionDemo.getconnection();

        PreparedStatement pstmt=connection.prepareStatement(quary);
        pstmt.setString(1,truck.getName());
        pstmt.setString(2,truck.getModel());
        pstmt.setInt(3,truck.getCapacity());
        pstmt.setString(4,truck.getDriver_name());
        pstmt.setInt(5,truck.getId());

        int i = pstmt.executeUpdate();
        System.out.println("row affected"+i);


    }

    public List<Truck> getAlltrucks() {
        String quary = "select * from truck";

        List<Truck> trucks = null;
        try {
           trucks = new ArrayList<>();
            Connection connection = ConnectionDemo.getconnection();

            Statement pstmt = connection.createStatement();
            ResultSet resultSet = pstmt.executeQuery(quary);


            while (resultSet.next()) {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
                trucks.add(truck);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public void deleteTruck(int id){
        String quary="delete from truck where id= ?";

        try {
           Truck truck=new Truck();
            Connection connection=ConnectionDemo.getconnection();

            PreparedStatement pstmt=connection.prepareStatement(quary);

            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            System.out.println("row deleted :  "+i);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
