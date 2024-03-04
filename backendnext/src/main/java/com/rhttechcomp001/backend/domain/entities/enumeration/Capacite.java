package com.rhttechcomp001.backend.domain.entities.enumeration;

public enum Capacite {
  C140(140), C180(180), C200(200), C250(250), C300(300),
  C320(320), C360(360), C380(380), C450(450), C460(460);

  private final Integer value;

  Capacite(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}