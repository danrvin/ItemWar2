package by.itstep.itemwar.itemwar.service;


import by.itstep.itemwar.itemwar.dao.repo.InventoryRepo;
import by.itstep.itemwar.itemwar.dao.repo.ItemRepo;
import by.itstep.itemwar.itemwar.dao.repo.UserRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @Mock
    private ItemRepo itemRepo;
    @Mock
    private InventoryRepo inventoryRepo;
    @Mock
    private UserRepo userRepo;

}
