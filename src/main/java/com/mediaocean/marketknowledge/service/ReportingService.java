package com.mediaocean.marketknowledge.service;

import java.util.List;

import com.mediaocean.marketknowledge.applicationexception.ApplicationException;
import com.mediaocean.marketknowledge.entity.Product;

public interface ReportingService {

	List<Product> retriveAllProductSalesEntries() throws ApplicationException;
}
