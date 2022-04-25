package com.furama.controller.contract_detail;

import com.furama.models.contract.Contract;
import com.furama.models.contract_detail.AttachService;
import com.furama.models.contract_detail.ContractDetail;
import com.furama.services.contract.IContractService;
import com.furama.services.contract_detail.IAttachServiceService;
import com.furama.services.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private IContractService iContractService;

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices() {
        return iAttachServiceService.findAll();
    }

    @ModelAttribute("contracts")
    public Iterable<Contract> contracts() {
        return iContractService.findAll();
    }


    @GetMapping("")
    public ModelAndView showList(Pageable pageable){
        Page<ContractDetail> contractDetailPage = iContractDetailService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract_detail/list");
        modelAndView.addObject("contractDetailPage", contractDetailPage);
        return modelAndView;
    }
}
