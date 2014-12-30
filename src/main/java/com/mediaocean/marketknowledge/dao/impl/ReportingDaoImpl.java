package com.mediaocean.marketknowledge.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mediaocean.marketknowledge.applicationexception.ApplicationException;
import com.mediaocean.marketknowledge.dao.ReportingDao;
import com.mediaocean.marketknowledge.entity.Product;

public class ReportingDaoImpl implements ReportingDao{

	private static final Logger logger = LoggerFactory.getLogger(ReportingDaoImpl.class);
	
	@PersistenceContext
	private EntityManagerFactory entityManagerFactory;
	
	
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	private EntityManager em;

	@Override
	public List<Product> retriveAllProductSalesEntries() throws ApplicationException{

		try{
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select p from Product left join feth p.saleEntries");
			@SuppressWarnings("unchecked")
			List<Product> productList = query.getResultList();
			em.getTransaction().commit();
			return productList;
		}catch(Exception ex){
			logger.info(ex.getMessage());
			throw new ApplicationException(ex.getMessage());
		}finally{
			try{
				if(em!=null){
					em.close();
				}
			}catch(Exception ex){
				logger.info(ex.getMessage());
				throw new ApplicationException(ex.getMessage());
			}
			
		}
	}
	
	
}
