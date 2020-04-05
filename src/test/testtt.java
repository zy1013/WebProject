package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testtt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
            int app;
        }
        
        String url="jdbc:mysql://localhost:3306/finalDesign";    //JDBC的URL    
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root","zhouyuan");
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.print("成功连接到数据库！");
            System.out.print("成功连接到数据库！");
            System.out.println(" 实例化Statement对象...");
            String sql;
            sql = "SELECT * FROM alluser;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String name = rs.getString("uid");
                String ps = rs.getString("password");
    
                // 输出数据
                System.out.print("uid: " + name + "  pw:"+ps);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
	}

}
