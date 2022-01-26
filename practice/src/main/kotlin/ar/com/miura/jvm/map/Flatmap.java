package ar.com.miura.jvm.map;

public class Flatmap {

    static java.util.HashMap<String, String> flattenDictionary(java.util.HashMap<String, Object> dict) {
        java.util.HashMap<String, String> map = new java.util.HashMap<>();
        dfs("", dict, map);
        return map;
    }

    private static void dfs(String initialKey, java.util.HashMap<String, Object> dict , java.util.HashMap<String, String> newMap) {
        java.util.Set<String> keys = dict.keySet();
        for(String key:keys) {
            Object value = dict.get(key);
            if (value instanceof String || value instanceof Integer) {
                if (initialKey==null || initialKey.equals("")) {
                    newMap.put(key, value.toString());
                } else {
                    newMap.put(initialKey + "." + key, value.toString());
                }
            } else {
                if (initialKey==null || initialKey.equals("")) {
                    dfs(key, (java.util.HashMap<String, Object>) value, newMap);
                } else {
                    dfs(initialKey + "." + key, (java.util.HashMap<String, Object>) value,newMap);
                }
            }
        }
    }
}
