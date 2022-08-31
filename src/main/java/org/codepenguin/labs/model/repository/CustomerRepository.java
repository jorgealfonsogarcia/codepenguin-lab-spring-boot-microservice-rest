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

package org.codepenguin.labs.model.repository;

import org.codepenguin.labs.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for {@link Customer}.
 *
 * @author Jorge Garcia
 * @version 0.0.1-SNAPSHOT
 * @since 17
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
