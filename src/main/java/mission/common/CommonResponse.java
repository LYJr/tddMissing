package mission.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mission.domain.Project;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private Project project;

    private String message;

    private CommonState state;
}
