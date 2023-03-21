package com.laptrinhjavaweb.service;

        import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
        import com.laptrinhjavaweb.dto.BuildingDTO;
        import com.laptrinhjavaweb.dto.SearchDTO;
        import com.laptrinhjavaweb.dto.UserDTO;
        import com.laptrinhjavaweb.response.BuildingSearchReponse;
        import javassist.NotFoundException;
        import org.springframework.data.domain.Pageable;

        import java.util.List;
        import java.util.Map;
        import java.util.Optional;

public interface IBuildingService {
    /* List<BuildingSearchReponse> getBuilding(Map<String, Object> requestParams, List<String> types, Pageable pageable);*/
    List<BuildingDTO> getBuilding(BuildingDTO buildingDTO,Pageable pageable);
     BuildingDTO save(BuildingDTO buildingDTO) throws NotFoundException;
     List<BuildingSearchReponse> findAll();
     BuildingDTO updateBuilding(Long id , BuildingDTO buildingDTO);
     /*void deleteBuilding(Long[] ids);*/
     void delete(List<Long> buildingIds) throws NotFoundException;
     BuildingDTO findBuildingById(Long id);
     Map<String, String> getDistricts();
     Map<String, String> getBuildingTypes();
     int getTotalItems(BuildingDTO buildingDTO);




}
