
/**
 * @file StudentInsert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDBMedlin;

@WebServlet("/StudentInsert")
public class StudentInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public StudentInsert() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String student_id = request.getParameter("student_id");
      String email = request.getParameter("email");
      String credit_hours = request.getParameter("credit_hours");

      
      UtilDBMedlin.createStudents(name, student_id, email, credit_hours);

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Input Successfully Saved";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h2 align=\"center\">" + title + "</h2>\n" + //
            "<ul>\n" + //

            "  <li><b>Name</b>: " + name + "\n" + //
            "  <li><b>Name</b>: " + student_id + "\n" + //
            "  <li><b>Email</b>: " + email + "\n" + //
            "  <li><b>Credit Hours</b>: " + credit_hours + "\n" + //

            "</ul>\n");
      out.println("<br><br><br>Thanks for entering you information! To see your total tuition cost, click on cost lookup<br><br><br>");
      out.println("<a href=/project4830-T3-Medlin/simpleFormSearch.html>Cost Lookup</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
