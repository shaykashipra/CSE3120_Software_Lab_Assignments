

interface TV{
//    boolean PowerOn;
//    int volume;
//    int channel;

   boolean isEnabled();
   void enable();
   void disable();
   int getVolume();
   void setVolume(int volume);
   int getChannel();
   void setChannel(int channel);
   

}

class SmartTv implements TV{
   boolean PowerOn;
   int volume;
   int channel;

    public SmartTv(boolean PowerOn,int volume,int channel){
        this.PowerOn=PowerOn;
        this.volume=volume;
        this.channel=channel;
    }
    @Override
    public boolean isEnabled() {
        if(PowerOn) return true;
        return false;
    }

    @Override
    public void enable() {
        PowerOn=true;
    }
    @Override
    public void disable() {
        PowerOn=false;
    }

    @Override
    public int getVolume() {
        
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume=volume;
    }

    @Override
    public int getChannel() {
      
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }




    void Youtube(){
        System.out.println("Accessed Yoututbe");
    }
}


class GeneralTv implements TV{
   boolean PowerOn;
   int volume;
   int channel;

    public GeneralTv(boolean PowerOn,int volume,int channel){
        this.PowerOn=PowerOn;
        this.volume=volume;
        this.channel=channel;
    }
    @Override
    public boolean isEnabled() {
        if(PowerOn) return true;
        return false;
    }

    @Override
    public void enable() {
        PowerOn=true;
    }
    @Override
    public void disable() {
        PowerOn=false;
    }

    @Override
    public int getVolume() {
        
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume=volume;
    }

    @Override
    public int getChannel() {
      
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
}


 class Remote{
    protected TV tv;
    public Remote(TV tv){
        this.tv=tv;
    }
    
     void togglePower(){
        if(tv.isEnabled()){
            tv.disable();
            System.out.println("TV turned off");
        }
        else{
            tv.enable();
            System.out.println("TV turned on");

        }
     }

    void volumeUp(){
        if(!tv.isEnabled()){
            System.out.println("1st Turn the power on");
            return;
        }
        if(tv.getVolume()==100){
            System.out.println("Volume can't be more than 100");
            return;
        }
        tv.setVolume(tv.getVolume()+1);
        System.out.println("volume"+tv.getVolume());
    }

    void volumeDown(){
        if(!tv.isEnabled()){
            System.out.println("1st Turn the power on");
            return;
        }
        if(tv.getVolume()==0){
            System.out.println("Volume can't be less than 0");
            return;
        }
        tv.setVolume(tv.getVolume()-1);
     System.out.println("volume"+tv.getVolume());

    }

    void channelUp(){
        if(!tv.isEnabled()){
            System.out.println("1st Turn the power on");
            return;
        }

        tv.setChannel(tv.getChannel()+1);
        System.out.println("channel no"+tv.getChannel());
    }


    void channelDown(){
        if(!tv.isEnabled()){
            System.out.println("1st Turn the power on");
            return;
        }
         tv.setChannel(tv.getChannel()-1);
        System.out.println("channel no"+tv.getChannel());


    }


}


class SmartRemote extends Remote{
    public SmartRemote(TV tv){
        super(tv);
    }
    
    
    void showYoutube(){
        if(!tv.isEnabled()){
            System.out.println("1st Turn the power on");
            return;
        }
        ((SmartTv)tv).Youtube();
        System.out.println("showing youtube from using SmartRemote");
    }
}


public class Bridge_Pattern{
    public static void main(String[] args) {
        GeneralTv gTv=new GeneralTv(false, 0, 0);
        SmartTv sTv=new SmartTv(true, 0, 0);
        Remote gRemote=new Remote(gTv);
        
        // General TV accessed by Remote
         gRemote.togglePower();
         gRemote.channelUp();

     // General TV accessed by Smart Remote
          

        SmartRemote sRemote=new SmartRemote(gTv);
        sRemote.togglePower();
        sRemote.channelUp();

     //Smart TV accessed by Remote

     gRemote=new Remote(sTv);
     gRemote.togglePower();

     //     //Smart TV accessed by Smart Remote
        
    sRemote=new SmartRemote(sTv);
    sRemote.togglePower();
    sRemote.showYoutube();

        // accessing YouTube() from sTv.Youtube();
       
        sRemote.showYoutube();
       
        sRemote.togglePower();

    }
}