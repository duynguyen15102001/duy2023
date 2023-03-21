package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.response.BuildingSearchReponse;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {


    @Autowired
    private MessageUtils messageUtil;
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView getBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                    HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        DisplayTagUtils.of(request, model);


        List<BuildingDTO> buildings = buildingService.getBuilding(model, PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(buildings);
        model.setTotalItems(buildingService.getTotalItems(model));
        mav.addObject("buildings", buildings);
        mav.addObject("districtList", buildingService.getDistricts());
        mav.addObject("buildingTypeList", buildingService.getBuildingTypes());


        initMessageResponse(mav, request);
        model.setBuildinhDTOs(userService.getStaffMaps());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }


    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView loadPageBuildingEdit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("districtList", buildingService.getDistricts());
        mav.addObject("buildingTypeList", buildingService.getBuildingTypes());

        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    public ModelAndView updateBuilding(@PathVariable("id") Long id, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("admin/building/edit");
        if(id!=null) {
            BuildingDTO model = buildingService.findBuildingById(id);
            mav.addObject("districtList", buildingService.getDistricts());
            mav.addObject("buildingTypeList", buildingService.getBuildingTypes());
            initMessageResponse(mav, request);
            mav.addObject(SystemConstant.MODEL, model);
        }
        return mav;
    }


    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }

    }


}