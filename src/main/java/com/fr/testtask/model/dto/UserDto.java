package com.fr.testtask.model.dto;

import com.fr.testtask.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    /**
     * {@link User#getId()}
     */
    private Long id;

    /**
     * {@link User#getUsername()}
     */
    private String username;

    /**
     * {@link User#isActive()}
     */
    private boolean active;
}
