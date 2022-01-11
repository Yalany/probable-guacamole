package com.yalany.regionstest.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Region {
  private Integer id;
  private String name;
  private String shortName;
}
