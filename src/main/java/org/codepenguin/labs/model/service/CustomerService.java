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

package org.codepenguin.labs.model.service;

import org.codepenguin.labs.model.entity.Customer;
import org.codepenguin.labs.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Business service for {@link Customer}.
 *
 * @author Jorge Garcia
 * @version 0.0.1-SNAPSHOT
 * @since 17
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable<Customer> save(final Iterable<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    public Optional<Customer> find(final Long id) {
        return customerRepository.findById(id);
    }

    public boolean exists(Long id) {
        return customerRepository.existsById(id);
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Iterable<Customer> findAll(Iterable<Long> ids) {
        return customerRepository.findAllById(ids);
    }

    public long count() {
        return customerRepository.count();
    }

    public Optional<Customer> delete(final Long id) {
        final var customer = find(id);
        if (customer.isEmpty()) {
            return Optional.empty();
        }

        customerRepository.deleteById(id);
        return customer;
    }

    public void delete(final Customer customer) {
        customerRepository.delete(customer);
    }

    public void delete(final Iterable<Long> ids) {
        customerRepository.deleteAllById(ids);
    }

    public void deleteAll(final Iterable<Customer> customers) {
        customerRepository.deleteAll(customers);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
