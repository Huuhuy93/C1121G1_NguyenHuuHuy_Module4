package com.retal_book.controller;

import com.retal_book.dto.BookDto;
import com.retal_book.model.Book;
import com.retal_book.service.IBookService;
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
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String listBook(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Book> bookList = iBookService.findAll(pageable);
        model.addAttribute("bookList", bookList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView createBookForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("bookDto", new BookDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBookForm(@Valid @ModelAttribute BookDto bookDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }

        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        this.iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Success Create Book!!!");
        return "redirect:/book";
    }
}
