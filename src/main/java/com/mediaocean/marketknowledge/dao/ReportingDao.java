package com.mediaocean.marketknowledge.dao;

import java.util.List;

import com.mediaocean.marketknowledge.applicationexception.ApplicationException;
import com.mediaocean.marketknowledge.entity.Product;

public interface ReportingDao {

	List<Product> retriveAllProductSalesEntries() throws ApplicationException;
}
