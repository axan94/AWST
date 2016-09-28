package ue2c;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CloseNotCloseTest
{

  private final CloseNotClose aCloseNotClose = new CloseNotClose ();

  @Test
  public void testClose ()
  {
    assertEquals (aCloseNotClose.write (5.5, 5.7), "CLOSE");
  }

  @Test
  public void testNotClose ()
  {
    assertEquals (aCloseNotClose.write (6.2, 2.9), "NOT CLOSE");
  }
}
