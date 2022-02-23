package com.nisum.manager.service;

import com.nisum.manager.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nisum.manager.repository.ManagerServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerServiceRepository managerServiceRepository;

    public List<Manager> findAllManagers() {
        return managerServiceRepository.findAll();
    }

    public Manager addManager(Manager employee) {
        return managerServiceRepository.save(employee);
    }

    public Optional<Manager> getManagerById(Long managerId) {
        return managerServiceRepository.findById(managerId);
    }

    public void deleteEmployee(Long managerId){
        Optional<Manager> manager = getManagerById(managerId);
        if(manager.isPresent()){
            managerServiceRepository.deleteById(managerId);
        }else{
            System.out.println("ManagerListService:deleteEmployee(): Manager is not available to be deleted:");
        }
    }

    public Manager updateManager(Long managerId, Manager updatedEmp){
        Optional<Manager> manager = getManagerById(managerId);

        if(manager.isPresent()){
            Manager updateManager = manager.get();
            updateManager.setFirstName(updatedEmp.getFirstName());
            updateManager.setLastName(updatedEmp.getLastName());
            updateManager.setEmailId(updatedEmp.getEmailId());
            return managerServiceRepository.save(updateManager);
        }else{
            System.out.println("ManagerService:updateManager() Manager is not available to update:");
        }
        return updatedEmp;
    }

}
