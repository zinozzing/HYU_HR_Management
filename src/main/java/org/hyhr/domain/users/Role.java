package org.hyhr.domain.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    DEVELOPER("ROLE_DEVELOPER", "developer"),
    MANAGER("ROLE_MANAGER", "manager"),
    MEMBER("ROLE_MEMBER", "member");

    private final String key;
    private final String title;
}
