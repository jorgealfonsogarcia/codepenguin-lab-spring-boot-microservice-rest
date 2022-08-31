/*
 * codepenguin-lab-spring-boot-microservice-rest
 * Copyright (C) 2022  Jorge Garcia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.codepenguin.labs.controller;

import org.codepenguin.labs.controller.dto.CustomerDTO;
import org.codepenguin.labs.controller.mapper.CustomerMapper;
import org.codepenguin.labs.model.entity.Customer;
import org.codepenguin.labs.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

/**
 * REST controller for {@link Customer}.
 *
 * @author Jorge Garcia
 * @version 0.0.1-SNAPSHOT
 * @since 17
 */
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    /**
     * Constructor.
     *
     * @param customerService the customer business service.
     * @param customerMapper  the customer mapper.
     */
    @Autowired
    public CustomerRestController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    /**
     * Creates a customer.
     *
     * @param customer the customer DTO.
     * @return the response entity with the new customer DTO.
     */
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody final CustomerDTO customer) {
        return ResponseEntity.ok(customerMapper.mapToDto(customerService.save(customerMapper.mapToEntity(customer))));
    }

    /**
     * Updates a customer.
     *
     * @param customer the customer DTO.
     * @return the response entity with the updated DTO.
     */
    @PutMapping
    public ResponseEntity<CustomerDTO> update(@RequestBody final CustomerDTO customer) {
        return ResponseEntity.ok(customerMapper.mapToDto(customerService.save(customerMapper.mapToEntity(customer))));
    }

    /**
     * Finds a customer by its id.
     *
     * @param id the id.
     * @return the response entity with the found customer.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> find(@PathVariable final Long id) {
        final var customer = customerService.find(id);
        return customer.isEmpty() ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(customerMapper.mapToDto(customer.get()));
    }

    /**
     * Finds all the customers.
     *
     * @return the response entity with all the customers.
     */
    @GetMapping
    public ResponseEntity<Iterable<CustomerDTO>> findAll() {
        return ResponseEntity.ok(StreamSupport.stream(customerService.findAll().spliterator(), false)
                .map(customerMapper::mapToDto).toList());
    }

    /**
     * Deletes a customer by its id.
     *
     * @param id the id.
     * @return the response entity with the deleted customer.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteById(@PathVariable final Long id) {
        final var customer = customerService.delete(id);
        return customer.isEmpty() ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(customerMapper.mapToDto(customer.get()));
    }
}
