package com.register_validate.controller;

import com.register_validate.dto.RegisterDto;
import com.register_validate.model.Register;
import com.register_validate.service.IRegisterService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    IRegisterService iRegisterService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Register> registers = iRegisterService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("registers", registers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("registerDto", new RegisterDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute RegisterDto registerDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
//        registerCreate.validate(registerCreate, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return "create";
        }

        Register register = new Register();
        BeanUtils.copyProperties(registerDto, register);
        this.iRegisterService.save(register);
        redirectAttributes.addFlashAttribute("message", "Sucess register!!!");
        return "redirect:/register";
    }
}
