package com.boiler.config.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



public class Link {

  private String href;
  private String templated;
  private String method;
  private String model;

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getTemplated() {
    return templated;
  }

  public void setTemplated(String templated) {
    this.templated = templated;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @JsonInclude(Include.NON_NULL)
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }



}
