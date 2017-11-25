package com.training.sample.sharing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangeHandler {
  public List<String> handle(String input) {
    if (input.length() < 2) {
      return Arrays.asList(input);
    }
    List<String> resultList = new ArrayList<String>();
    for (int i = 0; i < input.length(); i++) {
      for (String bcArrange : handle(getStringRemoveOneCharByIndex(input, i))) {
        resultList.add(input.charAt(i) + bcArrange);
      }
    }
    return resultList;
  }

  private String getStringRemoveOneCharByIndex(String input, int inputIndex) {
    return input.substring(0, inputIndex) + input.substring(inputIndex + 1);
  }
}
