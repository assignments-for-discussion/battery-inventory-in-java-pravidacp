package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int n = presentCapacities.length();
    int[] a = new int[n];
    for(int i = 0; i < n; i++)
      {
        a[i] = 100 * (presentCapacities[i] / 120);//calculating state-of-health
      }
    //classifying battery by state-of-health
    for(int j = 0; j < n; j++){
    if( a[i] < 100 && a[i] > 80){
      healthy += 1;
    }
      else if(a[i] < 80 && a[i] > 62){
      exchange += 1;
      }
      else{
      failed += 1;
    }
      
    counts = failed;// The number of failed batteries
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println(" The number of failed batteries :" + counts);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
