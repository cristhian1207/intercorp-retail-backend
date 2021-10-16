package com.intercorpretail.customers.constants;

public class CustomerQueries {

	public static final String SQL_SUM_AGE = "SELECT SUM(f_year_diff(BIRTHDAY, CURRENT_DATE())) FROM CUSTOMERS";
	public static final String SQL_USP_STD = "CALL usp_std_customer_age()";

}
