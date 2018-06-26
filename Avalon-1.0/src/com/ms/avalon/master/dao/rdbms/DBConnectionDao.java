package com.ms.avalon.master.dao.rdbms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBConnectionDao {
	
	protected Session session=null;
	protected DataSource dataSource;
	protected SessionFactory sessionFactory=null;
	protected HibernateTemplate hibernateTemplate=null;
	protected NamedParameterJdbcTemplate namedJdbcTemplate=null;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		namedJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		session = sessionFactory.getCurrentSession();
		hibernateTemplate=new HibernateTemplate(sessionFactory);
	}
	
}
