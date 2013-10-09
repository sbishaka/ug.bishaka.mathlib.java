
package com.matrix;

import com.angles.Angle;
import com.angles.Degree;
import com.angles.Radian;
import com.fractions.Fraction;
import com.points.Point;

public class Matrix {
	
	private int rowCount;
	private int columnCount;		
	private Fraction[][] map;
	private static String COL_DELIM = " ",ROW_DELIM = "\n";
	
	public Matrix() {
		super();
	}
	
	public Matrix(String map)
	{
		/*
		 * Expects string containing rows separated by \n and columns separated by space
		 * */
		this.rowCount = map.split(ROW_DELIM).length;
		this.columnCount = map.split(ROW_DELIM)[0].trim().split(COL_DELIM).length;
		this.map = new Fraction[rowCount][columnCount];
		
		try {
			this.setMap(map);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Matrix(int rowCount, int columnCount) {
		super();
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		
		this.map = new Fraction[rowCount][columnCount];
	}

	public Matrix(Fraction[][] map) {
		super();
		this.map = map;
		this.rowCount = map.length;
		this.columnCount = map[0].length;
	}
	
	public static Fraction dotProduct( Fraction[] l, Fraction[] r ) throws MatrixException
	{
		Fraction result = new Fraction("0");
		
		if( l.length != r.length )
			throw new MatrixException("left and right column entries are not the same size\nleft size : " + l.length + "\nright size :" + r.length);
		
		for( int i = 0; i < l.length; i++ )
		{
			result = result.add(l[i].mul(r[i]));
		}
		
		return result;
	}
	
	public Matrix div( Matrix operand ) throws MatrixException
	{
		return this.mul(operand.getInverse());
	}

	public void setEntry( int row_pos, int col_pos, Fraction val )
	{
		this.map[row_pos][col_pos] = val;
	}

	public Fraction getEntry(int row_pos, int col_pos)
	{
		return this.map[row_pos][col_pos];
	}
	
	public void setEntry( int row_pos, int col_pos, String val )
	{
		setEntry(row_pos, col_pos, new Fraction(val));
	}
	
	public void setEntry( int row_pos, int col_pos, float val )
	{
		setEntry(row_pos, col_pos, new Fraction(val+""));
	}
	
	public void setRow( int row_no, String info ) throws MatrixException
	{
		String[] tokens = info.trim().split(COL_DELIM);
		if( tokens.length != this.columnCount )
			throw new MatrixException("Column count mismatch on input : "+info+"\nExpected " + this.columnCount + " entries\nRecieved " + tokens.length + " entries");
		
		for( int i = 0; i < this.columnCount;i++ )
			this.map[row_no][i] = new Fraction(tokens[i]);
		
	}
	
	public Matrix add( Matrix r ) throws MatrixException
	{
		String  map = "";
		
		if( this.getRowCount() != r.getRowCount() )
			throw new MatrixException("Rows do not match");
		
		if( this.getColumnCount() != r.getColumnCount() )
			throw new MatrixException("Columns do not match");
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			Fraction[] clRow = this.getRow(i), crRow = r.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += clRow[j].add(crRow[j]) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}

	public Matrix sub( Matrix r ) throws MatrixException
	{
		String  map = "";
		
		if( this.getRowCount() != r.getRowCount() )
			throw new MatrixException("Rows do not match");
		
		if( this.getColumnCount() != r.getColumnCount() )
			throw new MatrixException("Columns do not match");
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			Fraction[] clRow = this.getRow(i), crRow = r.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += clRow[j].sub(crRow[j]) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}

	public Matrix mul(Fraction constant)
	{
		String  map = "";
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			Fraction[] clRow = this.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += clRow[j].mul(constant) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);		
	}

	public Matrix mul(String constant)
	{		
		return mul(new Fraction(constant));		
	}

	public Matrix mul(Matrix operand) throws MatrixException
	{
		if( this.columnCount != operand.getRowCount() )
			throw new MatrixException("Cannot multiply matrices, rows and columns mismatch( Left columns != right rows  )\nLeft : " + this + "\nRight :" + operand);

		String map = "";
		Fraction[] currentRow;
		Fraction[] currentCol;
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			currentRow = this.getRow(i);
			for( int j = 0; j < operand.getColumnCount(); j++ )
			{
				currentCol = operand.getCol(j);
				map += dotProduct(currentRow, currentCol) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}
	
	public Matrix neg()
	{
		return this.mul(-1);
	}

	public Matrix mul(int i) {
		// TODO Auto-generated method stub
		return mul(new Fraction(i+""));
	}

	public Fraction[] getRow( int row_no )
	{
		Fraction[] result = new Fraction[this.columnCount];
		
		for( int i = 0; i < this.columnCount; i++ )
		{
			result[i] = this.map[row_no][i];
		}
		
		return result;
	}
	
	public Fraction[] getCol( int col_no )
	{
		Fraction[] result = new Fraction[this.rowCount];
		
		for( int i = 0; i < this.rowCount; i++ )
		{
			result[i] = this.map[i][col_no];
		}
		
		return result;
	}

	public String getCol_str( int col_no )
	{
		String result = "";
		
		for( int i = 0; i < this.rowCount; i++ )
		{
			result += this.map[i][col_no] + COL_DELIM;
		}
		
		return result;
	}

	public Matrix getTranspose()
	{
		String map = "";
		Fraction[] currentCol;
		for( int i = 0; i < this.columnCount; i++ )
		{
			currentCol = this.getCol(i);
			for( int j = 0; j < this.getRowCount(); j++ )
			{
				map += currentCol[j] + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map); 
	}
	
	public int getRowCount() {
		return rowCount;
	}

	public Fraction getDet( )
	{
		Fraction result = new Fraction("0");
		if( this.rowCount == 2 && this.columnCount == 2 )
		{
			result = this.map[0][0].mul(this.map[1][1]).sub(this.map[0][1].mul(this.map[1][0]));
		}
		else if( (this.rowCount == this.columnCount)&&(this.rowCount > 1 || this.columnCount > 1) )
		{
				for( int j = 0;j < columnCount; j++ )
				{
					if( j%2==0 )
					{
						result = result.add(this.map[0][j].mul(this.getSubMatrixForDet(0, j).getDet()));
					}
					else
					{
						result = result.sub(this.map[0][j].mul(this.getSubMatrixForDet(0, j).getDet()));
					}
				}
		}
		
		return result;
	}
	
	public Matrix getInverse( )
	{
		Matrix result = null;
		if( this.rowCount == 2 && this.columnCount == 2 )
		{
				result = getInverse_2x2();
		}
		else if( (this.rowCount == this.columnCount)&&(this.rowCount > 1 || this.columnCount > 1) )
		{
				result = this.getAdjugateMatrix().mul(this.getDet().reciprical());
		}
		
		return result;
	}
	
	public static Point translate( Point start, Fraction dx, Fraction dy, Fraction dz )
	{
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 3, dx);
		buff_t.setEntry(1, 3, dy);
		buff_t.setEntry(2, 3, dz);
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_t.mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Point scale( Point start, Fraction sx, Fraction sy, Fraction sz )
	{
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 0, sx);
		buff_t.setEntry(1, 1, sy);
		buff_t.setEntry(2, 2, sz);
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_t.mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Point scale( Point start, Fraction sx, Fraction sy, Fraction sz, Point pivot )
	{
		//Translates to origin
		Matrix buff_trOrg = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trOrg.setEntry(0, 3, pivot.getX());
		buff_trOrg.setEntry(1, 3, pivot.getY());
		buff_trOrg.setEntry(2, 3, pivot.getZ());
		
		//Translates to original position
		Matrix buff_trPos = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trPos.setEntry(0, 3, pivot.getX().neg());
		buff_trPos.setEntry(1, 3, pivot.getY().neg());
		buff_trPos.setEntry(2, 3, pivot.getZ().neg());
		
		//Scales object
		Matrix buff_scMat = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_scMat.setEntry(0, 0, sx);
		buff_scMat.setEntry(1, 1, sy);
		buff_scMat.setEntry(2, 2, sz);
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_trOrg.mul(buff_scMat).mul(buff_trPos).mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Point scale( String start, String sx, String sy, String sz, String pivot )
	{
		return scale(new Point(start), new Fraction(sx), new Fraction(sy), new Fraction(sz), new Point(pivot));
	}

	public static Point rotX(Point start, Angle theta)
	{
		
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(1, 1, theta.cos());
		buff_t.setEntry(1, 2, theta.sin().neg());
		buff_t.setEntry(2, 1, theta.sin());
		buff_t.setEntry(2, 2, theta.cos());
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_t.mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Matrix rotX_mat(Angle theta)
	{
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(1, 1, theta.cos());
		buff_t.setEntry(1, 2, theta.sin().neg());
		buff_t.setEntry(2, 1, theta.sin());
		buff_t.setEntry(2, 2, theta.cos());
				
		return buff_t;	
	}

	public static Matrix rotX_mat(String theta)
	{
		return rotX_mat(new Degree(theta));
	}
	
	public static Point rotX(Point start, Angle theta, Point pivot)
	{

		//Translates to origin
		Matrix buff_trOrg = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trOrg.setEntry(0, 3, pivot.getX());
		buff_trOrg.setEntry(1, 3, pivot.getY());
		buff_trOrg.setEntry(2, 3, pivot.getZ());
		
		//Translates to original position
		Matrix buff_trPos = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trPos.setEntry(0, 3, pivot.getX().neg());
		buff_trPos.setEntry(1, 3, pivot.getY().neg());
		buff_trPos.setEntry(2, 3, pivot.getZ().neg());

		//Rotates object
		Matrix buff_rotMat = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_rotMat.setEntry(1, 1, theta.cos());
		buff_rotMat.setEntry(1, 2, theta.sin().neg());
		buff_rotMat.setEntry(2, 1, theta.sin());
		buff_rotMat.setEntry(2, 2, theta.cos());
		
		Matrix point = new Matrix("0\n0\n0\n1");
		point.setEntry(0, 0, start.getX());
		point.setEntry(1, 0, start.getY());
		point.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_trOrg.mul(buff_rotMat).mul(buff_trPos).mul(point);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}
	
	public static Point rotX(String start, String theta, String pivot)
	{
		return rotX(new Point(start), new Degree(theta), new Point(pivot));
	}
	
	public static Point rotX(String start, String theta)
	{
		return rotX(new Point(start),new Degree(theta));
	}
	
	public static void rotX(Angle theta, Point... points)
	{
		for(Point point : points)
		{
			point.setPoint(rotX(point, theta));
		}
	}

	public static void rotX(String theta, Point... points)
	{
		rotX(new Degree(theta), points);
	}
	
	public static Point rotY(Point start, Angle theta)
	{
		
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 0, theta.cos());
		buff_t.setEntry(0, 2, theta.sin());
		buff_t.setEntry(2, 0, theta.sin().neg());
		buff_t.setEntry(2, 2, theta.cos());
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_t.mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Matrix rotY_mat(Angle theta)
	{
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 0, theta.cos());
		buff_t.setEntry(0, 2, theta.sin());
		buff_t.setEntry(2, 0, theta.sin().neg());
		buff_t.setEntry(2, 2, theta.cos());
		
		return buff_t;
	}

	public static Matrix rotY_mat(String theta)
	{
		return rotY_mat(new Degree(theta));
	}
	
	public static Point rotY(Point start, Angle theta, Point pivot)
	{
		
		//Translates to origin
		Matrix buff_trOrg = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trOrg.setEntry(0, 3, pivot.getX());
		buff_trOrg.setEntry(1, 3, pivot.getY());
		buff_trOrg.setEntry(2, 3, pivot.getZ());
		
		//Translates to original position
		Matrix buff_trPos = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trPos.setEntry(0, 3, pivot.getX().neg());
		buff_trPos.setEntry(1, 3, pivot.getY().neg());
		buff_trPos.setEntry(2, 3, pivot.getZ().neg());

		//Rotates object		
		Matrix buff_rotMat = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_rotMat.setEntry(0, 0, theta.cos());
		buff_rotMat.setEntry(0, 2, theta.sin());
		buff_rotMat.setEntry(2, 0, theta.sin().neg());
		buff_rotMat.setEntry(2, 2, theta.cos());
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
			result = buff_trOrg.mul(buff_rotMat).mul(buff_trPos).mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Point rotY(String start, String theta, String pivot)
	{
		return rotY(new Point(start), new Degree(theta), new Point(pivot));
	}
	
	public static Point rotY(String start, String theta)
	{
		return rotY(new Point(start),new Degree(theta));
	}	
	
	public static void rotY(Angle theta, Point... points)
	{
		for(Point point : points)
		{
			point.setPoint(rotY(point, theta));
		}
	}

	public static void rotY(String theta, Point... points)
	{
		rotY(new Degree(theta), points);
	}

	public static Point rotZ(Point start, Angle theta)
	{
		
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 0, theta.cos());
		buff_t.setEntry(0, 1, theta.sin().neg());
		buff_t.setEntry(1, 0, theta.sin());
		buff_t.setEntry(1, 1, theta.cos());
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		Matrix result = null;
		try {
				result = buff_t.mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Matrix rotZ_mat(Angle theta)
	{
		
		Matrix buff_t = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_t.setEntry(0, 0, theta.cos());
		buff_t.setEntry(0, 1, theta.sin().neg());
		buff_t.setEntry(1, 0, theta.sin());
		buff_t.setEntry(1, 1, theta.cos());
		
		return buff_t;
	}
	
	public static Matrix rotZ_mat(String theta)
	{
		return rotZ_mat(new Degree(theta));
	}
	
	public static Point rotZ(Point start, Angle theta, Point pivot)
	{
		
		//Translates to origin
		Matrix buff_trOrg = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trOrg.setEntry(0, 3, pivot.getX());
		buff_trOrg.setEntry(1, 3, pivot.getY());
		buff_trOrg.setEntry(2, 3, pivot.getZ());
		
		
		
		//Translates to original position
		Matrix buff_trPos = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_trPos.setEntry(0, 3, pivot.getX().neg());
		buff_trPos.setEntry(1, 3, pivot.getY().neg());
		buff_trPos.setEntry(2, 3, pivot.getZ().neg());
		
		//Rotates object
		Matrix buff_rotMat = new Matrix("1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1");
		buff_rotMat.setEntry(0, 0, theta.cos());
		buff_rotMat.setEntry(0, 1, theta.sin().neg());
		buff_rotMat.setEntry(1, 0, theta.sin());
		buff_rotMat.setEntry(1, 1, theta.cos());
		
		Matrix operand = new Matrix("0\n0\n0\n1");
		operand.setEntry(0, 0, start.getX());
		operand.setEntry(1, 0, start.getY());
		operand.setEntry(2, 0, start.getZ());
		
		

		
		Matrix result = null;
		try {
			result = buff_trOrg.mul(buff_rotMat).mul(buff_trPos).mul(operand);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}

	public static Point rotZ(String start, String theta, String pivot)
	{
		return rotZ(new Point(start), new Degree(theta), new Point(pivot));
	}
	
	public static Point rotZ(String start, String theta)
	{
		return rotZ(new Point(start),new Degree(theta));
	}

	public static void rotZ(Angle theta, Point... points)
	{
		for(Point point : points)
		{
			point.setPoint(rotZ(point, theta));
		}
	}

	public static void rotZ(String theta, Point... points)
	{
		rotZ(new Degree(theta), points);
	}
		
	public static void scale(String sx, String sy, String sz, Point... points )
	{
		scale(new Fraction(sx), new Fraction(sy), new Fraction(sz), points);
	}
	
	public static void scale(Fraction sx, Fraction sy, Fraction sz, Point... points )
	{
		for( Point start : points )
		{
			start.setPoint( scale(start, sx, sy, sz) );
		}
	}

	public static Point scale( String start, String sx, String sy, String sz )
	{
		return scale(new  Point(start), new Fraction(sx), new Fraction(sy), new Fraction(sz));
	}
	
	public static Point translate( String start, String dx, String dy, String dz )
	{
		return translate(new Point(start), new Fraction(dx), new Fraction(dy), new Fraction(dz));
	}

	private Matrix getInverse_2x2()
	{
		Matrix result = new Matrix(this.rowCount, this.columnCount);

		result = new Matrix(this.rowCount, this.columnCount);
		result.getMap()[0][0] = this.getMap()[1][1];
		result.getMap()[1][1] = this.getMap()[0][0];
		
		result.getMap()[1][0] = this.getMap()[1][0].mul(-1);
		result.getMap()[0][1] = this.getMap()[0][1].mul(-1);
		result = result.mul(this.getDet().reciprical());
		
		return result;
	}
	
	private Matrix getSubMatrixForDet( float row_pos, float col_pos )
	{
		String map = "";
		for( int i = 0; i < this.rowCount; i++ )
		{
			if(i == row_pos)
				continue;
			
			for( int j = 0; j < this.columnCount; j++ )
			{
				
				if(j==col_pos)
					continue;
				
				map += this.map[i][j] + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}
	
	public Matrix getMinorsMatrix()
	{
		String map = "";
		
		for( int i = 0; i < this.rowCount; i++ )
		{
			for( int j = 0; j < this.columnCount; j++ )
			{
				map += this.getSubMatrixForDet(i, j).getDet() + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}

	public Matrix getCofactorsMatrix()
	{
		Matrix minors = this.getMinorsMatrix();
		String map = "";
		int g = 0;
		
		for( int i = 0; i < minors.rowCount; i++ )
		{
			for( int j = 0; j < minors.columnCount; j++, g++ )
			{
				if( g%2==0 ) 
				{
					map += minors.getMap()[i][j]+COL_DELIM;
				}
				else
				{
					map += minors.getMap()[i][j].mul(-1)+COL_DELIM;
				}
			}
			
			map += ROW_DELIM;
		}
		
		return new Matrix(map);
	}

	public Matrix getAdjugateMatrix()
	{
		return this.getCofactorsMatrix().getTranspose();
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public float getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public Fraction[][] getMap() {
		return map;
	}

	public void setMap(Fraction[][] map) {
		this.rowCount = map.length;
		this.columnCount = map[0].length;
		this.map = map;
	}

	public void setMap(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.map = new Fraction[rowCount][columnCount];
	}

	public void setMap(String map) throws MatrixException{
		/*
		 * Expects string containing rows separated by \n and columns separated by space
		 * */
		String[] rows = map.split(ROW_DELIM);
		this.rowCount = rows.length;
		this.columnCount = rows[0].split(COL_DELIM).length;
		this.map = new Fraction[this.rowCount][this.columnCount];
		
		for( int i = 0; i < this.rowCount; i++ )
			this.setRow(i, rows[i]);
	}
	
	@Override
	public boolean equals(Object op) {
		Matrix operand = (Matrix)op;
		// TODO Auto-generated method stub
		boolean result = true;
		if( !(operand.getRowCount() == this.getRowCount() 
				&& operand.getColumnCount()==this.getColumnCount() ))
		{
			result = false;
		}
		else
		{
			for( int i =0; i<this.rowCount; i++ )
			{
				for( int j = 0; j < this.columnCount; j++ )
				{
					if( !(operand.getMap()[i][j].equals(this.getMap()[i][j])) )
						result = false;
						
				}
			}
		}
			
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "\n";
		
		for( int i = 0; i < rowCount; i++ )
		{
			for( int j = 0; j < columnCount; j++ )
			{
				result += this.map[i][j] + COL_DELIM;
			}
			result += ROW_DELIM;
		}
		
		return result;
	}

	public static void setCOL_DELIM(String cOL_DELIM) {
		COL_DELIM = cOL_DELIM;
	}

	public static void setROW_DELIM(String rOW_DELIM) {
		ROW_DELIM = rOW_DELIM;
	}
			
}
