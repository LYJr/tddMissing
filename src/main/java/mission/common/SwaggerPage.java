package mission.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel
public class SwaggerPage {

    @ApiModelProperty(value = "페이지 번호(0~N)")
    private int page;

    @ApiModelProperty(value = "페이지 크기", allowableValues = "range[0, 100]")
    private int size;

    @ApiModelProperty(value = "정렬(사용법 : 컬럼명<startTime, endTime, targetAmount, fundingAmount> + ASC & DESC)")
    private List<String> sort;
}
