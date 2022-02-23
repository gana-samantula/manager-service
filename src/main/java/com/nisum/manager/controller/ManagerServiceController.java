package com.nisum.manager.controller;

import com.nisum.manager.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nisum.manager.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManagerServiceController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.findAllManagers();
    }

    @PostMapping("/managers")
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.addManager(manager);
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> getEmployeeById(@PathVariable(value = "id") Long managerId) {
        Manager manager = managerService.getManagerById(managerId).get();
        return ResponseEntity.ok().body(manager);
    }

    @DeleteMapping("/managers/{id}")
    public void deleteManager(@PathVariable(value = "id") Long managerId){
        managerService.deleteEmployee(managerId);

    }

    @PutMapping ("/managers/{id}")
    public Manager updateManager(@PathVariable(value = "id") Long employeeId,@RequestBody Manager manager) {
        return managerService.updateManager(employeeId, manager);
    }

}
