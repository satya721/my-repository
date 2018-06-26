package com.ms.avalon.master.dao.rdbms;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ms.avalon.master.dao.EmpDao1;
import com.ms.avalon.master.pojos.CourseMasterPojos;
import com.ms.avalon.master.pojos.DocumentMasterPojos;
import com.ms.avalon.master.pojos.DomainPojos;
import com.ms.avalon.master.pojos.EmpLoginPojos;
import com.ms.avalon.master.pojos.EmpPojos;
import com.ms.avalon.master.pojos.EnquiryMasterPojos;
import com.ms.avalon.master.pojos.FreshEnquiryPojos;
import com.ms.avalon.master.pojos.ReferMasterPojos;
import com.ms.avalon.master.pojos.StdRegMasterPojos;
import com.ms.avalon.master.pojos.WebMasterPojos;

public class EmpDaoRdbms1 extends DBConnectionDao implements EmpDao1
{

	@Override
	public boolean check(String empCode,int empPin)
	{	
		DetachedCriteria cre1=DetachedCriteria.forClass(EmpLoginPojos.class);
		cre1.add(Restrictions.eq("pin",empPin));
		cre1.add(Restrictions.eq("empCode",empCode));
		List<EmpLoginPojos> li1=hibernateTemplate.findByCriteria(cre1);
		if(li1.size()==0)
		{
			
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public List<EmpPojos> getEmployeesData()
	{
		DetachedCriteria cre=DetachedCriteria.forClass(EmpPojos.class);
		List<EmpPojos> li=hibernateTemplate.findByCriteria(cre);
	return li;
}

	@Override
	public EmpPojos getEmploysData(Integer EmpId)
	
	{
		
		return hibernateTemplate.get(EmpPojos.class,EmpId);
	}
	
	@Override
	public List<EmpPojos> getSearch(String serkey)
	{
		 DetachedCriteria cre= DetachedCriteria.forClass(EmpPojos.class);
	Disjunction d=Restrictions.disjunction();	
		
	if(StringUtils.isNumeric(serkey))
		  {
				if(serkey.length()>=5)
			{
			d.add(Restrictions.like("mobile",serkey,MatchMode.START));
			d.add(Restrictions.like("altMobile",serkey,MatchMode.START));
			}
				else
				{
					int  ser=Integer.parseInt(serkey);
					d.add(Restrictions.like("empId",ser));
					d.add(Restrictions.like("departId",ser));
					d.add(Restrictions.like("managerId",ser));
		         	d.add(Restrictions.like("locationId",ser));
				}
		}
		else
		{
			d.add(Restrictions.like("fName",serkey, MatchMode.START));
			d.add(Restrictions.like("lName",serkey, MatchMode.START));
			d.add(Restrictions.like("pAddress",serkey,MatchMode.ANYWHERE));
			d.add(Restrictions.like("email",serkey,MatchMode.START));
			d.add(Restrictions.like("cAddress",serkey,MatchMode.ANYWHERE));
			d.add(Restrictions.like("empPin",serkey,MatchMode.START));
			d.add(Restrictions.like("designation",serkey, MatchMode.START));
			d.add(Restrictions.like("empCode",serkey,MatchMode.START));
			
		}
		   cre.add(d);
            return hibernateTemplate.findByCriteria(cre);
	}

	@Override
	public boolean setDetaildao(EmpPojos emppojos)
	{
		
		   hibernateTemplate.save(emppojos);
           return true;
	}

	@Override
	public boolean setUpdateDao(EmpPojos emppojos)
	{
		 hibernateTemplate.update(emppojos);

	return true;
	}

	@Override
	public List<DomainPojos> getDomainData() 
	{
		
		DetachedCriteria cre=DetachedCriteria.forClass(DomainPojos.class);
		List<DomainPojos> di=hibernateTemplate.findByCriteria(cre);
	
		return di;	
	
	}

	@Override
	public List<CourseMasterPojos> getCourse(Integer id)
	
	{
		
		DetachedCriteria cre1=DetachedCriteria.forClass(CourseMasterPojos.class);
		cre1.add(Restrictions.eq("domainId",id));		
		
		
		return hibernateTemplate.findByCriteria(cre1);
	}
	@Override
	public List<Integer> getManagerData() 
	{
		DetachedCriteria cre=DetachedCriteria.forClass(EmpPojos.class);
		ProjectionList pl= Projections.projectionList();
		pl.add(Projections.distinct(Projections.property("managerId")));
		cre.setProjection(pl);
		return hibernateTemplate.findByCriteria(cre);
	}

	@Override
	public List<String> searchEmployeeByDate(String from, String to)
	{
		System.out.println("rdbms");
		System.out.println(from+" "+to);
		DetachedCriteria cre=DetachedCriteria.forClass(EmpPojos.class);
		cre.add(Restrictions.ge("createdDate", from));
		cre.add(Restrictions.le("createdDate", to));
		ProjectionList pl= Projections.projectionList();
		pl.add(Projections.distinct(Projections.property("fName")));
		cre.setProjection(pl);
		return hibernateTemplate.findByCriteria(cre);
	}

	@Override
	public List<String> getEmployeeByTable(String tabnam, String sernam)
	{
		System.out.println(tabnam+" "+sernam);
		ProjectionList pl= Projections.projectionList();
		ProjectionList pl1= Projections.projectionList();
		ProjectionList pl2= Projections.projectionList();
		ProjectionList pl3= Projections.projectionList();
		Disjunction d=Restrictions.disjunction();
		Disjunction d1=Restrictions.disjunction();
		Disjunction d2=Restrictions.disjunction();
		Disjunction d3=Restrictions.disjunction();
		List<String> li= new ArrayList<String>(); 
		DetachedCriteria cre,cre1,cre2,cre3;
		
		switch(tabnam)
		{
		
		case "all":
			
		case "enquiry":
			
			cre=DetachedCriteria.forClass(EnquiryMasterPojos.class);
		    d.add(Restrictions.like("enqName",sernam, MatchMode.START));
		    cre.add(d);
			pl.add(Projections.distinct(Projections.property("enqName")));
			cre.setProjection(pl);
			li.addAll(hibernateTemplate.findByCriteria(cre));
			if(tabnam.equals("enquiry"))
			{
				
				break;
			}
		
		case "refer":
			
			cre1=DetachedCriteria.forClass(ReferMasterPojos.class);
			 d1.add(Restrictions.like("refName",sernam, MatchMode.START));
			 cre1.add(d1);
			 pl1.add(Projections.distinct(Projections.property("refName")));
			cre1.setProjection(pl1);
			li.addAll(hibernateTemplate.findByCriteria(cre1));
			
			if(tabnam.equals("refer"))
				break;
		case "web":
			 cre2=DetachedCriteria.forClass(WebMasterPojos.class);
			 d2.add(Restrictions.like("webName",sernam, MatchMode.START));
			 cre2.add(d2);
			 pl2.add(Projections.distinct(Projections.property("webName")));
				cre2.setProjection(pl2);
				li.addAll(hibernateTemplate.findByCriteria(cre2));
				
				if(tabnam.equals("web"))
					break;
	 	
		case "student":
			 
			cre3=DetachedCriteria.forClass(StdRegMasterPojos.class);
			d3.add(Restrictions.like("stdRegName",sernam, MatchMode.START));
			 cre3.add(d3);
			pl3.add(Projections.distinct(Projections.property("stdRegName")));
			cre3.setProjection(pl3);
			li.addAll(hibernateTemplate.findByCriteria(cre3));
		}
		
		System.out.println(li.size());
		
		return li;
	}

	
	@Override
	public boolean setDetaildaoExcel(List<FreshEnquiryPojos> li)
	{
	if(li!=null&&li.size()>0)
	for(FreshEnquiryPojos fs :li)
	{
	   hibernateTemplate.save(fs);
	}

	return true;
	
	}
	

	@Override
	public boolean uploadImage(List<DocumentMasterPojos> li) 
	{
		if(li!=null&&li.size()>0)
			for(DocumentMasterPojos fs :li)
			{
			   hibernateTemplate.save(fs);
			}
		return true;
	}
	@Override
	public List<DomainPojos> getDomainname()
	{
		DetachedCriteria cre=DetachedCriteria.forClass(DomainPojos.class);
		
		return null;
	}

	

}
