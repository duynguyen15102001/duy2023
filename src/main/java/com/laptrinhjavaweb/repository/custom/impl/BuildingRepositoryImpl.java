package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
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
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> getBuilding(Map<String, Object> buildingSearchMapping, List<String> listRentType ){
        List<BuildingEntity> results = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select b.* from building b ");
        StringBuilder joinQuery = new StringBuilder();
        StringBuilder whereQuery = new StringBuilder();
        buildingQueryWithJoin(buildingSearchMapping,listRentType,joinQuery, whereQuery);
        buildingQueryWithoutJoin(buildingSearchMapping,whereQuery);

        sql.append(joinQuery).append(" where 1=1").append(whereQuery).append(" Group by b.id");

        //sql
        Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
        // tra du lieu ra
        return query.getResultList();
    }





    @Override
    public List<BuildingEntity> findBuilding(BuildingSearchBuilder builder,Pageable pageable) {
        StringBuilder sql = new StringBuilder(buildQueryFilter(builder))
                .append(" Group by b.id").append(" LIMIT ").append(pageable.getPageSize()).append("\n")
                .append(" OFFSET ").append(pageable.getOffset()).append("\n");

        System.out.println("Final query: " + sql.toString());

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItem(BuildingSearchBuilder builder) {
        String sql = buildQueryFilter(builder);
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }

    @Override
    public List<BuildingEntity> findBuildingByAssignUser(Long id) {
        StringBuilder sql = new StringBuilder("select b.* from building b join assignmentbuilding a on b.id = a.buildingid join user u on u.id = a.staffid where u.id ="+id+"");

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private String buildQueryFilter(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building b");
        sql.append(buildingSqlCommonUsingBuilder(builder));
        sql.append(buildingSqlWithJoinUsingBuilder(builder));
        return sql.toString();
    }

    private String buildingSqlCommonUsingBuilder(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        try{
            //lay cac field
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for(Field field : fields){
                //cap quyen
                field.setAccessible(true);
                //lay ten cua field
                String fieldName = field.getName();
                if (!fieldName.startsWith("rentarea")
                        && !fieldName.equals("staffid")
                        && !fieldName.startsWith("costrent") && !fieldName.startsWith("managerphone")) {
                    Object objectValue = field.get(builder);
                    if(objectValue != null && objectValue != ""){
                        if(field.getType().getName().equals("java.lang.String")){
                            sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                        }
                        else if(field.getType().getName().equals("java.lang.Integer")){

                            if (fieldName.equals("rentPriceFrom")) {
                                sql.append(" and b.rentprice >= " + objectValue);

                            }
                            if (fieldName.equals("rentPriceTo")) {
                                sql.append(" and b.rentprice  <= " + objectValue);
                            }
                        }

                    }
                }
            }
        }catch (Exception e){

        }

        return sql.toString();
    }
    private String buildingSqlWithJoinUsingBuilder(BuildingSearchBuilder builder){
        //lay cac field
        StringBuilder sql = new StringBuilder("");
        try{

            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for(Field field : fields){
                //cap quyen
                field.setAccessible(true);
                //lay ten cua field
                String fieldName = field.getName();
                if (fieldName.equals("areaRentFrom") || fieldName.equals("areaRentTo")
                        || fieldName.equals("staffId") ) {
                    Object objectValue = field.get(builder);
                    if(objectValue != null){
                        if(field.getType().getName().equals("java.lang.Long")){
                            if (fieldName.equals("staffId")) {

                                sql.append(" and b.id in (select ab.buildingid from assignmentbuilding as ab where ab.buildingid = b.id");
                                sql.append(" and ab.staffid = " + objectValue + "");
                                sql.append(" )");

                            }
                        }
                        else if(field.getType().getName().equals("java.lang.Integer")){
                            if (fieldName.equals("areaRentFrom") || fieldName.equals("areaRentTo")) {
                                sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid");
                                if (fieldName.equals("areaRentFrom")) {
                                    sql.append(" and ra.value >=" + objectValue);

                                }
                                if (fieldName.equals("areaRentTo")) {
                                    sql.append(" and ra.value <= " + objectValue);
                                }
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

    private void buildingQueryWithJoin(Map<String, Object> params, List<String> rentType, StringBuilder joinQuery,
                                       StringBuilder whereQuery) {
        Integer areaRentFrom = (Integer) params.getOrDefault("arearentfrom", null);
        Integer areaRentTo = (Integer) params.getOrDefault("arearentto", null);

        if (ValidateUtils.isValid(areaRentFrom) || ValidateUtils.isValid(areaRentTo)) {

            whereQuery.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid");
            if (ValidateUtils.isValid(areaRentFrom)) {
                whereQuery.append(" and ra.value >= " + areaRentFrom + "");
            }
            if (ValidateUtils.isValid(areaRentTo)) {
                whereQuery.append(" and ra.value <= " + areaRentTo + "");
            }

        }

        Long userId = (Long) params.getOrDefault("userid", null);
        if (ValidateUtils.isValid(userId)) {
            joinQuery.append(" inner join assignmentbuilding as ab on ab.buildingid = b.id");
            whereQuery.append(" and ab.staffid = " + userId + "");
        }

       /* String districtCode = (String) params.getOrDefault("district", null);
        if (ValidateUtils.isValid(districtCode)) {
            joinQuery.append(" inner join district as d on d.id = b.districtid");
            whereQuery.append(" and d.code = '" + districtCode + "'");
        }*/

        if (ValidateUtils.isValid(rentType)) {

           String result =String.join(",", rentType);
                    whereQuery.append(" and b.type ='"+result+"' ");


        }
    }

    private void buildingQueryWithoutJoin(Map<String, Object> params, StringBuilder whereQuery) {

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!entry.getKey().equals("districtcode") && !entry.getKey().startsWith("rentprice")
                    && !entry.getKey().startsWith("arearent")) {

                if (entry.getValue() instanceof String) {
                    if(entry.getKey().equals("types") || entry.getKey().equals("message")){
                        break;
                    }
                    else {
                        whereQuery.append(" and b." + entry.getKey() + " like '%" + entry.getValue() + "%'");
                    }
                }
                if (entry.getValue() instanceof Integer) {
                    whereQuery.append(" and b. " + entry.getKey() + " = " + entry.getValue());
                }
            }
        }

        Integer rentPriceFrom = (Integer) params.getOrDefault("rentpricefrom", null);
        Integer rentPriceTo = (Integer) params.getOrDefault("rentpriceto", null);

        if (ValidateUtils.isValid(rentPriceFrom) || ValidateUtils.isValid(rentPriceTo)) {

            if (ValidateUtils.isValid(rentPriceFrom)) {
                whereQuery.append(" and b.rentprice >= " + rentPriceFrom + "");
            }
            if (ValidateUtils.isValid(rentPriceTo)) {
                whereQuery.append(" and b.rentprice <= " + rentPriceTo + "");
            }
        }
    }

}
