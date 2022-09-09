package daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ExpenseDao;
import pojo.ExpenseDetails;

public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public void saveExpense(ExpenseDetails Expense) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Expense);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ExpenseDetails> showAllExpenses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
		List<ExpenseDetails> ExpenseList = session.createQuery("from ExpenseDetails").getResultList();
        session.close();
        return ExpenseList;
    }
    
    @Override
    public ExpenseDetails showOneExpense(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ExpenseDetails expense = session.get(ExpenseDetails.class, id);		
		session.close();
		return expense;
    }
    
    @Override
    public void updateExpense(int id, String ename, String eremark , int eprice , Date edate , String ecolor , String eurl) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ExpenseDetails expdetails = session.load(ExpenseDetails.class, id);
        expdetails.setEname(ename);
        expdetails.setEremark(eremark);
        expdetails.setEprice(eprice);
        expdetails.setEdate(edate);
        expdetails.setEcolor(ecolor);
        expdetails.setEurl(eurl);
        session.update(expdetails);
        transaction.commit();
        session.close();  
    }

    @Override
    public void deleteExpense(ExpenseDetails Expense) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Expense);
        transaction.commit();
        session.close();
    }
    
}
