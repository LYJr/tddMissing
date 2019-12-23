package mission.domain;

import lombok.Getter;

@Getter
public enum State {
    PREPARING,
    PROCEEDING,
    SUCCESS,
    FAILURE;
}
