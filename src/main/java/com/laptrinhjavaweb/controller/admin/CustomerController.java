package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.response.ResponseDTO;
import com.laptrinhjavaweb.response.StaffReponse;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageUtils messageUtil;
    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView getBuilding(@ModelAttribute(SystemConstant.MODEL) CustomerDTO model,
                                    HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        DisplayTagUtils.of(request, model);
        List<CustomerDTO> customers = customerService.getCustomer(model, PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(customers);
        model.setTotalItems(customerService.getTotalItems(model));
        mav.addObject("customers", customers);
        model.setStaffs(userService.getStaffMaps());
        mav.addObject(SystemConstant.MODEL, model);

        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView updateBuilding(@PathVariable("id") Long id) {

        ModelAndView mav = new ModelAndView("admin/customer/edit");
        if(id!=null) {
            CustomerDTO model = customerService.findCustomerById(id);
            mav.addObject(SystemConstant.MODEL, model);
        }
        return mav;
    }
    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView loadPageBuildingEdit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        return mav;
    }



}
