
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i]=new ArrayList<>();
        }

        int[] indegree = new int[numCourses];

        for(var p : prerequisites){
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> available = new LinkedList<Integer>();
        while(!q.isEmpty()){
            int cur = q.poll();
            available.add(cur);

            for(var it : adj[cur]){
                if(--indegree[it]==0){
                    q.offer(it);
                }
            }
        }

        return available.size()==numCourses;
    }
}
