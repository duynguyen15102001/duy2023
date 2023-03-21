
package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.response.StaffReponse;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.RoleService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "usersControllerOfAdmin")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MessageUtils messageUtil;

    @RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
    public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/list");
        DisplayTagUtils.of(request, model);


        List<UserDTO> news = iUserService.getUsers(model.getSearchValue(),
                PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(news);
        model.setTotalItems(iUserService.getTotalItems(model.getSearchValue()));
        mav.addObject(SystemConstant.MODEL, model);
        initMessageResponse(mav, request);
        return mav;
    }


    @RequestMapping(value = "/admin/user-edit", method = RequestMethod.GET)
    public ModelAndView addUser(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        model.setRoleDTOs(roleService.getRoles());
        initMessageResponse(mav, request);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "admin/userassignment/{buildingid}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("buildingid") Long buildingId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
        buildingSearchInput.setId(buildingId);
        List<StaffReponse> model = userService.findAllManagementStaff(buildingSearchInput);
        initMessageResponse(mav, request);
        mav.addObject("listuser", model);
        return mav;
    }

    @RequestMapping(value = "/admin/profile-{username}", method = RequestMethod.GET)
    public ModelAndView updateProfile(@PathVariable("username") String username, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/profile");
        UserDTO model = iUserService.findOneByUserName(username);
        initMessageResponse(mav, request);
        model.setRoleDTOs(roleService.getRoles());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/user-edit-{id}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        UserDTO model = iUserService.findUserById(id);
        model.setRoleDTOs(roleService.getRoles());
        initMessageResponse(mav, request);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/profile-password", method = RequestMethod.GET)
    public ModelAndView updatePassword(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/password");
        UserDTO model = iUserService.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
        initMessageResponse(mav, request);
        mav.addObject(SystemConstant.MODEL, model);
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

