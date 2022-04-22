package com.furama.controller.customer;

import com.furama.dto.customer.CustomerDto;
import com.furama.models.customer.Customer;
import com.furama.models.customer.CustomerType;
import com.furama.services.customer.ICustomerService;
import com.furama.services.customer.ICustomerTypeService;
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
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping("/home")
    public String homeFurama() {
        return "/home";
    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> customerCodeSearch,
                                                                        @RequestParam Optional<String> customerNameSearch,
                                                                        @RequestParam Optional<String> customerPhoneSearch,
                                                                        Model model) {
        String codeValue = customerCodeSearch.orElse("");
        String nameValue = customerNameSearch.orElse("");
        String phoneValue = customerPhoneSearch.orElse("");

        Page<Customer> customerList = iCustomerService.findAllByCodeAndNameAndPhoneContaining(codeValue, nameValue, phoneValue, pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("codeValue", codeValue);
        model.addAttribute("nameValue", nameValue);
        model.addAttribute("phoneValue", phoneValue);

        return "/customer/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute CustomerDto customerDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Success Create Customer!!!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        customerDto.setCustomerType(customer.getCustomerType());

        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerDto.setCustomerType(customer.getCustomerType());
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Success Update Customer!!!");
        return "redirect:/customer";
    }


    @PostMapping("/delete")
    public String deleteForm(@RequestParam("id")Integer id) {
        iCustomerService.remove(id);
        return "redirect:/customer";
    }
}
