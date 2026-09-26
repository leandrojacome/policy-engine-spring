package dev.leandrojacome.policy.domain;

import java.util.List;

public record Decision(boolean allowed, List<String> reasons) {
    public Decision { reasons = List.copyOf(reasons); }
}
