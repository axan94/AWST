package ue2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TenLinesTest
{
  private final TenLines tenLines = new TenLines ();

  @Test
  public void testInputIsLife ()
  {
    assertEquals (tenLines.getResponse (43), "Answer of life or death");
  }

  @Test
  public void testInputIsEvenNumber ()
  {
    assertEquals (tenLines.getResponse (2), "even number");
  }

  @Test
  public void testInputIsUnevenNumber ()
  {
    assertEquals (tenLines.getResponse (3), "Failure");
  }

  @Test
  public void testInputIsNegativNumber ()
  {
    assertEquals (tenLines.getResponse (-2), "even number");
  }

  @Test
  public void testInputIsNegativSevenNumber ()
  {
    assertEquals (tenLines.getResponse (-7), "Failure");
  }

}
