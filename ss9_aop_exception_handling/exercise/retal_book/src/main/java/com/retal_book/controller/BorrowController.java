package com.retal_book.controller;

import com.retal_book.dto.BookDto;
import com.retal_book.dto.BorrowDto;
import com.retal_book.model.Book;
import com.retal_book.model.Borrow;
import com.retal_book.service.IBookService;
import com.retal_book.service.IBorrowService;
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
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService iBorrowService;

    @ModelAttribute("books")
    public Iterable<Book> books() {
        return iBookService.findAll();
    }

    @GetMapping("")
    public String listBorrow(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Borrow> borrowList = iBorrowService.findAll(pageable);
        model.addAttribute("borrowList", borrowList);
        return "list_borrow";
    }

    @GetMapping("/{id}/create-borrow")
    public ModelAndView createBorrowForm(@PathVariable Integer id) {
        Optional<Book> book = iBookService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/create_borrow");

        modelAndView.addObject("book", book.get());
        modelAndView.addObject("borrowDto", new BorrowDto());
        return modelAndView;
    }

    @PostMapping("/{id}/create-borrow")
    public String saveBorrowForm(@Valid @ModelAttribute BorrowDto borrowDto,
                               BindingResult bindingResult,@PathVariable Integer id ,RedirectAttributes redirectAttributes,
                               Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create_borrow";
        }

        Borrow borrow = new Borrow();
        borrow.setBook(iBookService.findById(id).get());
        BeanUtils.copyProperties(borrowDto, borrow);
//        this.iBorrowService.save(borrow);
        redirectAttributes.addFlashAttribute("message", "Success Create Borrow!!!");
        return "redirect:/book";
    }
}
