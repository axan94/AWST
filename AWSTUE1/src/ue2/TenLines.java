package ue2;

public class TenLines
{

  public String getResponse (final int input)
  {
    if (input % 2 == 0)
    {
      return "even number";
    }
    if (input == 43 || input == 7)
    {
      return "Answer of life or death";
    }
    return "Failure";
  }

}
