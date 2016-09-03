package crc;


public class CRC {

	private String str;
	private long data[];
	private final long Polynomial;             						  //CCITT��׼��ʽ����ʽת���ɶ�Ӧ�Ķ�����
	private final int R;                                        	  //����ʽ����ߴ���
	
	public CRC(String str) {
		Polynomial = 69665L;                                          //������Ϊ10001000000100001
		R = 16;
		setStr(str);
		char tempChar[] = str.toCharArray();
		data = new long[100];
		for (int i = 0; i < tempChar.length; i++) {
			data[i] = tempChar[i];
		}
		System.out.println("ԭʼ����Ϊ��");
		printCode();
		encode(data);
		System.out.println("CRC����Ϊ��");
		printCode();
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}

	public long[] getData() {
		return data;
	}

	public int getDataNum() {
		int num = 0;
		for (;data[num] != 0; num++);
		return num;
	}

	public void setData(long data[]) {
		this.data = data;
	}
	
	private void encode(long data[]) {
		for (int i = 0; i <= getDataNum(); i++) {          		        
			data[i] = data[i]<<R;									//������16λ��
			long tempData = data[i];				
			while(data[i] > 65535L ){                               //ģ2��(��λ����)��ֱ��data[i]С��R(16)λ65535Ϊ1111111111111111
				long temp1 = data[i];                               
				int temp2 =  0;                                     //temp2Ϊ���λ1��λ��
				while (temp1 != 0) {
					temp1 = temp1>>1;
					temp2++;
				}
				data[i] = data[i] ^ (Polynomial<<(temp2-R-1));
			}
			data[i] = tempData | data[i];                           //���������ں���
		}
	}
	
	public void incode(long data[]) {
		
	}
	
	private void printCode() {                                    //���bitλ�Ķ�������
		for (int i = 0; i < getDataNum(); i++) {
			String tempStr = Long.toBinaryString(data[i]);               //��data[i]ת��Ϊ��Ӧ�Ķ�������
			System.out.println(tempStr);
		}
	}
}





