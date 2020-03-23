package org.mega.imp.customer;

import org.apache.poi.ss.usermodel.Row;
import org.mega.imp.Reader;

public class CustomerReader extends Reader<CustomerTempDTO> {
    private static volatile CustomerReader reader;
    private static final Object lock = new Object();

    private CustomerReader() {
    }

    public static CustomerReader getInstance() {
        if (reader == null)
            synchronized (lock) {
                if (reader == null) {
                    reader = new CustomerReader();
                }
            }
        return reader;
    }

    @Override
    public CustomerTempDTO toPOJO(String[] strings) {
        CustomerTempDTO customerIMP = new CustomerTempDTO();
        try {
            customerIMP.setCustomerId(strings[10]);
            customerIMP.setShippingAddress(strings[9]);
            customerIMP.setCurrency(strings[8]);
            customerIMP.setTotalSpent(Float.parseFloat(strings[7]));
            customerIMP.setSubSource(strings[6]);
            customerIMP.setSource(strings[5]);
            customerIMP.setBuyerPhoneNumber(strings[4]);
            customerIMP.setPostCode(strings[3]);
            customerIMP.setEmailAddress(strings[2]);
            customerIMP.setFullName(strings[1]);
            customerIMP.setCompany(strings[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customerIMP;
    }

    @Override
    protected CustomerTempDTO toPOJO(Row row) {
        CustomerTempDTO customerIMP = new CustomerTempDTO();
        try {
            customerIMP.setCustomerId((String) getCellValue(row.getCell(10)));
            customerIMP.setShippingAddress((String) getCellValue(row.getCell(9)));
            customerIMP.setCurrency((String) getCellValue(row.getCell(8)));
            customerIMP.setTotalSpent(Float.parseFloat((String) getCellValue(row.getCell(7))));
            customerIMP.setSubSource((String) getCellValue(row.getCell(6)));
            customerIMP.setSource((String) getCellValue(row.getCell(5)));
            customerIMP.setBuyerPhoneNumber((String) getCellValue(row.getCell(4)));
            customerIMP.setPostCode((String) getCellValue(row.getCell(3)));
            customerIMP.setEmailAddress((String) getCellValue(row.getCell(2)));
            customerIMP.setFullName((String) getCellValue(row.getCell(1)));
            customerIMP.setCompany((String) getCellValue(row.getCell(0)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customerIMP;
    }
}