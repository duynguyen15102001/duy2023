package com.laptrinhjavaweb.repository.custom.impl;


import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    private String buildQueryFilter(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM customer c");
        sql.append(customerSqlCommonUsingBuilder(builder));
        sql.append(customerSqlWithJoinUsingBuilder(builder));
        return sql.toString();
    }

    private String customerSqlCommonUsingBuilder(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        try{

            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
            for(Field field : fields){

                field.setAccessible(true);
                String fieldName = field.getName();
                if (fieldName.equals("fullName")
                        || fieldName.equals("phone")
                        || fieldName.equals("email")) {
                    Object objectValue = field.get(builder);
                    if(objectValue != null && objectValue != ""){
                        if(field.getType().getName().equals("java.lang.String")){
                            sql.append(" and c." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                        }
                    }
                }
            }
        }catch (Exception e){

        }

        return sql.toString();
    }

    private String customerSqlWithJoinUsingBuilder(CustomerSearchBuilder builder) {

        StringBuilder sql = new StringBuilder("");
        try{

            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
            for(Field field : fields){

                field.setAccessible(true);

                String fieldName = field.getName();
                if (
                        fieldName.equals("staffId") ) {
                    Object objectValue = field.get(builder);
                    if(objectValue != null){
                        if(field.getType().getName().equals("java.lang.Long")){
                            if (fieldName.equals("staffId")) {

                                sql.append(" and c.id in (select ab.customerid from assignmentcustomer as ab where ab.customerid = c.id");
                                sql.append(" and ab.staffid = " + objectValue + "");
                                sql.append(" )");

                            }
                        }

                    }
                }
            }
        }catch (Exception e){

        }

        return sql.toString();
    }

    @Override
    public List<CustomerEntity> findCustomer(CustomerSearchBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder(buildQueryFilter(builder))
                .append(" Group by c.id").append(" LIMIT ").append(pageable.getPageSize()).append("\n")
                .append(" OFFSET ").append(pageable.getOffset()).append("\n");

        System.out.println("Final query: " + sql.toString());

        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItem(CustomerSearchBuilder builder) {
        String sql = buildQueryFilter(builder);
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }


}
