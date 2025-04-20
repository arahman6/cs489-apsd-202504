package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.RoleRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.RoleResponse;
import edu.miu.cs.cs489.adsdentalapp.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Roles", description = "Endpoints for managing user roles and permissions")
@RestController
@RequestMapping("/adsweb/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "Get all roles", description = "Returns a list of all roles.")
    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @Operation(summary = "Get role by ID", description = "Returns the details of the role identified by the provided ID.")
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new role", description = "Creates a new role with the provided details.")
    @PostMapping
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request) {
        return roleService.addRole(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update role by ID", description = "Updates the details of the role identified by the provided ID.")
    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable Long id, @RequestBody RoleRequest request) {
        return roleService.updateRole(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete role by ID", description = "Deletes the role identified by the provided ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}