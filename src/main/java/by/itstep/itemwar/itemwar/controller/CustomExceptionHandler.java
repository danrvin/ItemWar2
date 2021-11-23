package by.itstep.itemwar.itemwar.controller;

import by.itstep.itemwar.itemwar.service.exceptions.NotEnoughMoneyException;
import by.itstep.itemwar.itemwar.service.exceptions.NotFoundInventoryException;
import by.itstep.itemwar.itemwar.service.exceptions.NotFoundItemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundInventoryException.class)
    public ModelAndView handleInventoryNotFoundException(NotFoundInventoryException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("InventoryErrors");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ModelAndView handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("InventoryErrors");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(NotFoundItemException.class)
    public ModelAndView handleItemNotFoundException(NotFoundItemException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ItemError");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
