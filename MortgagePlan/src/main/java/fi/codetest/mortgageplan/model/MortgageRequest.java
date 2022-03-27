package fi.codetest.mortgageplan.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MortgageRequest {
    @NotNull(message = "Mandatory")
    @JsonProperty(value="loan")
    private Double loan;
    @NotNull(message = "Mandatory")
    @JsonProperty(value="rate")
    private Double rate;
    @NotNull(message = "Mandatory")
    @JsonProperty(value="year")
    private Integer year;
}
