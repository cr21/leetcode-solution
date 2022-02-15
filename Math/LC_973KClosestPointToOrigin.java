/*

BruteForce Solution
*/

class Solution {
    
    class Point implements Comparator<Point>{
        
        int x;
        int y;
        Integer distance;
        
        Point(){
            
        }
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = this.x * this.x  + this.y * this.y;
        }
        
        
        
        boolean equals(Point p) {
            return this.x == p.x && this.y == p.y;
        }
        
        public int compare(Point p1, Point p2) {
            if(p1.equals(p2)) {
                return 0;
            }
            return p1.distance.compareTo(p2.distance);   
        }
        
        public String toString() {
            return  "x : " + this.x + " y: "+this.y + " distance : "+this.distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<Point> points_li = new ArrayList();
        
        for(int [] point:points){
            points_li.add(new Point(point[0], point[1]));
        }
        
        Collections.sort(points_li, new Point());
        
        for(Point p:points_li){
            System.out.println(p.toString());
        }
        
        int[][] res = new int[k][2];
        for(int i =0;i< Math.min(k,  points_li.size());i++){
            res[i] = new int[] { points_li.get(i).x, points_li.get(i).y};
        } 
        
        return res;
    }
    
}
