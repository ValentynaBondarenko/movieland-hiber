package org.nomarchia.movieland.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.nomarchia.movieland.common.SortingOrder;
import org.nomarchia.movieland.common.SortingParameter;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortedMoviesRequest {
    private SortingParameter sortingParameter;
    private SortingOrder sortingOrder;
}
