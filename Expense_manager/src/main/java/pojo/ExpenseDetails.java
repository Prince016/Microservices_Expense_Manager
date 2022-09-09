package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ExpenseDetails implements Serializable {
    
    @Id @GeneratedValue
    int id;
    
    String ename;
    String eremark;
    int eprice;
    @Temporal(value=TemporalType.DATE)
    Date edate;
    String ecolor;
    String eurl;


	

	public String getEcolor() {
		return ecolor;
	}

	public void setEcolor(String ecolor) {
		this.ecolor = ecolor;
	}

	public String getEurl() {
		return eurl;
	}

	public void setEurl(String eurl) {
		this.eurl = eurl;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

	public String getEremark() {
		return eremark;
	}

	public void setEremark(String eremark) {
		this.eremark = eremark;
	}

	public int getEprice() {
		return eprice;
	}

	public void setEprice(int eprice) {
		this.eprice = eprice;
	}
	
  
    
    
    
}
