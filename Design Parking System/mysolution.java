class ParkingSystem {

    int[] cap=new int[3];
    int[] num=new int[3];
    
    public ParkingSystem(int big, int medium, int small) {
        
        cap[0]=big;
        cap[1]=medium;
        cap[2]=small;
    }
    
    public boolean addCar(int carType) {
        
        if(num[carType-1]==cap[carType-1])
            return false;
        else
        {
            num[carType-1]++;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */