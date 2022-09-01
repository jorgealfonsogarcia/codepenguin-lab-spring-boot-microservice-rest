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

package org.codepenguin.labs.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * Customer DTO.
 *
 * @param id          the id.
 * @param email       the email.
 * @param firstName   the first name.
 * @param lastName    the last name.
 * @param address     the address.
 * @param phoneNumber the phone number.
 * @author Jorge Garcia
 * @version 0.0.1-SNAPSHOT
 * @since 17
 */
public record CustomerDTO(Long id,
                          @NotNull @Email String email,
                          @NotNull String firstName,
                          @NotNull String lastName,
                          @NotNull String address,
                          @NotNull String phoneNumber) implements Serializable {

    @Serial
    private static final long serialVersionUID = -1307055080625744037L;
}
