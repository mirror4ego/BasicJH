package day07.exam;

public class TV {
	private int volume = 20;
	private int channel = 7;
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}	
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
	public void powerOn() {
		System.out.println("티비 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("티비 전원을 끕니다.");
		System.exit(0);
	}

}
