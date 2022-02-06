package additional.controllers;

import additional.exceptions.MyException;
import additional.persistence.dao.services.interfaces.CustomerSimpleService;
import additional.persistence.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private static final Log LOG = LogFactory.getLog(CustomerController.class);
    @Autowired
    private CustomerSimpleService customerSimpleService;


    @PostMapping(value = "/add")
    public String addNewCustomer(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getParameter("name"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setAge(Integer.parseInt(request.getParameter("age")));
        LOG.info("New customer with id " + customerSimpleService.addCustomer(customer).getId()
                + " was added.");

        return "redirect:/customer/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllCustomer(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("customers", customerSimpleService.findAll());
        modelAndView.setViewName("/customers");
        return modelAndView;
    }
    @GetMapping(value = "/get")
    public String getException() throws MyException {
        throw new MyException("Wrong way!");
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView deleteCustomer(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        customerSimpleService.removeById(id);
        modelAndView.addObject("customers", customerSimpleService.findAll());
        modelAndView.setViewName("redirect:/customer/all");

        return modelAndView;
    }

    @PostMapping(value = "/findByName")
    public ModelAndView findCustomerByName(@RequestParam("name") String name, ModelAndView modelAndView) {

        modelAndView.addObject("customers", customerSimpleService.findCustomerByFirstName(name));
        modelAndView.setViewName("/results");

        return modelAndView;
    }

    @PostMapping(value = "/deleteByName")
    public ModelAndView deleteCustomerByName(@RequestParam("name") String name, ModelAndView modelAndView) throws InterruptedException {
        customerSimpleService.deleteCustomerByFirstName(name);
        modelAndView.addObject("customers", customerSimpleService.findAll());
        modelAndView.setViewName("redirect:/customer/all");

        return modelAndView;
    }
    @PostMapping(value = "/update")
    public ModelAndView updateCustomer(@RequestParam("id") long id, @RequestParam("name") String name,
                                       @RequestParam("lastName") String lastName, @RequestParam("age") int age,
                                       ModelAndView modelAndView) throws InterruptedException {
        customerSimpleService.updateCustomer(id, name, lastName, age);
        modelAndView.addObject("customers", customerSimpleService.findAll());
        modelAndView.setViewName("redirect:/customer/all");

        return modelAndView;
    }

}
