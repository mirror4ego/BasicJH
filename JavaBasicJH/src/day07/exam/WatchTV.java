package day07.exam;

/*
���θ޼��带 �������� �� �Ʒ��� ���� ��µ� �� �ֵ��� �ڵ� �ۼ�

=============================================
Ƽ�� ������ �մϴ�.
����  TV  ����  :  20
����  TV  ä��  :  7
ä��  36������  ����
ä��  ����
����  TVä��  :  37
TV  ��û  ����
Ƽ�� ������ ���ϴ�.
=============================================
 */

public  class  WatchTV  {
	public  static  void  main(String[]  args)  {
		TV  tv  =  new  TV();
		tv.powerOn();
		System.out.println("����  TV  ����  :  "  +  tv.getVolume());
		System.out.println("����  TV  ä��  :  "  +  tv.getChannel());
		System.out.println("ä��  36������  ����");
		tv.setChannel(36);
		System.out.println("ä��  ����");
		tv.channelUp();	
		System.out.println("����  TVä��  :  "  +  tv.getChannel());
		System.out.println("TV  ��û  ����");
		tv.powerOff();
	}
}