package com.mediaocean.marketknowledge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mediaocean.marketknowledge.applicationexception.ApplicationException;
import com.mediaocean.marketknowledge.dao.ReportingDao;
import com.mediaocean.marketknowledge.dao.impl.ReportingDaoImpl;
import com.mediaocean.marketknowledge.entity.Product;
import com.mediaocean.marketknowledge.service.ReportingService;

public class ReportingServiceImpl implements ReportingService{
	
	private static final Logger logger = LoggerFactory.getLogger(ReportingDaoImpl.class);
	
	private ReportingDao reportingDao;
	
	public void setReportingDao(ReportingDao reportingDao) {
		this.reportingDao = reportingDao;
	}

	@Override
	public List<Product> retriveAllProductSalesEntries() throws ApplicationException{
		logger.info(ReportingServiceImpl.class.getName());
		return reportingDao.retriveAllProductSalesEntries();
	}
	
	

}
