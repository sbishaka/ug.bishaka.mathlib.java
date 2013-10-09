package com.matrix;

public class Float_Matrix {
	
	private int rowCount;
	private int columnCount;		
	private float[][] map;
	private static String COL_DELIM = " ",ROW_DELIM = "\n";
	
	public Float_Matrix() {
		super();
	}

	
	
	public Float_Matrix(String map)
	{
		/*
		 * Expects string containing rows separated by \n and columns separated by space
		 * */
		this.rowCount = map.split(ROW_DELIM).length;
		this.columnCount = map.split(ROW_DELIM)[0].trim().split(COL_DELIM).length;
		this.map = new float[rowCount][columnCount];
		
		try {
			this.setMap(map);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Float_Matrix(int rowCount, int columnCount) {
		super();
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		
		this.map = new float[rowCount][columnCount];
	}

	public Float_Matrix(float[][] map) {
		super();
		this.map = map;
		this.rowCount = map.length;
		this.columnCount = map[0].length;
	}
	
	public static float dotProduct( float[] l, float[] r ) throws MatrixException
	{
		float result = 0;
		
		if( l.length != r.length )
			throw new MatrixException("left and right column entries are not the same size\nleft size : " + l.length + "\nright size :" + r.length);
		
		for( int i = 0; i < l.length; i++ )
		{
			result += l[i]*r[i];
		}
		
		return result;
	}
	
	public Float_Matrix div( Float_Matrix operand ) throws MatrixException
	{
		return this.mul(operand.getInverse());
	}
	
	public void setEntry( int row_pos, int col_pos, float val )
	{
		this.map[row_pos][col_pos] = val;
	}
	
	public void setRow( int row_no, String info ) throws MatrixException
	{
		String[] tokens = info.trim().split(COL_DELIM);
		if( tokens.length != this.columnCount )
			throw new MatrixException("Column count mismatch on input : "+info+"\nExpected " + this.columnCount + " entries\nRecieved " + tokens.length + " entries");
		
		for( int i = 0; i < this.columnCount;i++ )
			this.map[row_no][i] = Float.parseFloat(tokens[i]);
		
	}
	
	public Float_Matrix add( Float_Matrix r ) throws MatrixException
	{
		String  map = "";
		
		if( this.getRowCount() != r.getRowCount() )
			throw new MatrixException("Rows do not match");
		
		if( this.getColumnCount() != r.getColumnCount() )
			throw new MatrixException("Columns do not match");
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			float[] clRow = this.getRow(i), crRow = r.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += (clRow[j]+crRow[j]) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Float_Matrix(map);
	}

	public Float_Matrix sub( Float_Matrix r ) throws MatrixException
	{
		String  map = "";
		
		if( this.getRowCount() != r.getRowCount() )
			throw new MatrixException("Rows do not match");
		
		if( this.getColumnCount() != r.getColumnCount() )
			throw new MatrixException("Columns do not match");
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			float[] clRow = this.getRow(i), crRow = r.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += (clRow[j]-crRow[j]) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Float_Matrix(map);
	}

	public Float_Matrix mul(float constant)
	{
		String  map = "";
		
		for( int i = 0; i < this.getRowCount(); i++ )
		{
			float[] clRow = this.getRow(i);
			
			for( int j = 0; j < this.getColumnCount(); j++ )
			{
				map += (clRow[j]*constant) + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Float_Matrix(map);		
	}

	public Float_Matrix mul(Float_Matrix operand) throws MatrixException
	{
		if( this.columnCount != operand.getRowCount() )
			throw new MatrixException("Cannot multiply matrices, rows and columns mismatch( Left columns != right rows  )\nLeft : " + this + "\nRight :" + operand);

		String map = "";
		float[] currentRow;
		float[] currentCol;
		
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
		
		return new Float_Matrix(map);
	}
	
	public Float_Matrix neg()
	{
		return this.mul(-1);
	}

	public float[] getRow( int row_no )
	{
		float[] result = new float[this.columnCount];
		
		for( int i = 0; i < this.columnCount; i++ )
		{
			result[i] = this.map[row_no][i];
		}
		
		return result;
	}
	

	public float[] getCol( int col_no )
	{
		float[] result = new float[this.rowCount];
		
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

	public Float_Matrix getTranspose()
	{
		String map = "";
		float[] currentCol;
		for( int i = 0; i < this.columnCount; i++ )
		{
			currentCol = this.getCol(i);
			for( int j = 0; j < this.getRowCount(); j++ )
			{
				map += currentCol[j] + COL_DELIM;
			}
			map += ROW_DELIM;
		}
		
		return new Float_Matrix(map); 
	}
	
	public float getRowCount() {
		return rowCount;
	}


	public float getDet( )
	{
		float result = 0;
		if( this.rowCount == 2 && this.columnCount == 2 )
		{
			result = this.map[0][0]*this.map[1][1] - this.map[0][1]*this.map[1][0];
		}
		else if( (this.rowCount == this.columnCount)&&(this.rowCount > 1 || this.columnCount > 1) )
		{
				for( int j = 0;j < columnCount; j++ )
				{
					if( j%2==0 )
					{
						result += this.map[0][j]*this.getSubMatrixForDet(0, j).getDet();
					}
					else
					{
						result -= this.map[0][j]*this.getSubMatrixForDet(0, j).getDet();
					}
				}
		}
		
		return result;
	}
	
	public Float_Matrix getInverse( )
	{
		Float_Matrix result = null;
		if( this.rowCount == 2 && this.columnCount == 2 )
		{
				result = getInverse_2x2();
		}
		else if( (this.rowCount == this.columnCount)&&(this.rowCount > 1 || this.columnCount > 1) )
		{
				result = this.getAdjugateMatrix().mul(1/this.getDet());
		}
		
		return result;
	}

	private Float_Matrix getInverse_2x2()
	{
		Float_Matrix result = new Float_Matrix(this.rowCount, this.columnCount);

		result = new Float_Matrix(this.rowCount, this.columnCount);
		result.getMap()[0][0] = this.getMap()[1][1];
		result.getMap()[1][1] = this.getMap()[0][0];
		
		result.getMap()[1][0] = this.getMap()[1][0]*-1;
		result.getMap()[0][1] = this.getMap()[0][1]*-1;
		result = result.mul(1/this.getDet());
		
		return result;
	}
	
	private Float_Matrix getSubMatrixForDet( float row_pos, float col_pos )
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
		
		return new Float_Matrix(map);
	}
	
	public Float_Matrix getMinorsMatrix()
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
		
		return new Float_Matrix(map);
	}

	public Float_Matrix getCofactorsMatrix()
	{
		Float_Matrix minors = this.getMinorsMatrix();
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
					map += (minors.getMap()[i][j]*-1)+COL_DELIM;
				}
			}
			
			map += ROW_DELIM;
		}
		
		return new Float_Matrix(map);
	}

	public Float_Matrix getAdjugateMatrix()
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


	public float[][] getMap() {
		return map;
	}


	public void setMap(float[][] map) {
		this.rowCount = map.length;
		this.columnCount = map[0].length;
		this.map = map;
	}


	public void setMap(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.map = new float[rowCount][columnCount];
	}

	
	public void setMap(String map) throws MatrixException{
		/*
		 * Expects string containing rows separated by \n and columns separated by space
		 * */
		String[] rows = map.split(ROW_DELIM);
		this.rowCount = rows.length;
		this.columnCount = rows[0].split(COL_DELIM).length;
		this.map = new float[this.rowCount][this.columnCount];
		
		for( int i = 0; i < this.rowCount; i++ )
			this.setRow(i, rows[i]);
	}
	
	
	
	
	@Override
	public boolean equals(Object op) {
		Float_Matrix operand = (Float_Matrix)op;
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
					if( !(operand.getMap()[i][j] == this.getMap()[i][j]) )
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
		
}
