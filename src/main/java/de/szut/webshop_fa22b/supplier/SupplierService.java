package de.szut.webshop_fa22b.supplier;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity getSupplier(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public SupplierEntity createSupplier(SupplierEntity supplierEntity) {
        return supplierRepository.save(supplierEntity);
    }

    public SupplierEntity updateSupplier(SupplierEntity supplierEntity) {
        var inDB= supplierRepository.findById(supplierEntity.getSid()).orElseThrow();
        inDB.setName(supplierEntity.getName());
        inDB.getContact().setCity(supplierEntity.getContact().getCity());
        inDB.getContact().setStreet(supplierEntity.getContact().getStreet());
        inDB.getContact().setPostcode(supplierEntity.getContact().getPostcode());
        inDB.getContact().setPhone(supplierEntity.getContact().getPhone());
        var updatedSupplier = supplierRepository.save(inDB);
        return updatedSupplier;
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Iterable<SupplierEntity> getSuppliers() {
        return supplierRepository.findAll();
    }
}
