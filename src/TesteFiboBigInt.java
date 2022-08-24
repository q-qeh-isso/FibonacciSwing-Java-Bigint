import java.math.BigInteger;
import java.util.Scanner;

public class TesteFiboBigInt {

	public BigInteger[] mostraSequencia(int num){
		BigInteger[] fbArr = new BigInteger[num];
		fbArr[0] = BigInteger.ZERO;
		fbArr[1] = BigInteger.ONE;
		fbArr[2] = BigInteger.ONE;
		for(int i = 0; i<fbArr.length; i++){
			if(i == 0){
				fbArr[i] = BigInteger.ZERO;
			} else if(i <= 2){
				fbArr[i] = BigInteger.ONE;
			} else {
				fbArr[i] = fbArr[i-2].add(fbArr[i-1]);
			}
		}
		
		return fbArr;
	}

}
