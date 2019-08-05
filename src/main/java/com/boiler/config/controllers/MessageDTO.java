package com.boiler.config.controllers;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class MessageDTO {

  private MessageType messagetype;
  private String message;
  private List<?> items;
  private Map<String, Link> links;
  private List<?> list;

  public MessageType getMessagetype() {
    return messagetype;
  }

  public void setMessagetype(MessageType messagetype) {
    this.messagetype = messagetype;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @JsonInclude(Include.NON_NULL)
  public List<?> getItems() {
    return items;
  }

  public void setItems(List<?> items) {
    this.items = items;
  }

  @JsonInclude(Include.NON_NULL)
  public Map<String, Link> getLinks() {
    return links;
  }

  public void setLinks(Map<String, Link> links) {
    this.links = links;
  }

  @JsonInclude(Include.NON_NULL)
  public List<?> getList() {
    return list;
  }


  public void setList(List<?> list) {
    this.list = list;
  }



}
