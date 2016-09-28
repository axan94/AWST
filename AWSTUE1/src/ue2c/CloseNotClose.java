package ue2c;

public class CloseNotClose
{
  public String write (final double a, final double b)
  {
    if ((a - b) < 1.0)
      return "CLOSE";
    return "NOT CLOSE";
  }
}
