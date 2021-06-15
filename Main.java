package com.company;
interface BasicCharging{
    public void Have();
    public void ChargOn();
    public void ChargOff();
}

interface Charging380V{
    public void Have();
    public void ChargOn();
    public void ChargOff();
}

class Charging220V implements BasicCharging{
    final public int charge = 100;

    @Override
    public void Have(){
        System.out.println("Зарядка есть");
    }
    @Override
    public void ChargOn(){
        System.out.println("Зарядка работает+");
    }
    @Override
    public void ChargOff(){
        System.out.println("Зарядка не работает");
    }
}
class Charg380V implements Charging380V{
    final public int charge = 50;

    @Override
    public void Have(){
        System.out.println("Зарядка на 380В есть");
    }
    @Override
    public void ChargOn(){
        System.out.println("Зарядка на 380В работает");
    }
    @Override
    public void ChargOff(){
        System.out.println("Зарядка на 380В не работает");
    }
}
class ChargAdapter implements BasicCharging{
    Charging380V charging380V;

    public ChargAdapter(Charging380V charging380V){
        this.charging380V = charging380V;
    }
    @Override
    public void Have(){
        charging380V.Have();
    }
    @Override
    public void ChargOn(){
        charging380V.ChargOn();
    }
    @Override
    public void ChargOff(){
        charging380V.ChargOff();
    }
}
class Charging{
    private BasicCharging device;
    public Charging(BasicCharging device){
        this.device = device;
    }
    public void work(){
        device.Have();
        device.ChargOn();
        device.ChargOff();
    }

}
public class Main{
    public static void main(String[] args){
        BasicCharging basic_charging = new Charging220V();
        Charging c220 = new Charging(basic_charging);
        c220.work();
        ChargAdapter charger380V = new ChargAdapter(new Charg380V());
        Charging c380 = new Charging(charger380V);
        c380.work();
    }
}