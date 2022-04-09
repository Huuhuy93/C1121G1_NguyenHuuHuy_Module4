package com.exercise_bank.controller;

import com.exercise_bank.dto.SavingDto;
import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import com.exercise_bank.service.ICustomerService;
import com.exercise_bank.service.ISavingService;
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
import java.util.Optional;

@Controller
@RequestMapping("/saving")
public class SavingController {
    @Autowired
    private ISavingService iSavingService;

    @Autowired
    private ICustomerService iCustomerService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return iCustomerService.findAll();
    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable,Optional<String> keywork, Model model) {
        String keyworkValue = keywork.orElse("");
        Page<Saving> savingList = iSavingService.findAllByNameCustomer(keyworkValue, pageable);
        model.addAttribute("savingList", savingList);
        model.addAttribute("keyworkValue", keyworkValue);
        return "/saving/home";
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/saving/create");
        modelAndView.addObject("savingDto", new SavingDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute SavingDto savingDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/saving/create";
        }

        Saving saving = new Saving();
        BeanUtils.copyProperties(savingDto, saving);
        this.iSavingService.save(saving);
        redirectAttributes.addFlashAttribute("message", "Success Create Saving!!!");
        return "redirect:/saving";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Saving saving = iSavingService.findById(id);
        SavingDto savingDto = new SavingDto();
        BeanUtils.copyProperties(saving, savingDto);

        model.addAttribute("savingDto", savingDto);
        return "/saving/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@Valid @ModelAttribute SavingDto savingDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/saving/edit";
        }

        Saving saving = new Saving();
        BeanUtils.copyProperties(savingDto, saving);
        this.iSavingService.save(saving);
        redirectAttributes.addFlashAttribute("message", "Success Update Saving!!!");
        return "redirect:/saving";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("savingDelete", iSavingService.findById(id));
        return "/saving/delete";
    }

    @PostMapping("/delete")
    public String deleteForm(@ModelAttribute Saving saving, RedirectAttributes redirect) {
        iSavingService.remove(saving.getId());
        redirect.addFlashAttribute("success", "Removed saving successfully!");
        return "redirect:/saving";
    }


}
