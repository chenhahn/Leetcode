class Solution {
    boolean isDAG = true;
    Stack<Course> stack = new Stack<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][1]].add(courses[prerequisites[i][0]]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].getState() == 0) {
                dfs(courses[i]);
            }
        }
        
        int[] result;
        if (isDAG) {
            result = new int[numCourses];
            int i = 0;
            while(!stack.isEmpty()) {
                result[i] = stack.pop().getNumber();
                i++;
            }
        } else {
            result = new int[0];
        }
        
        return result;
    }
    
    private void dfs(Course c) {
        if (!isDAG) 
            return;
        c.changeState(1);
        for (Course course: c.getAdj()) {
            if (course.state == 0) {
                dfs(course);
            } else if (course.state == 1) {
                isDAG = false;
            }
        }
        c.changeState(2);
        stack.push(c);
    }
    
    class Course {
        private int state = 0; // 0->not visited; 1-> visited but not added; 2->added to stack
        private int number;
        private List<Course> adjacents = new ArrayList<>();
        public Course(int num) {
            number = num;
        }
        public void add(Course c) {
            adjacents.add(c);
        }
        public int getState() {
            return state;
        }
        public int getNumber() {
            return number;
        }
        public void changeState(int num) {
            state = num;
        }
        public List<Course> getAdj(){
            return adjacents;
        }
    }
}
/*	
	Time Complexity: O(V + E). Essentially we iterate through each node and each vertex in the graph once and only once.
	Space Complexity: O(V + E). Adjacency list takes O(E). We apply recursion in our algorithm, which in worst case will incur O(E)
 		extra space in the function call stack. Course Array and Stack take O(V).
*/