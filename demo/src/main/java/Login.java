
// import javax.servlet.*;
// import java.io.*;
// import java.sql.*;
// public class Login extends GenericServlet
// {
//     public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
//     {
//         res.setContentType("text/html");
//         PrintWriter out=res.getWriter();
//         out.println("<html>");
//         out.println("<head>");
//         out.println("<title>Login</title>");
//         out.println("<style>");
//         out.println("body{font-family: cursive;background-color: #795959}");
//         out.println("div{width: 400px;margin: 0px auto;box-shadow: 0px 1px 10px #a8a8a8;background-color: #fff;padding-bottom: 10px;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%)}");
//         out.println("h1{background-color: #5e267b;text-align: center;margin-top: 0;padding: 20px;color: #fff}");
//         out.println("input{display: block; margin:auto; font-size: 20px}");
//         out.println("p{text-align: center;font-size: 20px;color: #6a595b;margin;0}");
//         out.println("input{width: 70%;border: 1px solid #34cbd1;background-color: #fff;outline: none;border-radius: 5px;height:40px;padding: 10px}");
//         out.println("input[type='submit']:hover{background-color: #54b0bc;border: 0}");
//         out.println("input[type='submit']{background-color: #34cbd1;color: #fff;cursor: pointer};");
//         out.println("</style>");
//         out.println("</head>");
//         out.println("<body>");
//         out.println("<div>");

//         Connection con=null;
//         Statement stm=null;
//         ResultSet rs=null;
//         String email=req.getParameter("email");
//         String pass=req.getParameter("pass");
//         try
//         {
//             Class.forName("com.mysql.jdbc.Driver");
//             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
//             String query = "select * from student where email='"+email+"' and password='"+pass+"'";
//             stm= con.createStatement();
//             rs=stm.executeQuery(query);
//             if(rs.next()){
//                 out.println("<h1>Welcome</h1>");
//                 out.println("<p>Name - "+rs.getString("name")+"</p>");
//                 out.println("<p>Roll No - "+rs.getString("roll")+"</p>");
//                 out.println("<p>Email - "+rs.getString("email")+"</p>");
//                 out.println("<p>Course - "+rs.getString("course")+"</p>");
//             }
//             else
//                 out.println("<h1 style='background-color: #5e267b'>Invalid email or password !</h1>");
//         }
//         catch(ClassNotFoundException e){
//             out.println(e);
//         }
//         catch(SQLException e){
//             out.println(e);
//         }
//         finally
//         {
//             try
//             {
//                 rs.close();
//                 stm.close();
//                 con.close();
//             }
//             catch(SQLException e){
//             out.println(e);
//             }
//         }

//         out.println("<p><a href='login.html'>Back</a></p>");
//         out.println("</div>");
//         out.println("</body>");
//         out.println("</html>");
//     }
// }

import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Login extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("<style>");
        out.println("body {font-family: cursive;background-color: #795959}");
        out.println(
                "div{width: 500px;margin: 0px auto;padding-bottom: 10px;position: absolute;text-align: center;top: 50%;left: 50%;transform: translate(-50%, -50%)}");
        out.println("h1{text-align: center;margin-top: 0;color: #fff}");
        out.println(".center{margin-left: auto;margin-right: auto;}");
        out.println("input{display: block;margin: auto;font-size: 20px}");
        out.println("p{text-align: center;font-size: 20px;color: #6d0b17;}");
        out.println("table,th,td{border: 1px solid black;border-collapse: collapse;}");
        out.println("th,td{padding: 10px;}");
        out.println("th{color: #fff;background-color: #68283b;font-size: 20px;}");
        out.println("td{background-color: #FDDF95;}");
        out.println(".center{margin-left: auto;margin-right: auto;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            String query = "select * from student where email='" + email + "' and password='" + pass + "'";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                out.println("<table style=\"box-shadow: 0px 1px 10px #a8a8a8;\" class=\"center\">");
                out.println("<thead>");
                out.println("<tr><h1>Book Details</h1></tr>");
                out.println("<tr><th>ID</th><th>Tittle</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");
                out.println("</thead>");
                out.println("<tbody>");
                String t = "select * from book";
                rs1 = stm.executeQuery(t);
                while (rs1.next()) {
                    String n = rs1.getString("id");
                    String nm = rs1.getString("title");
                    String nm1 = rs1.getString("author");
                    int s = rs1.getInt("price");
                    int s1 = rs1.getInt("Quantity");
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + nm1 + "</td><td>" + s + "</td><td>"
                            + s1 + "</td></tr>");
                }
                out.println("</tbody>");
                out.println("</table>");

            } else
            {
                out.println("<h1 style='background-color: #5e267b'>Invalid email or password !</h1>");
                out.println("<p><a href='login.html' style=\"color: #151404;\">Back</a></p>");
            }
        } catch (ClassNotFoundException e) {
            out.println(e);
        } catch (SQLException e) {
            out.println(e);
        } finally {
            try {
                rs.close();
                rs1.close();
                stm.close();
                con.close();
            } catch (SQLException e) {
                out.println(e);
            }
        }

        out.println("<p><a href='login.html' style=\"color: #151404;\">Back</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}