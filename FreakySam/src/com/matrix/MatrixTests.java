package com.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fractions.Fraction;

public class MatrixTests {

	@Test
	public void test() {
		
		try {
			
			Matrix a = new Matrix("2 -3\n-4 2"),
				   b = new Matrix("-1 -5\n3 -2"),
				   ans = a.add(b),
				   exp = new Matrix("1 -8\n-1 0")
				   ;
			
			
			assertEquals("", exp, ans);
			
			a.setMap("2 -3\n-4 2");
			b.setMap("-1 -5\n3 -2");
			ans = a.sub(b);
			exp.setMap("3 2\n-7 4");
			
			assertEquals("", exp, ans);
			
			a.setMap("3 -5 4\n-1 4 6");
			b.setMap("-1 4 2\n-5 -2 3");
			ans = a.add(b);
			exp.setMap("2 -1 6\n-6 2 9");
			
			assertEquals("", exp, ans);
			
			ans = a.sub(b);
			exp.setMap("4 -9 2\n4 6 3");
			
			assertEquals("", exp, ans);

			a.setMap("-3 1 4\n5 2 -1");
			ans = a.getTranspose();
			exp.setMap("-3 5\n1 2\n4 -1");
			
			assertEquals("", exp, ans);

			a.setMap("2 -5 6\n-1 2 -4\n-3 -1 0");
			ans = a.getTranspose();
			exp.setMap("2 -1 -3\n-5 2 -1\n6 -4 0");
			
			assertEquals("", exp, ans);

			
			a.setMap("-3 1\n-2 4\n5 -1");
			b.setMap("4 -3\n0 -2\n-2 4");
			ans = a.mul(3).sub(b.mul(2));//3A-2B
			exp.setMap("-17 9\n-6 16\n19 -11");
			
			assertEquals("", exp, ans);

			a.setMap("2 1\n5 -3");
			b.setMap("-2 4\n3 -2");
			ans = a.mul(2).add(b.getTranspose());//2A+Bt
			exp.setMap("2 5\n14 -8");
			
			assertEquals("", exp, ans);

			a.setMap("2 1\n5 -3");
			Fraction ans_det = a.getDet();
			Fraction exp_det = new Fraction("-11");
			
			assertEquals("",exp_det,ans_det);


			a.setMap("3 -5\n2 1");
			ans_det = a.getDet();
			exp_det = new Fraction("13");
			
			assertEquals("",exp_det,ans_det);

			a.setMap("-2 4\n-6 2");
			ans_det = a.getDet();
			exp_det = new Fraction("20");
			
			assertEquals("",exp_det,ans_det);

			Matrix A = new Matrix("4 5\n1 -2"),
					   B = new Matrix("0 -1\n-3 2");
			
			Matrix exp_mat = new Matrix("6 8\n3 -4");
			
			assertEquals(exp_mat, A.mul("3/2").sub(B.mul("1/2")));
			
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
