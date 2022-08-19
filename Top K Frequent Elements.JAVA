class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.t-a.t);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else
            {
                map.put(i,1);
            }            
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        int ans[] = new int[k];
        
        int i=0;
        
        for(i=0;i<k;i++)
        {
            ans[i] = pq.remove().v;
        }
        
        return ans;
        
    }
    
    class Pair
    {
        int v;
        int t;
        Pair(int v,int t)
        {
            this.v = v;
            this.t =  t;
        }
    }
}
