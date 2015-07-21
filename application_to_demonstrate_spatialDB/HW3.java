/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import static java.sql.JDBCType.STRUCT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.spatial.geometry.J3D_Geometry;
import oracle.spatial.geometry.*;
import oracle.sql.STRUCT;

/**
 *
 * @author Sachin AKA Scavy
 */
public class HW3 extends javax.swing.JFrame {
    
    double xCoordinate=0.0;
    double yCoordinate=0.0;
    ArrayList<Double> clickedPoints = new ArrayList<Double>();
    /**
     * Creates new form HW3
     */
    public HW3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queryGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        buildings = new javax.swing.JCheckBox();
        buildingsOnFire = new javax.swing.JCheckBox();
        hydrants = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        wholeRegion = new javax.swing.JRadioButton();
        rangeQuery = new javax.swing.JRadioButton();
        neighbourBuildings = new javax.swing.JRadioButton();
        closestFireHydrants = new javax.swing.JRadioButton();
        submitQuery = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryExecuted = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        map = new javax.swing.JLabel();
        currentCoordinates = new javax.swing.JLabel();
        clearQuery = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Active Feature Type", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        buildings.setText("Buildings");

        buildingsOnFire.setText("Buildings on Fire");

        hydrants.setText("Hydrants");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buildingsOnFire)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buildings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(hydrants)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildings)
                    .addComponent(hydrants))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buildingsOnFire)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Query", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        queryGroup.add(wholeRegion);
        wholeRegion.setSelected(true);
        wholeRegion.setText("Whole Region");
        wholeRegion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                wholeRegionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                wholeRegionFocusLost(evt);
            }
        });

        queryGroup.add(rangeQuery);
        rangeQuery.setText("Range Query");
        rangeQuery.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rangeQueryFocusGained(evt);
            }
        });

        queryGroup.add(neighbourBuildings);
        neighbourBuildings.setText("Find Neighbour Buildings");
        neighbourBuildings.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                neighbourBuildingsFocusGained(evt);
            }
        });

        queryGroup.add(closestFireHydrants);
        closestFireHydrants.setText("Find Closests Fire Hydrants");
        closestFireHydrants.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                closestFireHydrantsFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wholeRegion)
                    .addComponent(rangeQuery)
                    .addComponent(neighbourBuildings)
                    .addComponent(closestFireHydrants))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wholeRegion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rangeQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(neighbourBuildings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closestFireHydrants)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        submitQuery.setText("Submit Query");
        submitQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitQueryActionPerformed(evt);
            }
        });

        queryExecuted.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jScrollPane1.setViewportView(queryExecuted);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Current Mouse Location :");

        map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/map.jpg"))); // NOI18N
        map.setText("jLabel3");
        map.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mapMouseMoved(evt);
            }
        });
        map.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapMouseClicked(evt);
            }
        });

        currentCoordinates.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        clearQuery.setText("Clear Query");
        clearQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearQueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentCoordinates)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clearQuery)
                                .addComponent(submitQuery))
                            .addGap(79, 79, 79)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(submitQuery)
                        .addGap(26, 26, 26)
                        .addComponent(clearQuery))
                    .addComponent(map))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(currentCoordinates))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void submitQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitQueryActionPerformed
        // TODO add your handling code here:
            
            if(wholeRegion.isSelected()){
                showActiveFeatures();
            }
            if(neighbourBuildings.isSelected()){
                showNeighbourBuildings();
            }   
            if(rangeQuery.isSelected()){
                showSelectedGeomsInsRange();
            }
      
        
    }//GEN-LAST:event_submitQueryActionPerformed

    private void mapMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseMoved
        // TODO add your handling code here:
        // TODO add your handling code here:
        xCoordinate=evt.getPoint().getX();
        yCoordinate=evt.getPoint().getY();
        currentCoordinates.setText("("+xCoordinate+","+yCoordinate+")");
    }//GEN-LAST:event_mapMouseMoved

    private void clearQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearQueryActionPerformed
        // TODO add your handling code here:
        map.repaint();
        clickedPoints.clear();
        queryExecuted.setText("");
    }//GEN-LAST:event_clearQueryActionPerformed

    private void wholeRegionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wholeRegionFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_wholeRegionFocusLost

    private void neighbourBuildingsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_neighbourBuildingsFocusGained
            // TODO add your handling code here:
        map.repaint();
    }//GEN-LAST:event_neighbourBuildingsFocusGained

    private void wholeRegionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wholeRegionFocusGained
        // TODO add your handling code here:
        map.repaint();
    }//GEN-LAST:event_wholeRegionFocusGained

    private void rangeQueryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rangeQueryFocusGained
        // TODO add your handling code here:
        map.repaint();
    }//GEN-LAST:event_rangeQueryFocusGained

    private void closestFireHydrantsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closestFireHydrantsFocusGained
        // TODO add your handling code here:
        map.repaint();
    }//GEN-LAST:event_closestFireHydrantsFocusGained

    private void mapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseClicked
        // TODO add your handling code here:
        if(closestFireHydrants.isSelected()){
            xCoordinate=evt.getPoint().getX();
            yCoordinate=evt.getPoint().getY();
            findClosestFireHydrants(xCoordinate,yCoordinate);
        }
        if(rangeQuery.isSelected()){
            xCoordinate=evt.getPoint().getX();
            yCoordinate=evt.getPoint().getY();
            clickedPoints.add(xCoordinate);
            clickedPoints.add(yCoordinate);
            System.out.println(xCoordinate+","+yCoordinate);
            if(evt.getButton()==3){
                Graphics gr = map.getGraphics();
                int[] xtempArray=null;
                int[] ytempArray=null;
                int tempXCount = 0;
                int tempYCount = 0;
                gr.setColor(Color.red);
                xtempArray = new int[clickedPoints.size()/2];
                ytempArray = new int[clickedPoints.size()/2];
                for(int i=0;i<clickedPoints.size();i++){
                        if(i%2==0){
                            xtempArray[tempXCount] = (int)(clickedPoints.get(i)*1);
                            tempXCount = tempXCount+1;
                        }else{
                            
                            ytempArray[tempYCount] = (int)(clickedPoints.get(i)*1);
                            tempYCount = tempYCount+1;
                        }
                        
                        
                    } 
                    gr.drawPolygon(xtempArray, ytempArray, xtempArray.length);
            }
        }   
        
    }//GEN-LAST:event_mapMouseClicked


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HW3().setVisible(true);
            }
        });
    }
    
    public ResultSet getConnectionAndData(String query){
        ResultSet rs = null;
        try{
                        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver( myDriver );
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			String USER = "hr";
			String PASS = "root";
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
                        Statement stmt = conn.createStatement();
                        
                        rs = stmt.executeQuery(query);
                        
                        
                        
                        
        }catch (SQLException e) {
        	e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}       
        return rs;
    }
    
    public void showActiveFeatures(){
        Graphics g = map.getGraphics();
        ResultSet rs = null;
        JGeometry j_geom = null; 
        Object[] elements = null;
        STRUCT st = null;
        double[] outerOrdinates = null;
        int[] xtempArray=null;
        int[] ytempArray=null;
        int tempXCount = 0;
        int tempYCount = 0;
        String tempText = null;
        
            try {
                if(buildings.isSelected() && wholeRegion.isSelected()){
                    
                rs = null;
                rs = getConnectionAndData("SELECT * FROM BUILDINGS");
                while(rs.next()){
                    st = (oracle.sql.STRUCT) rs.getObject("shape");
                    j_geom= JGeometry.load(st);
                    outerOrdinates = j_geom.getOrdinatesArray();
                    tempXCount = 0;
                    tempYCount = 0;
                    g.setColor(Color.yellow);
                    xtempArray = new int[outerOrdinates.length/2];
                    ytempArray = new int[outerOrdinates.length/2];
                    for(int i=0;i<outerOrdinates.length;i++){
                        if(i%2==0){
                            xtempArray[tempXCount] = (int)outerOrdinates[i];
                            tempXCount = tempXCount+1;
                        }else{
                            
                            ytempArray[tempYCount] = (int)outerOrdinates[i];
                            tempYCount = tempYCount+1;
                        }
                        
                        
                    } 
                    g.drawPolygon(xtempArray, ytempArray, xtempArray.length);
                    
                }
                tempText = queryExecuted.getText();
                tempText = tempText+"SELECT * FROM BUILDINGS; ";
                queryExecuted.setText(tempText);
                
                }
                if(hydrants.isSelected() && wholeRegion.isSelected()){
                    rs = null;    
                    rs = getConnectionAndData("SELECT * FROM HYDRANTS");
                    System.out.println("insidde");
                    int xhyd=0;
                    int yhyd=0;
                    st = null;
                    j_geom = null;
                    outerOrdinates = null;
                    while(rs.next()){
                        st = (oracle.sql.STRUCT) rs.getObject("shape");
                        j_geom= JGeometry.load(st);
                        outerOrdinates = j_geom.getPoint();
                        System.out.println(outerOrdinates[0]);
                        outerOrdinates = j_geom.getPoint();
                        xhyd = (int)outerOrdinates[0];
                        yhyd = (int)outerOrdinates[1];
                        g.setColor(Color.green);
                        g.fillRect(xhyd, yhyd, 10, 10);
                    }
                    tempText = queryExecuted.getText();
                    tempText = tempText+"SELECT * FROM HYDRANTS; ";
                    queryExecuted.setText(tempText);
                }
                //for buildings on fire
                if((buildingsOnFire.isSelected() && wholeRegion.isSelected()) || neighbourBuildings.isSelected()){
                    rs = null;
                rs = getConnectionAndData("SELECT * FROM BUILDINGS WHERE ONFIRE='TRUE'");
                while(rs.next()){
                    st = (oracle.sql.STRUCT) rs.getObject("shape");
                    j_geom= JGeometry.load(st);
                    outerOrdinates = j_geom.getOrdinatesArray();
                    tempXCount = 0;
                    tempYCount = 0;
                    g.setColor(Color.RED);
                    xtempArray = new int[outerOrdinates.length/2];
                    ytempArray = new int[outerOrdinates.length/2];
                    for(int i=0;i<outerOrdinates.length;i++){
                        if(i%2==0){
                            xtempArray[tempXCount] = (int)outerOrdinates[i];
                            tempXCount = tempXCount+1;
                        }else{
                            
                            ytempArray[tempYCount] = (int)outerOrdinates[i];
                            tempYCount = tempYCount+1;
                        }
                        
                        
                    } 
                    g.drawPolygon(xtempArray, ytempArray, xtempArray.length);
                    
                }
                tempText = queryExecuted.getText();
                tempText = tempText+"SELECT * FROM BUILDINGS WHERE ONFIRE='TRUE'; ";
                queryExecuted.setText(tempText);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void showNeighbourBuildings(){
        
        double[] outerOrdinates = null;
        int[] xtempArray=null;
        int[] ytempArray=null;
        int tempXCount = 0;
        int tempYCount = 0;
        String tempText = null;
        try {
            
            ResultSet rs,tempRS,rsFordrawing = null;
            JGeometry j_geom = null; 
            STRUCT st,tempSt=null;
            Graphics gr = map.getGraphics();
            StringBuffer query = new StringBuffer();
            query.append("SELECT * FROM BUILDINGS WHERE ONFIRE='TRUE'");
            rs =getConnectionAndData(query.toString());
            rsFordrawing = rs;
            while(rs.next()){
                st = (oracle.sql.STRUCT) rs.getObject("shape");
                j_geom= JGeometry.load(st);
                query.delete(0,query.length());
                query.append("SELECT * FROM BUILDINGS B WHERE SDO_WITHIN_DISTANCE(B.shape,");
                query.append("SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(");
                for(int i=0;i<j_geom.getOrdinatesArray().length;i++){
                 query.append(j_geom.getOrdinatesArray()[i]);
                 if(i<j_geom.getOrdinatesArray().length-1){
                     query.append(",");
                 }
                }
                query.append(")),'distance=100') = 'TRUE'");
                System.out.println(query);
                tempRS=getConnectionAndData(query.toString());
                while(tempRS.next()){
                    System.out.println("inside");
                    st = (oracle.sql.STRUCT) tempRS.getObject("shape");
                    j_geom= JGeometry.load(st);
                    outerOrdinates = j_geom.getOrdinatesArray();
                    tempXCount = 0;
                    tempYCount = 0;
                    gr.setColor(Color.yellow);
                    xtempArray = new int[outerOrdinates.length/2];
                    ytempArray = new int[outerOrdinates.length/2];
                    for(int i=0;i<outerOrdinates.length;i++){
                        if(i%2==0){
                            xtempArray[tempXCount] = (int)outerOrdinates[i];
                            tempXCount = tempXCount+1;
                        }else{
                            
                            ytempArray[tempYCount] = (int)outerOrdinates[i];
                            tempYCount = tempYCount+1;
                        }
                        
                        
                    } 
                    gr.drawPolygon(xtempArray, ytempArray, xtempArray.length);
                }    
            }
            showActiveFeatures();
            queryExecuted.setText("");
            queryExecuted.setText("SELECT * FROM BUILDINGS B WHERE SDO_WITHIN_DISTANCE(B.shape,SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(677.0,320.0,708.0,337.0,690.0,368.0,661.0,351.0)),'distance=100') = 'TRUE'; \n");
            tempText = queryExecuted.getText();
            tempText = tempText+"SELECT * FROM BUILDINGS B WHERE SDO_WITHIN_DISTANCE(B.shape,SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(564.0,425.0,585.0,436.0,573.0,458.0,552.0,447.0)),'distance=100') = 'TRUE'; ";
            tempText = tempText+"SELECT * FROM BUILDINGS B WHERE SDO_WITHIN_DISTANCE(B.shape,SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(226.0,150.0,254.0,164.0,240.0,191.0,212.0,176.0)),'distance=100') = 'TRUE'; ";
            queryExecuted.setText(tempText);
            
        } catch (SQLException ex) {
            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showSelectedGeomsInsRange(){
        try {
        if(clickedPoints.size()>0){    
            JGeometry j_geom = null; 
            STRUCT st,tempSt=null;
            ResultSet rs = null;
            int tempXCount = 0;
            int tempYCount = 0;
            int[] xtempArray=null;
            int[] ytempArray=null;
            Graphics gr = map.getGraphics();
            double[] outerOrdinates = null;
            StringBuffer query = new StringBuffer();
            query.append("SELECT * FROM BUILDINGS C WHERE SDO_ANYINTERACT(C.SHAPE,");
            query.append("SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(");
            for(int i=0;i<clickedPoints.size();i++){
                query.append(clickedPoints.get(i));
                if(i<clickedPoints.size()-1){
                         query.append(",");
                }
            }
            query.append(")))='TRUE'");
            System.out.println(query.toString());
            queryExecuted.setText(query.toString());
            rs = getConnectionAndData(query.toString());

                while(rs.next()){
                    st = (oracle.sql.STRUCT) rs.getObject("shape");
                        j_geom= JGeometry.load(st);
                        outerOrdinates = j_geom.getOrdinatesArray();
                        tempXCount = 0;
                        tempYCount = 0;
                        gr.setColor(Color.yellow);
                        if(rs.getString("ONFIRE").equals("TRUE")){
                            System.out.println("inside build");
                            gr.setColor(Color.red);
                        }
                        xtempArray = new int[outerOrdinates.length/2];
                        ytempArray = new int[outerOrdinates.length/2];
                        for(int i=0;i<outerOrdinates.length;i++){
                            if(i%2==0){
                                xtempArray[tempXCount] = (int)outerOrdinates[i];
                                tempXCount = tempXCount+1;
                            }else{

                                ytempArray[tempYCount] = (int)outerOrdinates[i];
                                tempYCount = tempYCount+1;
                            }


                        } 
                        gr.drawPolygon(xtempArray, ytempArray, xtempArray.length);
                }
            query.delete(0, query.length());
            // for Hydrants
            query.append("SELECT * FROM HYDRANTS C WHERE SDO_ANYINTERACT(C.SHAPE,");
            query.append("SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(");
            for(int i=0;i<clickedPoints.size();i++){
                query.append(clickedPoints.get(i));
                if(i<clickedPoints.size()-1){
                         query.append(",");
                }
            }
            query.append(")))='TRUE'");
            System.out.println(query.toString());
            queryExecuted.setText(query.toString());
            queryExecuted.setText(queryExecuted.getText()+";  "+query.toString());
            rs = getConnectionAndData(query.toString());
                        int xhyd=0;
                        int yhyd=0;
                        st = null;
                        j_geom = null;
                        outerOrdinates = null;
                        while(rs.next()){
                            st = (oracle.sql.STRUCT) rs.getObject("shape");
                            j_geom= JGeometry.load(st);
                            outerOrdinates = j_geom.getPoint();
                            System.out.println(outerOrdinates[0]);
                            outerOrdinates = j_geom.getPoint();
                            xhyd = (int)outerOrdinates[0];
                            yhyd = (int)outerOrdinates[1];
                            gr.setColor(Color.green);
                            gr.fillRect(xhyd, yhyd, 10, 10);
                        }

                clickedPoints.clear();
        }     
        } catch (SQLException ex) {
            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void findClosestFireHydrants(double x, double y){
        Graphics g = map.getGraphics();
        Graphics hydrants = map.getGraphics();
        ResultSet rs,tempRS = null;
        JGeometry j_geom = null; 
        Object[] elements = null;
        STRUCT st = null;
        double[] outerOrdinates = null;
        int[] xtempArray=null;
        int[] ytempArray=null;
        int tempXCount = 0;
        int tempYCount = 0;
        int xhyd=0;
        int yhyd=0;
        String tempText = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM BUILDINGS c WHERE SDO_RELATE(c.shape,SDO_GEOMETRY(2001, NULL,SDO_POINT_TYPE(");
        query.append(x+","+y);
        query.append(",NULL),NULL,NULL),'mask=anyinteract') = 'TRUE'");
        System.out.println(query.toString());
        queryExecuted.setText(query.toString());
        rs = getConnectionAndData(query.toString());
        
        try {
            while(rs.next()){
                System.out.println(rs.getString("name"));
                st = (oracle.sql.STRUCT) rs.getObject("shape");
                    j_geom= JGeometry.load(st);
                    outerOrdinates = j_geom.getOrdinatesArray();
                    tempXCount = 0;
                    tempYCount = 0;
                    g.setColor(Color.red);
                    xtempArray = new int[outerOrdinates.length/2];
                    ytempArray = new int[outerOrdinates.length/2];
                    for(int i=0;i<outerOrdinates.length;i++){
                        if(i%2==0){
                            xtempArray[tempXCount] = (int)outerOrdinates[i];
                            tempXCount = tempXCount+1;
                        }else{
                            
                            ytempArray[tempYCount] = (int)outerOrdinates[i];
                            tempYCount = tempYCount+1;
                        }
                        
                        
                    } 
                    query.delete(0, query.length());
                    query.append("SELECT * FROM HYDRANTS B WHERE SDO_WITHIN_DISTANCE(B.shape,");
                    query.append("SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(");
                    for(int i=0;i<j_geom.getOrdinatesArray().length;i++){
                    query.append(j_geom.getOrdinatesArray()[i]);
                    if(i<j_geom.getOrdinatesArray().length-1){
                        query.append(",");
                    }
                   }
                   query.append(")),'distance=50') = 'TRUE'");
                   tempRS=getConnectionAndData(query.toString());
                   
                    st = null;
                    j_geom = null;
                    outerOrdinates = null;
                    while(tempRS.next()){
                        st = (oracle.sql.STRUCT) tempRS.getObject("shape");
                        j_geom= JGeometry.load(st);
                        outerOrdinates = j_geom.getPoint();
                        System.out.println(outerOrdinates[0]);
                        outerOrdinates = j_geom.getPoint();
                        xhyd = (int)outerOrdinates[0];
                        yhyd = (int)outerOrdinates[1];
                        hydrants.setColor(Color.green);
                        hydrants.fillRect(xhyd, yhyd, 10, 10);
                    }
                    
                    System.out.println(query);
                    
                    g.drawPolygon(xtempArray, ytempArray, xtempArray.length);
            }
            queryExecuted.setText(queryExecuted+", "+query.toString());
        } catch (SQLException ex) {
            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox buildings;
    private javax.swing.JCheckBox buildingsOnFire;
    private javax.swing.JButton clearQuery;
    private javax.swing.JRadioButton closestFireHydrants;
    private javax.swing.JLabel currentCoordinates;
    private javax.swing.JCheckBox hydrants;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel map;
    private javax.swing.JRadioButton neighbourBuildings;
    private javax.swing.JTextPane queryExecuted;
    private javax.swing.ButtonGroup queryGroup;
    private javax.swing.JRadioButton rangeQuery;
    private javax.swing.JButton submitQuery;
    private javax.swing.JRadioButton wholeRegion;
    // End of variables declaration//GEN-END:variables
}
