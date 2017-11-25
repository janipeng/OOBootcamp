package com.training.sample.sharing;

import com.training.sample.sharing.ArrangeHandler;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrangeTest {

  @Test
  public void should_return_a_when_given_a() throws Exception {

    ArrangeHandler arrange = new ArrangeHandler();
    List<String> handleResult = arrange.handle("a");
    Assert.assertEquals(Arrays.asList("a"), handleResult);
  }

  @Test
  public void should_return_ab_and_ba_when_given_ab() throws Exception {

    ArrangeHandler arrange = new ArrangeHandler();

    List<String> result = arrange.handle("ab");
    Assert.assertEquals(Arrays.asList("ab","ba"), result);
  }

  @Test
  public void should_return_list_size6_when_given_abc() throws Exception {
    ArrangeHandler arrange = new ArrangeHandler();

    List<String> result = arrange.handle("abc");
    Assert.assertEquals(Arrays.asList("abc","acb","bac","bca","cab","cba"), result);
  }

  @Test
  public void should_return_list_size24_when_given_abcd() throws Exception {
    ArrangeHandler arrange = new ArrangeHandler();

    List<String> result = arrange.handle("abcd");

    Assert.assertEquals(24, result.size());
  }
}
