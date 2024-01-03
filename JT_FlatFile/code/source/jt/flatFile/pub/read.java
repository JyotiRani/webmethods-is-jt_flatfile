package jt.flatFile.pub;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataUtil;
// --- <<IS-END-IMPORTS>> ---

public final class read

{
	// ---( internal utility methods )---

	final static read _instance = new read();

	static read _newInstance() { return new read(); }

	static read _cast(Object o) { return (read)o; }

	// ---( server methods )---




	public static final void isFileCsvOrFixedLength (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isFileCsvOrFixedLength)>> ---
		// @sigtype java 3.5
		// [i] field:0:required filePath
		// [i] field:0:required charsToScan
		// [i] field:0:required separatorChar
		// [o] field:0:required isCsv {"true","false"}
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	filePath = IDataUtil.getString( pipelineCursor, "filePath" );
			int	charsToScan = IDataUtil.getInt( pipelineCursor, "charsToScan",2048 );
		
		String sepStr = IDataUtil.getString( pipelineCursor, "separatorChar" );
		char separator = sepStr.charAt(0);
		
		InputStream fis = null;
		BufferedReader br = null;
		char[] cbuf = new char[charsToScan];
		
		boolean isCsv = false;
			
		try {
			fis = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fis));
		
			if (br.ready()) {
				 br.read(cbuf);
				 for (int i = 0; i < cbuf.length; i++) {
					if (cbuf[i] == separator) {
						isCsv = true;
						break;
					}
				}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		IDataUtil.put( pipelineCursor, "isCsv", "" + isCsv );
		pipelineCursor.destroy();
			
			
		// --- <<IS-END>> ---

                
	}



	public static final void removeFirstLineFromStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeFirstLineFromStream)>> ---
		// @sigtype java 3.5
		// [i] object:0:required stream
		// [o] object:0:required stream
		// [o] field:0:required firstLine
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		BufferedInputStream	bis = (BufferedInputStream) IDataUtil.get( pipelineCursor, "stream" );
		
		StringBuilder sb = new StringBuilder();
		
		try {
			while (true) {
				char c = (char) bis.read();
				if (c == 0x0a || c == 0x0d) {
					bis.mark(1);
					c = (char) bis.read();
					if (c != 0x0a && c != 0x0d) {
						bis.reset();
					}
					break;
				}
				sb.append(c);
			}
		
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		
		
		IDataUtil.put( pipelineCursor, "stream", bis );
		IDataUtil.put( pipelineCursor, "firstLine", sb.toString() );
		pipelineCursor.destroy();
			
			
			
			
			
			
			
			
			
			
			
			
			
		// --- <<IS-END>> ---

                
	}



	public static final void removeFirstLineFromString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeFirstLineFromString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required in
		// [o] field:0:required out
		// [o] field:0:required firstLine
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	in = IDataUtil.getString( pipelineCursor, "in" );
			
		StringBuilder sb = new StringBuilder(in);
		StringBuilder fl = new StringBuilder();
		
		
		while (true) {
			char c = sb.charAt(0);
			sb.deleteCharAt(0);
			
			if (c == 0x0a || c == 0x0d) {
				c = sb.charAt(0);
				if (c != 0x0a && c != 0x0d) {
					break;
				}
			} else {
				fl.append(c);
			}
		}
		
		IDataUtil.put( pipelineCursor, "out", sb.toString() );
		IDataUtil.put( pipelineCursor, "firstLine", fl.toString() );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

