package ar.com.miura.lc.array.website;

public class WebsiteUserPattern {
    public java.util.List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        java.util.Map<String, java.util.List<Pair>> userInfo = new java.util.HashMap<String, java.util.List<Pair>>();

        int size = username.length;

        for(int i=0;i<size;i++) {

            String aUsername = username[i];
            Integer aTimestamp = timestamp[i];
            String aWebsite = website[i];

            Pair pair = new Pair(aTimestamp, aWebsite);

            userInfo.putIfAbsent(aUsername, new java.util.ArrayList<Pair>());
            userInfo.get(aUsername).add(pair);

        }

        java.util.Map<String, Integer> count = new java.util.HashMap<String, Integer>();

        String largest = "";
        Integer largestSize = Integer.MIN_VALUE;

        for(java.util.Map.Entry<String, java.util.List<Pair>> entry:userInfo.entrySet()) {

            java.util.List<Pair> websites = entry.getValue();
            size = websites.size();

            java.util.Collections.sort(websites, (a, b) -> (a.time - b.time));

            java.util.Set<String> set = new java.util.HashSet<String>();

            for(int i=0;i<size;i++) {
                for(int j=i+1;j<size;j++) {
                    for(int k=j+1;k<size;k++) {

                        String key = websites.get(i).web + " " + websites.get(j).web + " " + websites.get(k).web;

                        if (!set.contains(key)) {
                            count.put(key, count.getOrDefault(key, 0) + 1);
                        }

                        Integer currentCount = count.getOrDefault(key, 0);

                        if (largest.equals("") || count.get(largest) < count.get(key) || (count.get(largest) == count.get(key) && largest.compareTo(key) > 0)) {
                            // make sure the right lexi order
                            largest = key;
                        }

                    }
                }
            }
        }
        String[] r = largest.split(" ");
        java.util.List<String> result = new java.util.ArrayList<>();
        for (String str : r) {
            result.add(str);
        }
        return result;

    }
}
