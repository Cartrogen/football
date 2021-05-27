package com.api.football.model.response.team.subtype;

import lombok.Data;

@Data
public class Shots {
    private String total;
    private String onTarget;
    private String offTarget;
}
