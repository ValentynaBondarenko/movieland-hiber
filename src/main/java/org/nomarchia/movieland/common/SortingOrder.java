package org.nomarchia.movieland.common;

import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public enum SortingOrder {
    ASC("ASC"),
    DESC("DESC");

    private final String orderDirection;


    SortingOrder(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
