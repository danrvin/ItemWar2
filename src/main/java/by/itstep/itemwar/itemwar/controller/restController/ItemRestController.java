package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/createItem")
    public Long createItem(@RequestBody Item item) {
        itemService.save(item);
        return item.getId();
    }
}
