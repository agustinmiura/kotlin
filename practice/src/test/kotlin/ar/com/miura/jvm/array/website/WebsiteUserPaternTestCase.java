package ar.com.miura.jvm.array.website;

public class WebsiteUserPaternTestCase {

    @org.junit.jupiter.api.Test
    public void shouldFindResult() {
        String[] user = new String[]{"dowg","dowg","dowg"};
        int[] timestamps = new int[]{158931262,562600350,148438945};
        String[] websites = new String[]{"y","loedo","y"};
    }

    @org.junit.jupiter.api.Test
    public void shouldFindResultCase2() {
        String[] user = new String[]{"ua","ua","ua","ub","ub","ub"};
        int[] timestamps = new int[]{1,2,3,4,5,6};
        String[] websites = new String[]{"a","b","c","a","b","a"};
        java.util.List<String> pattern = new ar.com.miura.lc.array.website.WebsiteUserPattern().mostVisitedPattern(user, timestamps, websites);
        System.out.println(" The answer is : " + pattern.toString());
        org.junit.jupiter.api.Assertions.assertTrue(pattern.size()==3);
    }


}
