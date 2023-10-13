import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDBMedlin;
import datamodel.Student;


@WebServlet("/StudentCostLookup")
public class StudentCostLookup extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public StudentCostLookup() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String student_id = request.getParameter("student_id");
      Student currentUser = UtilDBMedlin.getStudentByID(student_id);
      if (currentUser == null) {
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          String title = "Student ID Not Found";
          String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
          out.println(docType + //
                "<html>\n" + //
                "<head><title>" + title + "</title></head>\n" + //
                "<body bgcolor=\"#f0f0f0\">\n" + //
                "<h2 align=\"center\">" + title + "</h2>\n" + //
                "<ul>\n");
          out.println("<br><br><br>Student ID not found. Please check ID and search again or input student information.<br><br><br>");
          out.println("<a href=/project4830-T3-Medlin/simpleFormSearch.html>Lookup Again</a> <br>");
          out.println("<a href=/project4830-T3-Medlin/simpleFormInsert.html>Insert Student Information</a> <br>");
          out.println("</body></html>");
      } else {
    	  response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          String title = "Cost for Student " + currentUser.getStudent_id();
          String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
          out.println(docType + //
                "<html>\n" + //
                "<head><title>" + title + "</title></head>\n" + //
                "<body bgcolor=\"#f0f0f0\">\n" + //
                "<h2 align=\"center\">" + title + "</h2>\n" + //
                "<ul>\n" + //
                "  <li><b>Credit Hours</b>: " + currentUser.getCredit_hours() + "\n" + //
                "  <li><b>Your Total Cost</b>: $" + Integer.parseInt(currentUser.getCredit_hours()) * 586 + "\n" + //

                "</ul>\n");

          out.println("</body></html>");
      }   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}