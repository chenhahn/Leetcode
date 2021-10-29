class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for(String cpdomain: cpdomains){
            String[] domainInfos = cpdomain.split("\\s+");
            String[] domainFrags = domainInfos[1].split("\\.");
            int count = Integer.valueOf(domainInfos[0]);
            String str = "";
            for(int i = domainFrags.length - 1; i >=0; i--){
                str = domainFrags[i] + (i == domainFrags.length - 1? "" : ".") + str;
                counts.put(str, counts.getOrDefault(str, 0) + count);
            }
        }
        
        List<String> result = new ArrayList<>();
        for(String domain: counts.keySet()){
            result.add(counts.get(domain) + " " + domain);
        }
        return result;
    }
}