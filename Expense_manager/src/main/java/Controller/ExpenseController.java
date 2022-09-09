package Controller;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpenseDao;
import daoImpl.ExpenseDaoImpl;
import pojo.ExpenseDetails;

public class ExpenseController extends HttpServlet {

		ExpenseDetails Expense = new ExpenseDetails();
        ExpenseDaoImpl ExpenseDaoImpl = new ExpenseDaoImpl();
        ExpenseDao edao;
       
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addExpense")!=null){
            String ename = request.getParameter("ename");
            int eprice = Integer.parseInt(request.getParameter("eprice"));
            String edate = request.getParameter("edate");
            String ecolor = request.getParameter("ecolor");
            String eurl = request.getParameter("eurl");
            String eremark = request.getParameter("eremark");
            Expense.setEname(ename);
            Expense.setEprice(eprice);
            Expense.setEcolor(ecolor);
            Expense.setEurl(eurl);
            Expense.setEremark(eremark);
            
            Date edate1 = null;
			try {
				edate1 = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

            Expense.setEdate(edate1);
            ExpenseDaoImpl.saveExpense(Expense);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
          
        if(request.getParameter("showInfo")!=null){
        	 int id1 = Integer.parseInt(request.getParameter("id"));
           ExpenseDetails expense = ExpenseDaoImpl.showOneExpense(id1);
           request.setAttribute("record", expense);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showExpense")!=null){
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateExpense")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String enameupdate = request.getParameter("enameupdate");
             int epriceupdate = Integer.parseInt(request.getParameter("epriceupdate"));
             String edate = request.getParameter("edateupdate");
             Date edateupdate = null;
 			try {
 				edateupdate = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
 			} catch (ParseException e) {
 				e.printStackTrace();
 			}
             String ecolorupdate = request.getParameter("ecolorupdate");
             String eurlupdate = request.getParameter("eurlupdate");
             String eremarkupdate = request.getParameter("eremarkupdate");
             ExpenseDaoImpl.updateExpense(id1, enameupdate, eremarkupdate, epriceupdate , edateupdate , ecolorupdate, eurlupdate);
             List<ExpenseDetails> ExpenseList = new ArrayList();
             ExpenseList = ExpenseDaoImpl.showAllExpenses();
             request.setAttribute("ExpenseList", ExpenseList);
             RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteExpense")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             Expense.setId(id2);
             ExpenseDaoImpl.deleteExpense(Expense);
             List<ExpenseDetails> ExpenseList = new ArrayList();
             ExpenseList = ExpenseDaoImpl.showAllExpenses();
             request.setAttribute("ExpenseList", ExpenseList);
             RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
         }
         
      
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
