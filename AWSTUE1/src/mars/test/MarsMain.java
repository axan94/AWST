package mars.test;

public class MarsMain
{

  /**
   * @param args
   */
  public String parseInterval (final String [] args)
  {
    // Requirement 1: If one interval is completely contained in the other,
    // the output shall be �NESTED�.
    // Requirement 2: If the intervals overlap without being nested, the
    // output shall be �OVERLAP�.
    // Requirement 3: If the intervals just have one point in common, the
    // output shall be �TOUCH�.
    // Requirement 4: If the intervals are completely disjoint, the output
    // shall be �DISJOINT�.
    // Requirement 5: Each interval is within one day, i.e. for each interval,
    // the start time must be <= the end time. 21 hrs 12 min to 4 hrs 15
    // min is therefore not a valid interval and must be rejected with an
    // error.
    // Requirement 6: Other numeric inputs must be rejected with an error,
    // too, if they are out of range (e.g. 26 hrs 12 min or 14 hrs -3 min).
    // Requirement 7: Nonnumeric input and empty input need not be
    // checked.

    for (final String arg : args)
    {
      if (arg.contains ("-"))
      {
        return "REJECTED";
      }
    }

    final int firstHours = Integer.parseInt (args[0]);
    final int firstMinutes = Integer.parseInt (args[1]);
    final int secondHours = Integer.parseInt (args[2]);
    final int secondMinutes = Integer.parseInt (args[3]);

    final int thirdHours = Integer.parseInt (args[4]);
    final int thirdMinutes = Integer.parseInt (args[5]);
    final int fourthHours = Integer.parseInt (args[6]);
    final int fourthMinutes = Integer.parseInt (args[7]);

    if (firstMinutes >= 100 || secondMinutes >= 100 || thirdMinutes >= 100 || fourthMinutes >= 100)
    {
      return "REJECTED";
    }

    if (firstHours >= 26 || secondHours >= 26 || thirdHours >= 26 || fourthHours >= 26)
    {
      return "REJECTED";
    }

    final int first = firstHours * 100 + firstMinutes;
    final int second = secondHours * 100 + secondMinutes;

    final int third = thirdHours * 100 + thirdMinutes;
    final int fourth = fourthHours * 100 + fourthMinutes;

    if (first > second || third > fourth)
    {
      return "REJECTED";
    }

    if (first <= third && second >= fourth)
    {
      return "NESTED";
    }

    if (first == fourth || second == third)
    {
      return "TOUCH";
    }

    if (first < third && second >= third || first < fourth && second > fourth)
    {
      return "OVERLAP";
    }

    return "DISJOINT";
  }

}
