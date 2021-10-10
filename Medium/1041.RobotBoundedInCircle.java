class Solution {
    int dir = 0;
    int x = 0, y = 0;
    int dirX = 0, dirY = 1;
    
    public boolean isRobotBounded(String instructions) {
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                changeDirection('L');
                setDirXY(dir);
            }else if(instructions.charAt(i) == 'R'){
                changeDirection('R');
                setDirXY(dir);
            }else{
                x += dirX;
                y += dirY;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
    
    public void setDirXY(int dir){
        if(dir == 0){
            dirX = 0; 
            dirY = 1;
        }else if(dir == 1){
            dirX = 1; 
            dirY = 0;
        }else if(dir == 2){
            dirX = 0; 
            dirY = -1;
        }else{
            dirX = -1; 
            dirY = 0;
        }
    }
    
    public void changeDirection(char c){
        if(c == 'L'){
            if(dir == 0){
                dir = 3;
            }else{
                dir--; 
            }
        }
        
        if(c == 'R'){
            if(dir == 3){
                dir = 0;
            }else{
                dir++;
            }
        }
    }
}

