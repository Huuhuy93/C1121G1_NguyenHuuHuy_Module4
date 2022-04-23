package com.furama.controller.service;

import com.furama.dto.employee.EmployeeDto;
import com.furama.dto.service.ServiceDto;
import com.furama.models.customer.CustomerType;
import com.furama.models.employee.Division;
import com.furama.models.employee.EducationDegree;
import com.furama.models.employee.Employee;
import com.furama.models.employee.Position;
import com.furama.models.service.RentType;
import com.furama.models.service.ServiceFurama;
import com.furama.models.service.ServiceType;
import com.furama.services.service.IRentTypeService;
import com.furama.services.service.IServiceService;
import com.furama.services.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return iServiceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes() {
        return iRentTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> nameSearch, Model model) {
        String nameValue = nameSearch.orElse("");

        Page<ServiceFurama> serviceFuramaPage = iServiceService.findAllByServiceName(nameValue, pageable);
        model.addAttribute("serviceFuramaPage", serviceFuramaPage);
        model.addAttribute("nameValue", nameValue);

        return "/service/list";
    }


    @GetMapping("/create")
    public String createForm(Model model) {
        List<RentType> rentTypeList = iRentTypeService.findAll();
        List<ServiceType> serviceTypeList = iServiceTypeService.findAll();

        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute ServiceDto serviceDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<RentType> rentTypeList = iRentTypeService.findAll();
            List<ServiceType> serviceTypeList = iServiceTypeService.findAll();

            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("serviceTypeList", serviceTypeList);
            return "/service/create";
        }

        ServiceFurama serviceFurama = new ServiceFurama();
        BeanUtils.copyProperties(serviceDto, serviceFurama);
        this.iServiceService.save(serviceFurama);
        redirectAttributes.addFlashAttribute("success", "Success Create Service!!!");
        return "redirect:/service";
    }
}
