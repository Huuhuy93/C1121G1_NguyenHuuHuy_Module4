package com.furama.controller.contract;

import com.furama.dto.contract.ContractDto;
import com.furama.dto.employee.EmployeeDto;
import com.furama.models.contract.Contract;
import com.furama.models.customer.Customer;
import com.furama.models.employee.Division;
import com.furama.models.employee.EducationDegree;
import com.furama.models.employee.Employee;
import com.furama.models.employee.Position;
import com.furama.models.service.ServiceFurama;
import com.furama.services.contract.IContractService;
import com.furama.services.customer.ICustomerService;
import com.furama.services.employee.IEmployeeService;
import com.furama.services.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IServiceService iServiceService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return iCustomerService.findAll();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return iEmployeeService.findAll();
    }

    @ModelAttribute("serviceFuramas")
    public Iterable<ServiceFurama> serviceFuramas() {
        return iServiceService.findAll();
    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> customerNameSearch, Model model) {
        String customerNameValue = customerNameSearch.orElse("");

        Page<Contract> contractPage = iContractService.findAllByCustomer(customerNameValue, pageable);
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("customerNameValue", customerNameValue);

        return "/contract/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        List<Employee> employeeList = iEmployeeService.findAll();
        List<ServiceFurama> serviceFuramaList = iServiceService.findAll();

        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("serviceFuramaList", serviceFuramaList);
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute ContractDto contractDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<Customer> customerList = iCustomerService.findAll();
            List<Employee> employeeList = iEmployeeService.findAll();
            List<ServiceFurama> serviceFuramaList = iServiceService.findAll();

            model.addAttribute("customerList", customerList);
            model.addAttribute("employeeList", employeeList);
            model.addAttribute("serviceFuramaList", serviceFuramaList);
            return "/contract/create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.iContractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Success Create Contract!!!");
        return "redirect:/contract";
    }

//    @GetMapping(value = "customerUseService")
//    public ModelAndView customerUserService(@PageableDefault(value = 2) Pageable pageable){
//        ModelAndView modelAndView =new ModelAndView("/customer/customerUseService");
//        Page<Contract> contractPageList = iContractService.findAll(pageable);
//        modelAndView.addObject("contractPageList", contractPageList);
//        return modelAndView;
//    }
}
