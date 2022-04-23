package com.furama.controller.employee;

import com.furama.dto.customer.CustomerDto;
import com.furama.dto.employee.EmployeeDto;
import com.furama.models.customer.Customer;
import com.furama.models.customer.CustomerType;
import com.furama.models.employee.Division;
import com.furama.models.employee.EducationDegree;
import com.furama.models.employee.Employee;
import com.furama.models.employee.Position;
import com.furama.services.employee.IDivisionService;
import com.furama.services.employee.IEducationDegreeService;
import com.furama.services.employee.IEmployeeService;
import com.furama.services.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationDegreeService iEducationDegreeService;
    @Autowired
    IDivisionService iDivisionService;

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return iPositionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees() {
        return iEducationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return iDivisionService.findAll();
    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> divisionNameSearch, Model model) {
        String divisionNameValue = divisionNameSearch.orElse("");

        Page<Employee> employeePage = iEmployeeService.findAllByDivision(divisionNameValue, pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("divisionNameValue", divisionNameValue);

        return "/employee/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Position> positionList = iPositionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = iDivisionService.findAll();

        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute EmployeeDto employeeDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<Division> divisionList = iDivisionService.findAll();
            List<Position> positionList = iPositionService.findAll();
            List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
            model.addAttribute("divisionList", divisionList);
            model.addAttribute("positionList", positionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            return "/employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Success Create Employee!!!");
        return "redirect:/employee";
    }
}
