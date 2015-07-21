/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sachin Shinde
 */
public class populate {
    //public void x(){
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {           
                        String buildingFile = args[0];
                        String hydrantFile = args[1];
                        String fireBuilding = args[2];
                        
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver( myDriver );
			//String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
                        String URL = "jdbc:oracle:thin:@dagobah.engr.scu.edu:1521:db11g";
                        
			//String USER = "hr";
			//String PASS = "root";
                        String USER = "sshinde@db11g";
                        String PASS = "sachin123";
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println(conn);

                        Statement stmt = null;
                        stmt = conn.createStatement();
                        
                            
                        /* start reading file*/
                        //reading file line by line in Java using BufferedReader       
                        FileInputStream fis = null;
                        BufferedReader reader = null;
                        StringBuffer query = new StringBuffer();
                        
                        stmt.execute("TRUNCATE TABLE BUILDINGS");
                        stmt.execute("TRUNCATE TABLE HYDRANTS");
                        
                        // populating Buildings table
                        //fis = new FileInputStream("D:\\Courses\\Database\\Assignments\\Assignment 3\\data\\building.xy");
                        fis = new FileInputStream(buildingFile);
                        reader = new BufferedReader(new InputStreamReader(fis));
                        String line = reader.readLine();
                        String[] token = null; 
                        
                        while(line != null){
                            if(line.length()!=0){
                                query.append("INSERT INTO BUILDINGS VALUES(");
                                token=line.toString().split(",");

                                query.append("'"+token[0].trim()+"'");
                                query.append(",");
                                query.append("'"+token[1].trim()+"'");
                                query.append(",");
                                query.append("'FALSE'");
                                query.append(",");
                                query.append("SDO_GEOMETRY(");
                                query.append("2003,NULL,NULL");
                                query.append(",");
                                query.append("SDO_ELEM_INFO_ARRAY(1,1003,1)");
                                query.append(",");
                                query.append("SDO_ORDINATE_ARRAY(");

                                for(int j=3;j<2+2*Integer.parseInt(token[2].trim());j++){
                                    query.append(token[j].trim()+","+token[j+1].trim());
                                    if(j<token.length-3){
                                        query.append(", ");
                                    }
                                    j=j+1;
                                }
                                query.append(")))"); 
                                //System.out.println(query);
                                stmt.executeUpdate(query.toString());
                                query.delete(0,query.length());
                            }
                            line = reader.readLine();
                            
                        }
                        reader.close();
                        fis.close();
                        
                        // populating hydrants table
                        FileInputStream fishydrant = null;
                        BufferedReader readerHydrant = null;
                        query.delete(0,query.length());
                        fishydrant = new FileInputStream(hydrantFile);
                        readerHydrant = new BufferedReader(new InputStreamReader(fishydrant));
                        line = readerHydrant.readLine();
                        token = null;
                        while(line != null){
                            if(line.length()!=0){
                                query.append("INSERT INTO HYDRANTS VALUES(");

                                token=line.toString().split(",");    
                                query.append("'"+token[0].trim()+"'");
                                query.append(",");
                                query.append("SDO_GEOMETRY(");
                                query.append("2001,NULL,");
                                query.append("SDO_POINT_TYPE(");
                                query.append(token[1].trim()+","+token[2].trim());
                                query.append(",");
                                query.append("NULL)");
                                query.append(",");
                                query.append("NULL");
                                query.append(",");
                                query.append("NULL)");
                                query.append(")");

                                System.out.println(query);
                                stmt.executeUpdate(query.toString());
                                query.delete(0,query.length());
                            }
                                line = readerHydrant.readLine();
                            
                        }
                        conn.commit();
                        readerHydrant.close();
                        fishydrant.close();
                        
                        //populating fire building
                        
                        FileInputStream fisFireBuilding = null;
                        BufferedReader readerFireBuilding = null;
                        query.delete(0,query.length());
                        fisFireBuilding = new FileInputStream(fireBuilding);
                        readerFireBuilding = new BufferedReader(new InputStreamReader(fisFireBuilding));
                        line = readerFireBuilding.readLine();
                        
                        while(line != null){
                            if(line.length()!=0){
                                query.append("UPDATE BUILDINGS SET ");
                                query.append("ONFIRE='TRUE' ");
                                query.append("WHERE NAME=");
                                query.append("'"+line.trim()+"'");
                                //query.append(";");
                                System.out.println(query);
                                stmt.executeUpdate(query.toString());
                                query.delete(0,query.length());
                            }
                            
                            
                            line = readerFireBuilding.readLine();
                        }
                            
                        
                        conn.commit();
                        readerFireBuilding.close();
                        fisFireBuilding.close();
                        
                        stmt.close();
                        
                        
                        

	} catch (SQLException e) {
        	e.printStackTrace();
	}
        catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

    }
}
