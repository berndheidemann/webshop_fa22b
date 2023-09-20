package de.szut.webshop_fa22b.supplier;

import de.szut.webshop_fa22b.contact.ContactEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public SupplierEntity createSupplier(@RequestBody AddSupplierDto dto) {
        // convert dto to entity
        var supplierEntity = new SupplierEntity();
        supplierEntity.setName(dto.getName());
        var contact= new ContactEntity();
        contact.setCity(dto.getCity());
        contact.setStreet(dto.getStreet());
        contact.setPostcode(dto.getPostcode());
        contact.setPhone(dto.getPhone());
        supplierEntity.setContact(contact);
        return supplierService.createSupplier(supplierEntity);
    }
}
